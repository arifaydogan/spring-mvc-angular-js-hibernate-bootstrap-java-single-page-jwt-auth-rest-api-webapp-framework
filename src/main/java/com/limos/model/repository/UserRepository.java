package com.limos.model.repository;

import com.limos.framework.data.BaseJPARepository;
import com.limos.model.entity.User;

/**
 *
 * DD Repository for User related actions and events
 *
 * @author: arifaydogan
 */
public interface UserRepository extends BaseJPARepository<User, Long> {
    /**
     * Finds a user with the given email
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);
}
