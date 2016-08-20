package com.limos.service.impl;

import com.limos.framework.data.BaseJPAServiceImpl;
import com.limos.model.entity.Job;
import com.limos.model.entity.User;
import com.limos.model.repository.JobRepository;
import com.limos.service.MailJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

/**
 * @author: arifaydogan
 */
@Service
@Transactional
public class MailJobServiceImpl extends BaseJPAServiceImpl<Job, Long> implements MailJobService {
    private static Logger LOG = LoggerFactory.getLogger(MailJobServiceImpl.class);

    protected @Autowired
    JobRepository jobRepository;

    @PostConstruct
    public void setupService() {
        LOG.info("setting up mailJobService...");
        this.baseJpaRepository = jobRepository;
        this.entityClass = Job.class;
        this.baseJpaRepository.setupEntityClass(Job.class);
        LOG.info("mailJobService created...");
    }

    @Override
    public void sendConfirmationMail(User user) {

    }
}
