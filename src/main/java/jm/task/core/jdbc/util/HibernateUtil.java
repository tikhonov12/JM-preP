package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static final String URL = "jdbc:mysql://localhost:3306/users?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static synchronized SessionFactory getSessionFactory() {
            try {
                Configuration cfg = new Configuration()
                        .setProperty("hibernate.connection.driver_class",
                                "com.mysql.jdbc.Driver")
                        .setProperty("hibernate.connection.url", URL)
                        .setProperty("hibernate.connection.username", USER)
                        .setProperty("hibernate.connection.password", PASSWORD)
                        .setProperty("hibernate.connection.pool_size", "1")
                        .setProperty("hibernate.connection.autocommit", "false")
                        .setProperty("hibernate.cache.provider_class",
                                "org.hibernate.cache.NoCacheProvider")
                        .setProperty("hibernate.cache.use_second_level_cache",
                                "false")
                        .setProperty("hibernate.cache.use_query_cache", "false")
                        .setProperty("hibernate.dialect",
                                "org.hibernate.dialect.MySQLDialect")
                        .setProperty("hibernate.show_sql", "true")
                        .setProperty("hibernate.current_session_context_class",
                                "thread")
                        .addPackage("jm.task.core.jdbc")
                        .addAnnotatedClass(User.class);
                ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(sr);
            } catch (HibernateException ex) {
                System.out.println(ex.getMessage() + "Не удалось подключиться к бд");
                throw new RuntimeException();
            }

        return sessionFactory;
    }
}
