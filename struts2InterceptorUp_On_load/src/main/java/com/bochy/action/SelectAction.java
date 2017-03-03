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
		EmpVo vo_1=new EmpVo("SMITH", 22, "河北省");
		EmpVo vo_2=new EmpVo("JONE", 23, "山西");
		EmpVo vo_3=new EmpVo("XIAOMING", 22, "石家庄");
		EmpVo vo_4=new EmpVo("SILI", 25, "太原");
		EmpVo vo_5=new EmpVo("WANGHU", 32, "黑龙江省");
		list=new ArrayList<EmpVo>();
		list.add(vo_1);
		list.add(vo_2);
		list.add(vo_3);
		list.add(vo_4);
		list.add(vo_5);
		System.out.println("查询方法执行完毕！");
		msg="查询可执行！";
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
