package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("saveAction")
public class SaveAction {
  private String msg;
  
  public String save(){
	  System.out.println("��������ִ����ϣ�");
	  msg="����������ִ�У�";
	  return "main";
  }

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}
  
}
