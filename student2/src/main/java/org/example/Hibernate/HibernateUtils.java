package org.example.Hibernate;


import org.example.pojo.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL,"jdbc:mysql://localhost:3306/qlsv");
        props.put(Environment.USER,"root");
        props.put(Environment.PASS,"1234567");
        props.put(Environment.SHOW_SQL,"true");
        props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

        conf.setProperties(props);
        conf.addAnnotatedClass(Student.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();


        FACTORY = conf.buildSessionFactory(reg);


    }

    public  static SessionFactory getFactory(){
        return FACTORY;
    }
    
    
    
}
