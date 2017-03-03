package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("deleteAction")
public class DeleteAction {
	private String msg;
  public String delete(){
	  System.out.println("删除操作执行完毕！");
	  msg="删除操作可执行！";
	  
	  return "main";
  }
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
}
