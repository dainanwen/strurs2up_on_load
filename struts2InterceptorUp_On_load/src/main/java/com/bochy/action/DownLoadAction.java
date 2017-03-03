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
	private String fileName;//�ļ���
	private String path;//�ļ��Ĵ洢·��
	private InputStream inputStream;///������Ӧ��������
  public String downLoad(){///����������
	  File file=null;
	  //���ļ��ҵ�������InputStream��
	  String basePath=ServletActionContext.getServletContext().getRealPath("/");///��÷�����������Ŀ��Ŀ¼
	  ///�ж��Ƿ����������Ŀ������ļ�Ŀ¼
	  if(path!=null&&path.equals(PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH"))){
		  file=new File(basePath+path+"/"+fileName);///��������Ŀ¼��ͨ��ƴ�ӻ���ļ�����
	  }else{
		 file=new File(path+"/"+fileName);///�������ֱ��ͨ���ļ�·�����ļ�������ļ�����
		  
	  }
	  if(file!=null){//�������ļ��ɹ�
		  try {
			inputStream=new FileInputStream(file);//���ļ�������������
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
	  }else{
		  return "downloadError";//�ļ��ڼ������������г����쳣����תʧ��ҳ��
	  }
	  
	  return "dowloadSuccess";//�ļ�������������ɹ�����ת�ɹ�ҳ��
	   
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
