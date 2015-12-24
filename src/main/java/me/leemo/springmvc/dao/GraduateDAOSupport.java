package me.leemo.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;

/**
 * Created by Leemo on 15-12-24
 */
public class GraduateDAOSupport extends HibernateDaoSupport {
    @Resource(name = "graduate_sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Session getSession() {
        return this.getSessionFactory().getCurrentSession();
    }
}
