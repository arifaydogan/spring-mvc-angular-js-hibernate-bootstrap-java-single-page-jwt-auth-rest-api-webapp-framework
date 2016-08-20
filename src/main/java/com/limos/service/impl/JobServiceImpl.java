package com.limos.service.impl;

import com.limos.framework.data.BaseJPAServiceImpl;
import com.limos.model.entity.Job;
import com.limos.model.repository.JobRepository;
import com.limos.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by arifaydogan on 01/08/2016.
 */
@Service
@Transactional
public class JobServiceImpl extends BaseJPAServiceImpl<Job, Long> implements JobService {
    private static Logger LOG = LoggerFactory.getLogger(JobServiceImpl.class);

    protected @Autowired
    JobRepository jobRepository;

    @PostConstruct
    public void setupService() {
        LOG.info("setting up jobService...");
        this.baseJpaRepository = jobRepository;
        this.entityClass = Job.class;
        this.baseJpaRepository.setupEntityClass(Job.class);
        LOG.info("jobService created...");
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerPriority(int count) {
        return jobRepository.fetchNewJobsToBeScheduledForExecutionPerPriority(count);
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerPriority(int count) {
        return jobRepository.fetchFailedJobsToBeScheduledForExecutionPerPriority(count);
    }

    @Override
    public List<Job> fetchNewJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
        return jobRepository.fetchNewJobsToBeScheduledForExecutionPerSubmissionTimePriority(count);
    }

    @Override
    public List<Job> fetchFailedJobsToBeScheduledForExecutionPerSubmissionTimePriority(int count) {
        return jobRepository.fetchFailedJobsToBeScheduledForExecutionPerSubmissionTimePriority(count);
    }
}