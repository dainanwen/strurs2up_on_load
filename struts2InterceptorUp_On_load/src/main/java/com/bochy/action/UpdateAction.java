package com.bochy.action;

import org.springframework.stereotype.Controller;

@Controller("updateAction")
public class UpdateAction {
	private String msg;
	  
	  public String update(){
		  System.out.println("修改操作执行完毕！");
		  msg="修改操作可执行！";
		  return "main";
	  }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
}
