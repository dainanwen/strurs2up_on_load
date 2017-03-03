package com.bochy.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 模拟权限拦截器
 * 1.继承抽象类AbstractInterceptor
 * 2.重写intercept方法
 * @author Administrator
 *
 */
public class SecretInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		///从session中取值，相当于获得权限的集合
		List<String> secret=(List<String>) invocation.getInvocationContext().getSession().get("secret"); 
		if(secret!=null){
			///获得拦截的action
			String actionName=invocation.getProxy().getActionName();
			if(secret.contains(actionName)){//判断权限集合中是否有该被拦截的action
				return invocation.invoke();//如果有权限就给放行
			}else{
				invocation.getInvocationContext().put("errorMsg", "无权限！");
				return "error";
			}
		}else{
			invocation.getInvocationContext().put("errorMsg", "无权限！");
			return "error";
		}
		
		 
	}

}
