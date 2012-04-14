package com.jeysan.cpf.comm.web;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.jeysan.modules.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author gemstone E-mail: xlsky0713@163.com
 * @version 2011-8-5 下午04:28:35 description
 */
@Namespace("/print")


@Result(name = "print", location = "/print/PrintMain.jsp", type = "dispatcher")	
public class PrintAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -1826212472390477005L;

	private HttpServletRequest request;
	private String url;

	@SuppressWarnings("unchecked")
	public String print() {
		try{
			Enumeration names = request.getParameterNames();
			StringBuffer urlSB = new StringBuffer();
			/*String paramsInForm = null;
			String title = null;*/
			//String rule = null;
			//Struts2Utils.getRequest().setCharacterEncoding("utf-8"); 

			//Struts2Utils.getResponse().setCharacterEncoding("utf-8");

			while (names.hasMoreElements()) {
				String name = (String) names.nextElement();
				if (name.equals("url")) {
					continue;
				}
				/*if (name.equals("title")) {
					String title = request.getParameter(name);new String(title.getBytes("ISO-8859-1"),"gb2312");
					System.out.println(title);
				}*//*else if (name.equals("rule")) {
					rule = request.getParameter(name);
					System.out.println(rule);
				}*//*else if (name.equals("title")) {
					title = request.getParameter(name);
					System.out.println(title);
				}else if(name.equals("params")){
					paramsInForm = request.getParameter(name);
					List<Map> lst = Struts2Utils.formJson(paramsInForm, List.class);
					for(Map<String,String> m : lst){
						urlSB.append(m.get("name")).append("=").append(m.get("value")).append("&");
					}
				}*/else
					urlSB.append(name).append("=").append(request.getParameter(name)).append("&");
			}
			if (urlSB.length() > 1)
				urlSB.deleteCharAt(urlSB.length() - 1);
			url = url + (url.indexOf("?") == -1 ? "?" : "&") + urlSB.toString();
			System.out.println(url);
			return "print";
		}catch(Exception e){
			e.printStackTrace();
		}
		return NONE;
	}	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;	
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	
	
	

}
