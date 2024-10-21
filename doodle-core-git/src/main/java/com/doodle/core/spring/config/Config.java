package com.doodle.core.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@ComponentScan(basePackages = "com.doodle.core.spring")
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Config implements WebMvcConfigurer {
	@Bean 
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://{ip:port}/doodle_core?useSSL=false");
			dataSource.setUser("username");
			dataSource.setPassword("password");
		} catch(PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return dataSource;
	}
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.doodle.core.spring.entity");
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", 
				"org.hibernate.dialect.PostgreSQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
