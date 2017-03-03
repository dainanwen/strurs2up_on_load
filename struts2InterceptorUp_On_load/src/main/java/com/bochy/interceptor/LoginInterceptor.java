package com.bochy.interceptor;

import com.bochy.vo.UserVo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 拦截器必须继承抽象类：AbstractInterceptor
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor {
   
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {	
		//通过拦截器获得请求获得session，在session中查找对象
		UserVo user=(UserVo)arg0.getInvocationContext().getSession().get("user");
		if(user!=null){
			return arg0.invoke();///如果用户存在，即登陆状态，给予放行
		}else{
			String errorMsg="您为登录成功过，不允许该操作！";
			///不存在用户，非登陆状态，给予状态
			///此处arg0.getInvocationContext()相当于request
			///put(“”，“”)相当于往作用域内放数据
			arg0.getInvocationContext().put("errorMsg", errorMsg);
			return "error";
		}
		
		
	}
	

}
