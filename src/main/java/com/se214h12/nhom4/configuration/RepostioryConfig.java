/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.configuration;

import java.io.IOException;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Stevie
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.se214h12.nhom4.repositories")
@PropertySource("classpath:prod.properties")
@EnableJpaRepositories(basePackages = "com.se214h12.nhom4.repositories", entityManagerFactoryRef = "emf")
@EnableTransactionManagement
public class RepostioryConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            JpaVendorAdapter adapter, DataSource dataSource
    ) {
        Properties prop = new Properties();
        prop.setProperty("hibernate.format_sql", String.valueOf(true));

        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(adapter);
        bean.setPackagesToScan("com.se214h12.nhom4.model");
        bean.setJpaProperties(prop);

        return bean;
    }

//    @Bean(name = "emf")
//    public EntityManagerFactory entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setShowSql(false);
//        vendorAdapter.setGenerateDdl(false);
//        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.se214h12.nhom4.repositories");
//        factory.setDataSource(dataSource());
//        factory.setPersistenceUnitName("com.se214h12_nhom4_war_1.0-SNAPSHOTPU");
//        factory.setPersistenceProvider(new HibernatePersistenceProvider());
//        //factory.setBeanClassLoader(ClassLoader.getSystemClassLoader());
//        factory.setJpaProperties(additionalProperties());
//        factory.afterPropertiesSet();
//        return factory.getObject();
//    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

//    @Bean
//    public PlatformTransactionManager transactionManager() throws IOException {
//
////        JpaTransactionManager txManager = new JpaTransactionManager();
////        txManager.setEntityManagerFactory(entityManagerFactory());
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.se214h12.nhom4.repositories");
//        sessionFactory.setHibernateProperties(additionalProperties());
//        sessionFactory.afterPropertiesSet();
//        txManager.setSessionFactory(sessionFactory.getObject());
//        return txManager;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
////        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        return properties;
//    }
    
}
