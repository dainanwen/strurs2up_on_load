package com.bochy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bochy.vo.UserVo;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
public class LoginAction {
	 private List<String> secret=new ArrayList<String>();
    private String username;
    private String pwd;
    private String errorMsg;
	public String login(){
		if(username!=null&&pwd!=null&&username.equals("admin")&&pwd.equals("admin")){
			UserVo userVo=new UserVo();
			userVo.setPwd(pwd);
			userVo.setUsername(username);	
			secret.add("selectAction_select");
			secret.add("saveAction_save");
			secret.add("updateAction_update");
			//secret.add("deleteAction_delete");
			ServletActionContext.getRequest().getSession().setAttribute("user", userVo);
			ActionContext.getContext().getSession().put("secret", secret);
			return "success";
			
		}else{
			errorMsg="登录失败！";
			return "error";
		}
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
