package com.atecher.blog.web.console;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atecher.blog.web.common.GenericActionController;
import com.atecher.blog.web.util.WebForwardConstants;
import com.atecher.blog.web.util.ueditor.ActionEnter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 描述：负责后台文章管理
 *
 * @作者 mark.han
 * @邮箱 hongwei.han@qq.com
 * @日期 2014-7-29
 * @版本 v1.0
 */
@Controller

public class FileUploadController extends GenericActionController {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * 描述：文章查询
     *
     * @return
     * @作者 mark.han
     * @日期 2014-7-29
     * @邮箱 hongwei.han@qq.com
     */
    @RequestMapping(value = "/manage/upload")
    @ResponseBody
    public JSONObject index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String rootPath = request.getSession().getServletContext().getRealPath( "/" );
        String result=new ActionEnter(request, rootPath).exec();
        return JSON.parseObject(result);
    }


}
