<%@ include file="/common/taglibs.jsp" %>
<%@ tag import="com.jeysan.modules.workflow.WorkflowState,
org.fireflow.engine.impl.TaskInstance,
org.springframework.context.ApplicationContext,
org.fireflow.engine.RuntimeContext,
                 org.springframework.web.context.WebApplicationContext" %>
<%@ attribute name="wi"	type="org.fireflow.engine.impl.WorkItem" required="true" description="工单值" %>
<%@ attribute name="type" type="java.lang.Integer" required="true"	description="0 工单 1任务 2流程实例" %>

<%	
	Integer value = null;
	try{
	if(type == 0){
		value = wi.getState();
	}else if(type == 1){
		value = wi.getTaskInstance().getState();
	}else if(type == 2){
		String processInstanceId = wi.getTaskInstance().getProcessInstanceId();
		String key = new StringBuilder().append("processInstance_").append(processInstanceId).toString();
		Object o = request.getAttribute(key);
		if(o==null){
			ApplicationContext  applicationContext=(ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			RuntimeContext runtimeContext = applicationContext.getBean("runtimeContext",RuntimeContext.class);
			value = runtimeContext.getWorkflowSession().findProcessInstanceById(processInstanceId).getState();
			request.setAttribute(key,value);
		}
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	String stateLabel = WorkflowState.getWorkflowState(value,type);
%>
<font color="red"><%=stateLabel%></font>
