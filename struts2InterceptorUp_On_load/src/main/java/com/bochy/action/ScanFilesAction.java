package com.bochy.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bochy.fileUtils.PropertiesReaderUtils;
import com.bochy.vo.FileMsgVo;

@Controller("scanFilesAction")
public class ScanFilesAction {
    /**
     * 检索指定文件存储路路径中的所有文件列表信息
     * */
   private List<FileMsgVo> fileList;///创建一个存放文件封装对象的集合
	public String scanFiles(){
		fileList=new ArrayList<FileMsgVo>();
		//获得服务器项目部署根目录
		 String str=ServletActionContext.getServletContext().getRealPath("/");
		 //获得文件存储的路径
		 String path_1=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH"); 
		 String path_2=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "OTHERS_STORE_PATH");
        //以路径创建一个文件夹对象
		 File file_1=new File(str+path_1);
		//以路径创建一个文件夹对象
		 File file_2=new File(path_2);
		 ///获得文件夹内的所有文件并放入文件对象存储集合
		 if(file_1.exists()){
		     String[] array_1=	 file_1.list();///获得该文件夹下的所有文件（文件名），形成一个数组
		     System.out.println(array_1[0]);
			 List<String> list_1=Arrays.asList(array_1);//将文件名数组转为集合
			 FileMsgVo fileVo_1=new FileMsgVo();//创建一个文件封装对象
			 fileVo_1.setList(list_1);//将文件集合存入对象
			 fileVo_1.setStorePATH(path_1);///将该文件夹路径存入对象
			 fileList.add(fileVo_1);//放入文件数据存储集合
			 
		 }
		///与上同理
		 if(file_2.exists()){
		    String[] array_2=	 file_2.list();
			List<String> list_2=Arrays.asList(array_2);
			 FileMsgVo fileVo_2=new FileMsgVo();
			 fileVo_2.setList(list_2);
			 fileVo_2.setStorePATH(path_2);
			 fileList.add(fileVo_2);
		 }
		return "success";
	}
	public List<FileMsgVo> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileMsgVo> fileList) {
		this.fileList = fileList;
	}
	 
	 
}
