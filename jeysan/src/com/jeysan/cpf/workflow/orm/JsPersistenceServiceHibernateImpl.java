package com.jeysan.cpf.workflow.orm;

import java.sql.SQLException;

import org.fireflow.engine.IProcessInstance;
import org.fireflow.engine.ITaskInstance;
import org.fireflow.engine.impl.ProcessInstance;
import org.fireflow.engine.impl.TaskInstance;
import org.fireflow.engine.persistence.hibernate.PersistenceServiceHibernateImpl;
import org.fireflow.kernel.impl.Token;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;

public class JsPersistenceServiceHibernateImpl extends PersistenceServiceHibernateImpl {
	public Integer getAliveTokenCountForNode(final String processInstanceId, final String nodeId) {
        Object result = (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session arg0) throws HibernateException, SQLException {

                Criteria criteria = arg0.createCriteria(Token.class);

                criteria.add(Expression.eq("processInstanceId", processInstanceId));

                criteria.add(Expression.eq("nodeId", nodeId));

                criteria.add(Expression.eq("alive", java.lang.Boolean.TRUE));

                ProjectionList prolist = Projections.projectionList();
                prolist.add(Projections.rowCount());
                criteria.setProjection(prolist);

                return criteria.uniqueResult();
            }
        });
        return new Integer(result.toString());
    }

    public Integer getCompletedTaskInstanceCountForTask(final String processInstanceId, final String taskId) {
        Object result = this.getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session arg0) throws HibernateException, SQLException {

                Criteria criteria = arg0.createCriteria(TaskInstance.class);
                criteria.add(Expression.eq("taskId", taskId.trim()));
                criteria.add(Expression.eq("processInstanceId", processInstanceId));

                Criterion cri2 = Expression.eq("state", new Integer(ITaskInstance.COMPLETED));

                criteria.add(cri2);

                ProjectionList prolist = Projections.projectionList();
                prolist.add(Projections.rowCount());
                criteria.setProjection(prolist);

                return criteria.uniqueResult();
            }
        });
        return new Integer(result.toString());
    }

    public Integer getAliveTaskInstanceCountForActivity(final String processInstanceId, final String activityId) {
        Object result = this.getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session arg0) throws HibernateException, SQLException {

                Criteria criteria = arg0.createCriteria(TaskInstance.class);
                criteria.add(Expression.eq("processInstanceId", processInstanceId.trim()));

                criteria.add(Expression.eq("activityId", activityId.trim()));

                Criterion cri1 = Expression.eq("state", new Integer(ITaskInstance.INITIALIZED));
                Criterion cri2 = Expression.eq("state", new Integer(ITaskInstance.RUNNING));
//                Criterion cri3 = Expression.eq("state", new Integer(ITaskInstance.SUSPENDED));
                Criterion cri_or = Expression.or(cri1, cri2);
//                Criterion cri_or = Expression.or(cri_tmp, cri3);

                criteria.add(cri_or);

                ProjectionList prolist = Projections.projectionList();
                prolist.add(Projections.rowCount());
                criteria.setProjection(prolist);

                return criteria.uniqueResult();
            }
        });
        return new Integer(result.toString());
    }
    
    public Integer getAliveProcessInstanceCountForParentTaskInstance(final String taskInstanceId) {
        Object result = (Integer) this.getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
                Criteria criteria = arg0.createCriteria(ProcessInstance.class);
                criteria.add(Expression.eq("parentTaskInstanceId", taskInstanceId));

                Criterion cri1 = Expression.eq("state", new Integer(IProcessInstance.INITIALIZED));
                Criterion cri2 = Expression.eq("state", new Integer(IProcessInstance.RUNNING));
//                Criterion cri3 = Expression.eq("state", new Integer(IProcessInstance.SUSPENDED));
                Criterion cri_or = Expression.or(cri1, cri2);
//                Criterion cri_or = Expression.or(cri_tmp, cri3);

                criteria.add(cri_or);

                ProjectionList prolist = Projections.projectionList();
                prolist.add(Projections.rowCount());
                criteria.setProjection(prolist);

                return criteria.uniqueResult();
            }
        });
        return new Integer(result.toString());
    }
}
