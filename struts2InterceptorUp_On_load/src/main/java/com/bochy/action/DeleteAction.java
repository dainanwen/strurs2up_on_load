package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("deleteAction")
public class DeleteAction {
	private String msg;
  public String delete(){
	  System.out.println("ɾ������ִ����ϣ�");
	  msg="ɾ��������ִ�У�";
	  
	  return "main";
  }
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
