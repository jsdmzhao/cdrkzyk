<%-- 
	JSP 扩展标签,文件统一管理器
	written by Cancerloveshaly @ kt.com
--%>

<%-- Config params _____________________________START --%>

<%@ attribute
	name="type"
	type="java.lang.Integer"
	required="true"
	description="
(Integer)文件业务类型 Constants.FileBusType里面取变量
" %>
<%@ attribute
	name="isv"
	type="java.lang.Boolean"
	required="true"
	description="
(Boolean)用户是否有编辑权限
" %>
<%@ attribute
	name="isLimit4Pic"
	type="java.lang.Boolean"
	required="false"
	description="
(Boolean)是否限制为图片
" %>
<%@ attribute
	name="hiddenId"
	type="java.lang.String"
	required="true"
	description="
(String)记录用户上传文件的ID值,用','分割
" %>
<%@ attribute
	name="labelId"
	type="java.lang.String"
	required="true"
	description="
(String)记录用户上传的文件名的展示区域
" %>
<%@ attribute
	name="hiddenIdValue"
	type="java.lang.String"
	required="false"
	description="
(String)记录用户上传文件的ID值,用','分割
" %>
<%@ attribute
	name="is4SingleFile"
	type="java.lang.Boolean"
	required="false"
	description="
(Boolean)是否限制单张上传
" %>
<%@ attribute
	name="isShowPic"
	type="java.lang.Boolean"
	required="false"
	description="
(Boolean)是否显示单张图片，默认显示，false不显示
" %>
<%@ attribute
	name="fileTypes"
	type="java.lang.String"
	required="false"
	description="
(String)图片类型
" %>
<%-- Tag Body  _____________________________START --%>
<%@ include file="/common/taglibs.jsp" %>
<%@ tag 
	import="org.apache.commons.beanutils.BeanUtils,java.util.*,
	org.springframework.web.context.WebApplicationContext,
	org.springframework.web.context.support.WebApplicationContextUtils,
	com.jeysan.cpf.comm.service.FileManagerManager,
	com.jeysan.cpf.comm.entity.FileManager"
	dynamic-attributes="dynamicAttributes"
	description="文件统一管理器" %>
	<%-- Process JSP body --%>
	<jsp:doBody var="jspBody" scope="page" />
	<c:if test="${isv}">
	<c:if test="${empty(deleteFileJavascript)}">
		<c:set var="deleteFileJavascript" scope="page">
		<script type="text/javascript">
			function deleteFile(fileId){
				$.ajax({
					 type:"POST",
					 url:"${ctx}/comm/filemanager!delete.action",
					 data:"id="+fileId,
					 success: function(msg){
					 	$('#label_'+fileId).remove();
					 }
				}); 
			}
		</script>
		</c:set>
	</c:if>
	${deleteFileJavascript}
	<a class="btnLook" href="javascript:" onclick="window.open('${ctx}/common/uploadkt.jsp?type=${type}&isv=${isv}&hiddenId=${hiddenId}&labelId=${labelId}&isLimit4Pic=${isLimit4Pic}&is4SingleFile=${is4SingleFile}&isShowPic=${isShowPic}&fileTypes=${fileTypes}', 'fileselector', 'width=300,height=300,status=no')"></a><input type="hidden" id="${hiddenId}" name="${hiddenId}" value="${hiddenIdValue}"/>
	</c:if>
	<c:if test="${!empty(hiddenIdValue)&&fn:length(hiddenIdValue)>0}">
	<script type="text/javascript">
	$(function(){
		var $box = navTab.getCurrentPanel();
	<%
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
		FileManagerManager fileManagerManager = (FileManagerManager)wac.getBean("fileManagerManager");
		List<FileManager> files = fileManagerManager.queryFileManagersById(hiddenIdValue);
		for(FileManager file:files){
			%>
				if(('${isShowPic}'==''||'${isShowPic}'=='true')&&'${is4SingleFile}'=='true' && '${isLimit4Pic}'=='true' ){
					if(${isv})
						$("#${labelId}",$box).append("<div id=\"label_<%=file.getId()%>\" onmouseover=\"$('#deleteImg_<%=file.getId()%>').css('visibility','visible')\" onmouseout=\"$('#deleteImg_<%=file.getId()%>').css('visibility','hidden');\">&nbsp;<a id=\"linkHref_<%=file.getId()%>\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/<%=file.getNewName()%>\" target=\"_blank\"><img src=\"${ctx}/datafile/<%=file.getNewName()%>\" border=\"0\" alt=\"<%=file.getOrinName()%>\"/></a><img src=\"${ctx4doc}/dwz3/themes/default/images/cancel.png\" id=\"deleteImg_<%=file.getId()%>\" style=\"border:0;cursor:pointer;visibility:hidden\" onclick=\"deleteFile(<%=file.getId()%>)\"/></div>");
					else
						$("#${labelId}",$box).append("<div id=\"label_<%=file.getId()%>\">&nbsp;<a id=\"linkHref_<%=file.getId()%>\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/<%=file.getNewName()%>\" target=\"_blank\"><img src=\"${ctx}/datafile/<%=file.getNewName()%>\" border=\"0\" alt=\"<%=file.getOrinName()%>\"/></a></div>");
				}else{
					if(${isv})
						$("#${labelId}",$box).append("<div id=\"label_<%=file.getId()%>\" onmouseover=\"$('#deleteImg_<%=file.getId()%>').css('visibility','visible')\" onmouseout=\"$('#deleteImg_<%=file.getId()%>').css('visibility','hidden');\">&nbsp;<a id=\"linkHref_<%=file.getId()%>\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/<%=file.getNewName()%>\" target=\"_blank\"><%=file.getOrinName()%></a><img src=\"${ctx4doc}/dwz3/themes/default/images/cancel.png\" id=\"deleteImg_<%=file.getId()%>\" style=\"border:0;cursor:pointer;visibility:hidden\" onclick=\"deleteFile(<%=file.getId()%>)\"/></div>");
					else
						$("#${labelId}",$box).append("<div id=\"label_<%=file.getId()%>\">&nbsp;<a id=\"linkHref_<%=file.getId()%>\" style=\"border:1px solid #CCCCCC;height:20px;background:#EAEAEA;display:inline-block\" href=\"${ctx}/datafile/<%=file.getNewName()%>\" target=\"_blank\"><%=file.getOrinName()%></a></div>");
				}
			<%
		}
	%>
	});
	</script>
	</c:if>
<%-- Tag Body  _____________________________END --%>