package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("updateAction")
public class UpdateAction {
	private String msg;
	  
	  public String update(){
		  System.out.println("�޸Ĳ���ִ����ϣ�");
		  msg="�޸Ĳ�����ִ�У�";
		  return "main";
	  }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
}
