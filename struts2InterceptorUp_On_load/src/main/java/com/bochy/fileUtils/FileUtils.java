package com.bochy.fileUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {

	/**
	 * �ļ��ϴ���װ�ķ���
	 * @param file Ҫ�ϴ����ļ�
	 * @param newfilename �ļ��洢���ļ���
	 * @param filepath �ļ��洢��·��
	 * @return �����ϴ��ɹ���ʧ��
	 */
	public static String fileUpload(File file,String newfilename,String filepath){
		try {
			InputStream input=new FileInputStream(file);
			BufferedInputStream reder=new BufferedInputStream(input);
			File newfile=new File(filepath+"/"+newfilename);
			if(!new File(filepath).exists()){
				new File(filepath).mkdirs();
			}
			OutputStream out=new FileOutputStream(newfile);
			BufferedOutputStream Writer=new BufferedOutputStream(out);
			byte[] b=new byte[1024];
			int leng=0;
			while((leng=reder.read(b))!=-1){
				Writer.write(b, 0, leng);	
				Writer.flush();
			}
			Writer.close();
			out.close();
			reder.close();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "�ϴ�ʧ�ܣ�";
		}
		return "�ϴ��ɹ���";
	}
	public static void main(String[] args) {
		System.out.println(FileUtils.fileUpload(new File("C:/Users/Administrator/Desktop/�ֶι�ϵ.txt"), "aa.txt", "e:/admin"));
		
	}
}
