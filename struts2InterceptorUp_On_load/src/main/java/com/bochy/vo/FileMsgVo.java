package com.bochy.vo;

import java.util.List;

public class FileMsgVo {
 private String storePATH;//文件存储路径
 private List<String> list;//文件路径中的文件列表
public String getStorePATH() {
	return storePATH;
}
public void setStorePATH(String storePATH) {
	this.storePATH = storePATH;
}
public List<String> getList() {
	return list;
}
public void setList(List<String> list) {
	this.list = list;
}
 
}
