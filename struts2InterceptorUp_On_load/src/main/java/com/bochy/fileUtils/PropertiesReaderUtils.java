package com.bochy.fileUtils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtils {

	/**
	 * 通过属性获得配置文件的属性常量值
	 * @param propertiesPath 配置文件路径
	 * @param key 属性key
	 * @return 返回值
	 */
	public static String getPropertiesVal(String propertiesPath,String key){
		String  val=null;
		///将参数文件加载到流中
		InputStream inputStream=PropertiesReaderUtils.class.getClassLoader().getResourceAsStream(propertiesPath);
		///创建解析器
		Properties properties=new Properties();
		try {
			properties.load(inputStream);//解析器加载流
		    val=(String) properties.get(key);//通过key获得值
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
