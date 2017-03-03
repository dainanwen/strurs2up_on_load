package com.bochy.interceptor;

import com.bochy.vo.UserVo;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ����������̳г����ࣺAbstractInterceptor
 * @author Administrator
 *
 */
public class LoginInterceptor extends AbstractInterceptor {
   
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {	
		//ͨ�����������������session����session�в��Ҷ���
		UserVo user=(UserVo)arg0.getInvocationContext().getSession().get("user");
		if(user!=null){
			return arg0.invoke();///����û����ڣ�����½״̬���������
		}else{
			String errorMsg="��Ϊ��¼�ɹ�����������ò�����";
			///�������û����ǵ�½״̬������״̬
			///�˴�arg0.getInvocationContext()�൱��request
			///put(����������)�൱�����������ڷ�����
			arg0.getInvocationContext().put("errorMsg", errorMsg);
			return "error";
		}
		
		
	}
	

}
