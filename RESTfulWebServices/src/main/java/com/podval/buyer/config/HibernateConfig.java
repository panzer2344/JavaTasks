package com.podval.buyer.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("com.podval.buyer.dao"),
        @ComponentScan("com.podval.buyer.services")
})
public class HibernateConfig {

    @Autowired
    private Environment environment;

    @Autowired
    public DataSource dataSource;


    private Properties hibernateProperites(){
        Properties p = new Properties();
        p.put("hibernate.dialect", environment.getRequiredProperty("spring.datasource.dialect"));
        return p;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(new String("com.podval.buyer.models"));
        sessionFactoryBean.setHibernateProperties(hibernateProperites());
        return sessionFactoryBean;
    }

}
