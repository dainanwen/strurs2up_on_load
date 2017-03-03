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
     * ����ָ���ļ��洢··���е������ļ��б���Ϣ
     * */
   private List<FileMsgVo> fileList;///����һ������ļ���װ����ļ���
	public String scanFiles(){
		fileList=new ArrayList<FileMsgVo>();
		//��÷�������Ŀ�����Ŀ¼
		 String str=ServletActionContext.getServletContext().getRealPath("/");
		 //����ļ��洢��·��
		 String path_1=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "IMG_STORE_PATH"); 
		 String path_2=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "OTHERS_STORE_PATH");
        //��·������һ���ļ��ж���
		 File file_1=new File(str+path_1);
		//��·������һ���ļ��ж���
		 File file_2=new File(path_2);
		 ///����ļ����ڵ������ļ��������ļ�����洢����
		 if(file_1.exists()){
		     String[] array_1=	 file_1.list();///��ø��ļ����µ������ļ����ļ��������γ�һ������
		     System.out.println(array_1[0]);
			 List<String> list_1=Arrays.asList(array_1);//���ļ�������תΪ����
			 FileMsgVo fileVo_1=new FileMsgVo();//����һ���ļ���װ����
			 fileVo_1.setList(list_1);//���ļ����ϴ������
			 fileVo_1.setStorePATH(path_1);///�����ļ���·���������
			 fileList.add(fileVo_1);//�����ļ����ݴ洢����
			 
		 }
		///����ͬ��
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
