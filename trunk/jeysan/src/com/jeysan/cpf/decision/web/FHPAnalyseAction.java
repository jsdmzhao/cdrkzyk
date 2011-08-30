package com.jeysan.cpf.decision.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.jeysan.cpf.decision.vo.FHPAStat4yffpVO;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author  gemstone	E-mail: xlsky0713@163.com
 * @version 2011-8-8 下午02:20:09 
 * description
 */
@Namespace("/decision")
@Result(name = "stat_yffp", location = "stat_yffp.jsp", type = "dispatcher")
public class FHPAnalyseAction extends ActionSupport{
	
	private static final long serialVersionUID = -1826212472390477005L;
	private List<FHPAStat4yffpVO> datas;
	private String title;
	private String[] heads;
	
	/**
	 * 年度实有流动人口统计
	 * @return
	 */
	public String stat_yffp() {
		
		title = "年度实有流动人口统计";
		heads = new String[]{"head1","head2","head3","head4","head5","head6","head7","head8","head9"};
		//数据模拟
		FHPAStat4yffpVO vo = new FHPAStat4yffpVO();
		vo.setN1("33.00");
		vo.setN2("34.00");
		vo.setN3("34.00");
		vo.setN4("34.00");
		vo.setN5("34.00");
		vo.setN6("34.00");
		vo.setN7("34.00");
		vo.setN8("34.00");
		vo.setN9("34.00");
		datas = new ArrayList<FHPAStat4yffpVO>();
		for(int i = 0; i < 55; i ++){
			datas.add(vo);
		}	
		
		return "stat_yffp";
	}
	public List<FHPAStat4yffpVO> getDatas() {
		return datas;
	}
	public String getTitle() {
		return title;
	}
	public String[] getHeads() {
		return heads;
	}

	
}
