package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }

    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User where name = :name", User.class)
                .setParameter("name", name)
                .uniqueResult();
//                .list();
    }
}
