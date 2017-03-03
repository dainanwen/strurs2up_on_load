package com.bochy.fileUtils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtils {

	/**
	 * ͨ�����Ի�������ļ������Գ���ֵ
	 * @param propertiesPath �����ļ�·��
	 * @param key ����key
	 * @return ����ֵ
	 */
	public static String getPropertiesVal(String propertiesPath,String key){
		String  val=null;
		///�������ļ����ص�����
		InputStream inputStream=PropertiesReaderUtils.class.getClassLoader().getResourceAsStream(propertiesPath);
		///����������
		Properties properties=new Properties();
		try {
			properties.load(inputStream);//������������
		    val=(String) properties.get(key);//ͨ��key���ֵ
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return val;
		
	}
	public static void main(String args[]){
		String val=PropertiesReaderUtils.getPropertiesVal("fileStore.properties", "OTHERS_STORE_PATH");
		System.out.println(val);
	}

}
