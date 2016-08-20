package com.limos.model.repository.impl;

import com.limos.framework.data.BaseHibernateJPARepository;
import com.limos.model.entity.Job;
import com.limos.model.repository.JobRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by arifaydogan on 01/08/2016.
 */
@Repository
public class JobRepositoryImpl extends BaseHibernateJPARepository<Job, Long> implements JobRepository {
    private static Logger LOG = LoggerFactory.getLogger(JobRepositoryImpl.class);

    @PostConstruct
    public void setUp() {
        LOG.info("jobRepository created..!");
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerPriority(int count) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
        c.setMaxResults(count);
        c.add(Restrictions.eq("status", Job.Status.NEW));
        c.addOrder(Order.asc("categoryPriority"));
        c.addOrder(Order.asc("submitTime"));
        return c.list();
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerPriority(int count) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
        c.setMaxResults(count);
        c.add(Restrictions.eq("status", Job.Status.FAILED));
        c.add(Restrictions.lt("retryCount", 4));
        c.addOrder(Order.desc("categoryPriority"));
        c.addOrder(Order.asc("submitTime"));
        return c.list();
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
        c.setMaxResults(count);
        c.add(Restrictions.eq("status", Job.Status.NEW));
        c.addOrder(Order.asc("submitTime"));
        return c.list();
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(clazz);
        c.setMaxResults(count);
        c.add(Restrictions.eq("status", Job.Status.FAILED));
        c.addOrder(Order.asc("submitTime"));
        return c.list();
    }
}
