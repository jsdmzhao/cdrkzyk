package com.jeysan.cpf.workflow.dao;

import org.fireflow.engine.IWorkItem;
import org.fireflow.engine.impl.WorkItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.tool.hbm2x.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.jeysan.modules.orm.Page;
import com.jeysan.modules.orm.hibernate.HibernateDao;


/**
 * @author 黄静
 *
 */
@Component
public class WorkItemDao extends HibernateDao<WorkItem, String> {
	public Page<WorkItem> findTodoWorkItems(final Page<WorkItem> page,final String actorId) {
        return findTodoWorkItems(page,actorId, null);
    }

    public Page<WorkItem> findTodoWorkItems(final Page<WorkItem> page,final String actorId, final String processInstanceId) {
		Assert.notNull(page, "page不能为空");
		Criteria criteria = getCriteria();
		Criterion cri_or = Expression.or(Expression.eq("state", new Integer(IWorkItem.INITIALIZED)), Expression.eq("state", new Integer(IWorkItem.RUNNING)));
		if (StringUtils.isNotEmpty(actorId)) {
			Criterion cri_and = Expression.and(Expression.eq("actorId", actorId), cri_or);
			criteria.add(cri_and);
		} else {
			criteria.add(cri_or);
		}
		criteria.createAlias("taskInstance", "taskInstance");
		if (StringUtils.isNotEmpty(processInstanceId)) {
			criteria.add(Expression.eq("taskInstance.processInstanceId",processInstanceId));
		}
		return findPage(page, criteria);
	}

    public Page<WorkItem> findTodoWorkItems(final Page<WorkItem> page,final String actorId, final String processId, final String taskId) {
    	Assert.notNull(page, "page不能为空");
    	Criteria criteria = getCriteria();
		Criterion cri_or = Expression.or(Expression.eq("state", new Integer(IWorkItem.INITIALIZED)), Expression.eq("state", new Integer(IWorkItem.RUNNING)));
		if (StringUtils.isNotEmpty(actorId)) {
			Criterion cri_and = Expression.and(Expression.eq("actorId", actorId), cri_or);
			criteria.add(cri_and);
		} else {
			criteria.add(cri_or);
		}
		criteria.createAlias("taskInstance", "taskInstance");
		if (StringUtils.isNotEmpty(processId)) {
			criteria.add(Expression.eq("taskInstance.processId",processId));
		}
		if (StringUtils.isNotEmpty(taskId)) {
            criteria.add(Expression.eq("taskInstance.taskId", taskId));
        }
		return findPage(page, criteria);
    }

    public Page<WorkItem> findHaveDoneWorkItems(final Page<WorkItem> page,final String actorId) {
        return findHaveDoneWorkItems(page,actorId, null);
    }

    public Page<WorkItem> findHaveDoneWorkItems(final Page<WorkItem> page,final String actorId, final String processInstanceId) {
    	Assert.notNull(page, "page不能为空");
		Criteria criteria = getCriteria();
		Criterion cri_or = Expression.or(Expression.eq("state", new Integer(IWorkItem.COMPLETED)), Expression.eq("state", new Integer(IWorkItem.CANCELED)));
		if (StringUtils.isNotEmpty(actorId)) {
			Criterion cri_and = Expression.and(Expression.eq("actorId", actorId), cri_or);
			criteria.add(cri_and);
		} else {
			criteria.add(cri_or);
		}
		criteria.createAlias("taskInstance", "taskInstance");
		if (StringUtils.isNotEmpty(processInstanceId)) {
			criteria.add(Expression.eq("taskInstance.processInstanceId",processInstanceId));
		}
		return findPage(page, criteria);
    }

    public Page<WorkItem> findHaveDoneWorkItems(final Page<WorkItem> page,final String actorId, final String processId, final String taskId) {
        Assert.notNull(page, "page不能为空");
    	Criteria criteria = getCriteria();
		Criterion cri_or = Expression.or(Expression.eq("state", new Integer(IWorkItem.COMPLETED)), Expression.eq("state", new Integer(IWorkItem.CANCELED)));
		if (StringUtils.isNotEmpty(actorId)) {
			Criterion cri_and = Expression.and(Expression.eq("actorId", actorId), cri_or);
			criteria.add(cri_and);
		} else {
			criteria.add(cri_or);
		}
		criteria.createAlias("taskInstance", "taskInstance");
		if (StringUtils.isNotEmpty(processId)) {
			criteria.add(Expression.eq("taskInstance.processId",processId));
		}
		if (StringUtils.isNotEmpty(taskId)) {
            criteria.add(Expression.eq("taskInstance.taskId", taskId));
        }
		return findPage(page, criteria);
    	
    }
}