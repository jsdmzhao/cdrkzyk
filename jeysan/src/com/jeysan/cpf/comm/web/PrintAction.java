package com.jeysan.cpf.comm.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

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
		Enumeration names = request.getParameterNames();
		StringBuffer urlSB = new StringBuffer();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			if (name.equals("url")) {
				continue;
			}
			urlSB.append(name).append("=").append(request.getParameter(name))
					.append("&");
		}
		if (urlSB.length() > 1)
			urlSB.deleteCharAt(urlSB.length() - 1);
		url = url + (url.indexOf("?") == -1 ? "?" : "&") + urlSB.toString();
		return "print";
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
