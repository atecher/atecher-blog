package com.atecher.blog.web.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiteMap {
	
	private static SiteMap siteMap;
	private Document document;
	private Element urlSet;
	private final SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	
	public static SiteMap getInstance(){
		if(siteMap!=null){
			return siteMap;
		}else{
			siteMap=new SiteMap();
			return siteMap;
		}
	}
	
	public void init(){
		document = DocumentHelper.createDocument();  
		urlSet = document.addElement("urlset");//添加文档根  
	}
	public void addUrl(String loc,Date lastMod,String changefreq,String priority){
		Element url=urlSet.addElement("url");
		Element locE=url.addElement("loc");
		locE.addText(loc);
		Element lastModE=url.addElement("lastmod");
		lastModE.addText(df.format(lastMod));
		Element freqE=url.addElement("changefreq");
		freqE.addText(changefreq);
		Element priorityE=url.addElement("priority");
		priorityE.addText(priority);
	}
	
	public void writeXml(OutputStream os) throws IOException{
		 OutputFormat format = OutputFormat.createPrettyPrint();  
         format.setEncoding("UTF-8");//根据需要设置编码  
         XMLWriter writer = new XMLWriter(os, format);  
         document.normalize();  
         writer.write(document);    
         writer.close();  
	}
	public static void main(String[] args) throws IOException {
		SiteMap siteMap=SiteMap.getInstance();
		siteMap.init();
		siteMap.addUrl("http://www.atecher.com", new Date(), "daily", "1.0");
		siteMap.addUrl("http://www.atecher.com", new Date(), "daily", "1.0");
		siteMap.writeXml(System.out);
	}

}
