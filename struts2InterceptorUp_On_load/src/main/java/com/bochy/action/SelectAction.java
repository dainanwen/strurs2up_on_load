package com.bochy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.bochy.vo.EmpVo;
@Controller("selectAction")
public class SelectAction {
    private   List<EmpVo> list;
    private String msg;
	public String select(){
		EmpVo vo_1=new EmpVo("SMITH", 22, "�ӱ�ʡ");
		EmpVo vo_2=new EmpVo("JONE", 23, "ɽ��");
		EmpVo vo_3=new EmpVo("XIAOMING", 22, "ʯ��ׯ");
		EmpVo vo_4=new EmpVo("SILI", 25, "̫ԭ");
		EmpVo vo_5=new EmpVo("WANGHU", 32, "������ʡ");
		list=new ArrayList<EmpVo>();
		list.add(vo_1);
		list.add(vo_2);
		list.add(vo_3);
		list.add(vo_4);
		list.add(vo_5);
		System.out.println("��ѯ����ִ����ϣ�");
		msg="��ѯ��ִ�У�";
		return "main";
	}
	public List<EmpVo> getList() {
		return list;
	}
	public void setList(List<EmpVo> list) {
		this.list = list;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
