package me.leemo.springmvc.dao;

import me.leemo.springmvc.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by Leemo on 15-12-24
 */
@Repository
public class UserDao extends GraduateDAOSupport {
    public void save(UserEntity user) throws Exception {
        Session session = this.getSession();
        Transaction tc = (Transaction) session.beginTransaction();
        session.save(user);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.close();
            System.out.println();
            Exception wrapE = new Exception(e.getCause().getMessage(), e);
            throw wrapE;
        }
    }
}
