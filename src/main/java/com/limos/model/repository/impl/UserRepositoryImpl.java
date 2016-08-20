package com.limos.model.repository.impl;

import com.limos.framework.data.BaseHibernateJPARepository;
import com.limos.model.entity.User;
import com.limos.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * User Repository Implementation
 *
 * @author: arifaydogan
 */
@Repository
public class UserRepositoryImpl extends BaseHibernateJPARepository<User, Long> implements UserRepository {
    private static Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.email = :email")
                .setParameter("email", email).uniqueResult();
    }
}
