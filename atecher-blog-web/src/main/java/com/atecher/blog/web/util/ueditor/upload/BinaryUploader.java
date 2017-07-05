package com.atecher.blog.web.util.ueditor.upload;

import com.atecher.blog.web.util.ueditor.PathFormat;
import com.atecher.blog.web.util.ueditor.define.AppInfo;
import com.atecher.blog.web.util.ueditor.define.BaseState;
import com.atecher.blog.web.util.ueditor.define.FileType;
import com.atecher.blog.web.util.ueditor.define.State;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BinaryUploader {

    public static State save(HttpServletRequest request, Map<String, Object> conf) {
        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> multiFiles = multiRequest.getFileMap();
            Iterator<Map.Entry<String, MultipartFile>> entSet = multiFiles.entrySet().iterator();
            while (entSet.hasNext()) {
                try {
                    Map.Entry<String, MultipartFile> entry = entSet.next();
                    MultipartFile multipartFile = entry.getValue();
                    String savePath = (String) conf.get("savePath");
                    String originFileName = multipartFile.getOriginalFilename();
                    String suffix = FileType.getSuffixByFilename(originFileName);

                    originFileName = originFileName.substring(0,
                            originFileName.length() - suffix.length());
                    savePath = savePath + suffix;

                    long maxSize = (Long) conf.get("maxSize");

                    if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
                        return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
                    }

                    savePath = PathFormat.parse(savePath, originFileName);

                    String physicalPath = conf.get("rootPath") + savePath;

                    InputStream is = multipartFile.getInputStream();
                    State storageState = StorageManager.saveFileByInputStream(is, physicalPath, maxSize);
                    is.close();

                    if (storageState.isSuccess()) {
                        storageState.putInfo("url", PathFormat.format(savePath));
                        storageState.putInfo("type", suffix);
                        storageState.putInfo("original", originFileName + suffix);
                    }

                    return storageState;
                } catch (IOException e) {
                    return new BaseState(false, AppInfo.IO_ERROR);
                }
            }
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}
