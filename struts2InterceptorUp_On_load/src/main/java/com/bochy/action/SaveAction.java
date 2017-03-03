package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("saveAction")
public class SaveAction {
  private String msg;
  
  public String save(){
	  System.out.println("新增操作执行完毕！");
	  msg="新增操作可执行！";
	  return "main";
  }

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}
  
}
