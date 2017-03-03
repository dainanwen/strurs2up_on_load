package com.bochy.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bochy.fileUtils.PropertiesReaderUtils;

@Controller("downLoadAction")
public class DownLoadAction {
	private String fileName;//文件名
	private String path;//文件的存储路径
	private InputStream inputStream;///用来响应的流对象
  public String downLoad(){///下载主方法
	  File file=null;
	  //将文件找到，放入InputStream中
	  String basePath=ServletActionContext.getServletContext().getRealPath("/");///获得服务器部署项目根目录
	  ///判断是否是相对于项目的相对文件目录
	  if(path!=null&&path.equals(PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH"))){
		  file=new File(basePath+path+"/"+fileName);///如果是相对目录，通过拼接获得文件对象
	  }else{
		 file=new File(path+"/"+fileName);///如果不是直接通过文件路径和文件名获得文件对象
		  
	  }
	  if(file!=null){//如果获得文件成功
		  try {
			inputStream=new FileInputStream(file);//将文件放入流对象中
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	  }else{
		  return "downloadError";//文件在加载入流过程中出现异常，跳转失败页面
	  }
	  
	  return "dowloadSuccess";//文件加载入流对象成功，跳转成功页面
	   
  }
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public InputStream getInputStream() {
	return inputStream;
}
public void setInputStream(InputStream inputStream) {
	this.inputStream = inputStream;
}
}
