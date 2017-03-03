package com.bochy.action;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bochy.fileUtils.FileUtils;
import com.bochy.fileUtils.PropertiesReaderUtils;

/**
 * 文件上传实现
 * */
@Controller("fileUploadAction")
public class FileUploadAction  {
    private File  myfile; 
	private String myfileFileName;//name属性 +FileName，此处格式固定【对象名+FileName】//文件名
	private String myfileContentType;//此处格式固定【对象名+ContentType】获取文件类型：注意：不是真实文件类型，而是临时文件的类型
    private String flag;
	private String errorMsg;
	public String upload(){
		System.out.println(flag+"+++:"+myfileFileName);
		if(myfile==null){//如果没有获得文件对象
			return "error";
		}
		String path=null;
		if(flag!=null&&"0".equals(flag)){//判断具体存入哪个路径区域//如果是0，存入相对项目部署的相对路径
			  path=ServletActionContext.getServletContext().getRealPath("/");
			  path=path+PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH");
			
		} else{//具体盘符
		  path=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "OTHERS_STORE_PATH");
 
		}
		
		File file=new File(path);///以路径创建文件夹对象
		if(!file.exists()){//如果该文件夹不存在
			file.mkdirs();//逐级创建文件夹路径
		}
		//获得随机文件名
		String fileName=UUID.randomUUID().toString()+myfileFileName.substring(myfileFileName.lastIndexOf("."));
		try {
			System.out.println(path);
			System.out.println(fileName);
			System.out.println("===========");
			///调用上传工具类上传文件
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
