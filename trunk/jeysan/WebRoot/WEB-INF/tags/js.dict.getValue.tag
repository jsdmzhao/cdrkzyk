<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="java.util.Map,
                 com.jeysan.cpf.security.entity.DictSub,
                 org.apache.commons.lang.StringUtils" %>
<%@ attribute name="value"	type="java.lang.String"	required="true"	description="值" %>
<%@ attribute name="isColor" type="java.lang.Boolean" required="false" description="是否着色" %>
<%	try{
		if(StringUtils.isNotEmpty(value)){
			String key = new StringBuilder().append("dict_").append(value).toString();
			DictSub dictSub = (DictSub)request.getAttribute(key);
			if(dictSub==null){
				Map<Integer,DictSub> dict_subs = (Map)application.getAttribute("_js_dict_sub");
				dictSub = dict_subs.get(Integer.parseInt(value));
				request.setAttribute(key,dictSub);
			}
			if(dictSub!=null){
				if(isColor!=null&&isColor&&StringUtils.isNotEmpty(dictSub.getSubColor())){
					%><font color="<%=dictSub.getSubColor()%>"><%=dictSub.getSubName()%></font><%
				}else{
					%><%=dictSub.getSubName()%><%
				}
			}
		}
	}catch(Exception e){
		//e.printStackTrace();
	}
%>