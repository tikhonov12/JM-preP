package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void createUsersTable() {
        Session sess = sessionFactory.openSession();
        Transaction tx1 = sess.beginTransaction();
        sess.createSQLQuery("create table if not exists user(" +
                "id bigint auto_increment primary key," +
                "name varchar(45) not null," +
                "lastName varchar(45) not null," +
                "age int not null)").executeUpdate();
        tx1.commit();
    }

    @Override
    public void dropUsersTable() {
        Session sess = sessionFactory.openSession();
        Transaction tx1 = sess.beginTransaction();
        sess.createSQLQuery("drop table if exists user").executeUpdate();
        tx1.commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(new User(name,lastName,age));
        tx1.commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(session.get(User.class, id));
        tx1.commit();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public void cleanUsersTable() {
        Session sess = sessionFactory.openSession();
        Transaction tx1 = sess.beginTransaction();
        sess.createSQLQuery("truncate table user").executeUpdate();
        tx1.commit();
    }
}
