package com.jeysan.cpf.daily.wf;

import java.util.ArrayList;
import java.util.List;

import org.fireflow.engine.EngineException;
import org.fireflow.engine.IProcessInstance;
import org.fireflow.engine.impl.TaskInstance;
import org.fireflow.engine.taskinstance.IAssignable;
import org.fireflow.engine.taskinstance.IAssignmentHandler;
import org.fireflow.kernel.KernelException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeysan.cpf.security.entity.Post;
import com.jeysan.cpf.security.entity.User;
import com.jeysan.cpf.security.service.PostManager;

/**
 * 该AssignmentHandler将TaskInstance分配给特定的角色，
 * 角色名称通过roleName参数传入。
 * @author 黄静
 *
 */
public class RoleBasedAssignmentHandler implements IAssignmentHandler {
	private PostManager postManager;
	@Override
	public void assign(IAssignable assignable, String postCode) throws EngineException,
			KernelException {
		TaskInstance taskInstance = (TaskInstance)assignable;
		IProcessInstance processInstance = taskInstance.getAliveProcessInstance();
		Post post = postManager.getPost(postCode);
		List<User> users = null;
		if(post != null) 
			users = post.getUserList();
				
		if (users==null || users.size()==0){
			throw new EngineException(processInstance,taskInstance.getTask(),"没有符合条件的操作者，无法分配WorkItem！");
		}
		List actorIds = new ArrayList();
		for (User user : users){
			actorIds.add(user.getId().toString());
		}
		assignable.asignToActors(actorIds);
	}
	@Autowired
	public void setPostManager(PostManager postManager) {
		this.postManager = postManager;
	}
	
	

}
