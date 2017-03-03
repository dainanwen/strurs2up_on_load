package com.bochy.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ģ��Ȩ��������
 * 1.�̳г�����AbstractInterceptor
 * 2.��дintercept����
 * @author Administrator
 *
 */
public class SecretInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		///��session��ȡֵ���൱�ڻ��Ȩ�޵ļ���
		List<String> secret=(List<String>) invocation.getInvocationContext().getSession().get("secret"); 
		if(secret!=null){
			///������ص�action
			String actionName=invocation.getProxy().getActionName();
			if(secret.contains(actionName)){//�ж�Ȩ�޼������Ƿ��иñ����ص�action
				return invocation.invoke();//�����Ȩ�޾͸�����
			}else{
				invocation.getInvocationContext().put("errorMsg", "��Ȩ�ޣ�");
				return "error";
			}
		}else{
			invocation.getInvocationContext().put("errorMsg", "��Ȩ�ޣ�");
			return "error";
		}
		
		 
	}

}
