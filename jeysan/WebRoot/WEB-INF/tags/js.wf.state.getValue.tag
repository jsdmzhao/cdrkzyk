<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="com.jeysan.modules.workflow.WorkflowState" %>
<%@ attribute name="value"	type="java.lang.Integer" required="true" description="流程状态值" %>
<%@ attribute name="type" type="java.lang.Integer" required="true"	description="0 工单状态 1任务状态 2流程实例状态" %>

<%	
	String stateLabel = WorkflowState.getWorkflowState(value,type);
%>
<font color="red"><%=stateLabel%></font>
