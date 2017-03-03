package com.bochy.action;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bochy.fileUtils.FileUtils;
import com.bochy.fileUtils.PropertiesReaderUtils;

/**
 * �ļ��ϴ�ʵ��
 * */
@Controller("fileUploadAction")
public class FileUploadAction  {
    private File  myfile; 
	private String myfileFileName;//name���� +FileName���˴���ʽ�̶���������+FileName��//�ļ���
	private String myfileContentType;//�˴���ʽ�̶���������+ContentType����ȡ�ļ����ͣ�ע�⣺������ʵ�ļ����ͣ�������ʱ�ļ�������
    private String flag;
	private String errorMsg;
	public String upload(){
		System.out.println(flag+"+++:"+myfileFileName);
		if(myfile==null){//���û�л���ļ�����
			return "error";
		}
		String path=null;
		if(flag!=null&&"0".equals(flag)){//�жϾ�������ĸ�·������//�����0�����������Ŀ��������·��
			  path=ServletActionContext.getServletContext().getRealPath("/");
			  path=path+PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH");
			
		} else{//�����̷�
		  path=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "OTHERS_STORE_PATH");
 
		}
		
		File file=new File(path);///��·�������ļ��ж���
		if(!file.exists()){//������ļ��в�����
			file.mkdirs();//�𼶴����ļ���·��
		}
		//�������ļ���
		String fileName=UUID.randomUUID().toString()+myfileFileName.substring(myfileFileName.lastIndexOf("."));
		try {
			System.out.println(path);
			System.out.println(fileName);
			System.out.println("===========");
			///�����ϴ��������ϴ��ļ�
			errorMsg=FileUtils.fileUpload( myfile,fileName, path);
			System.out.println(errorMsg);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "uploadSuccess";
	}
	 
	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}
	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}
	public String getMyfileContentType() {
		return myfileContentType;
	}
	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	 
	 
	 
 
}
