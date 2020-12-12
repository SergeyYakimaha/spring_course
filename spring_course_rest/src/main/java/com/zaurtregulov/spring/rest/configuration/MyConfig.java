package com.zaurtregulov.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

// Конфигурация без XML файла

// Данный класс является Java Configuration
@Configuration
// <context:component-scan base-package="com.zaurtregulov.spring.mvc_hibernate_aop" />
@ComponentScan(basePackages = "com.zaurtregulov.spring.rest")
// <mvc:annotation-driven/>
@EnableWebMvc
//<tx:annotation-driven transaction-manager="transactionManager" />
@EnableTransactionManagement
public class MyConfig {

//    <bean id="dataSource"
//    class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
//        <property name="driverClass" value="org.postgresql.Driver" />
//        <property name="jdbcUrl" value="jdbc:postgresql://127.0.0.1:5432/my_db" />
//        <property name="user" value="postgres" />
//        <property name="password" value="admin" />
//    </bean>

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/my_db");
            dataSource.setUser("postgres");
            dataSource.setPassword("admin");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

//    <bean id="sessionFactory"
//    class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
//        <property name="dataSource" ref="dataSource" />
//        <property name="packagesToScan" value="com.zaurtregulov.spring.mvc_hibernate_aop.entity" />
//        <property name="hibernateProperties">
//            <props>
//                <prop key="hibernate.dialect">org.hibernate.dialect.PostgreSQL95Dialect</prop>
//                <prop key="hibernate.show_sql">true</prop>
//            </props>
//        </property>
//    </bean>

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.zaurtregulov.spring.rest.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

//    <bean id="transactionManager"
//    class="org.springframework.orm.hibernate5.HibernateTransactionManager">
//        <property name="sessionFactory" ref="sessionFactory"/>
//    </bean>

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }
}
