package com.limos.service;

import com.limos.model.entity.Job;
import com.limos.model.entity.User;
import com.limos.framework.data.BaseService;

/**
 * @author: arifaydogan
 */
public interface MailJobService extends BaseService<Job, Long> {

    /**
     * Sends the confirmation mail to user.
     *
     * @param user
     */
    public void sendConfirmationMail(User user);
}
