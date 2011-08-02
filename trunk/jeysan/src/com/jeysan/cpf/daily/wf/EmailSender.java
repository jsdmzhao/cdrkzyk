package com.jeysan.cpf.daily.wf;

import org.apache.log4j.Logger;
import org.fireflow.engine.IProcessInstance;
import org.fireflow.engine.ITaskInstance;
import org.fireflow.engine.impl.TaskInstance;
import org.fireflow.engine.taskinstance.IApplicationHandler;

/**
 * 模拟向邮件系统发送邮件
 * @author 黄静
 *
 */
public class EmailSender implements IApplicationHandler {
	private Logger logger = Logger.getLogger(getClass());
	@Override
	public void execute(ITaskInstance taskInstance) {
		IProcessInstance processInstance = ((TaskInstance)taskInstance).getAliveProcessInstance();
		Integer LeaveCount = (Integer)processInstance.getProcessInstanceVariable("LeaveCount");
		logger.debug("您的请假"+LeaveCount+"天的申请有结果啦，发送邮件在......");
	}

}
