package com.godeltech.mastery.task.config;

import com.godeltech.mastery.task.dao.EmployeeDao;
import com.godeltech.mastery.task.dao.EmployeeDaoImpl;
import com.godeltech.mastery.task.service.EmployeeServiceImpl;
import com.godeltech.mastery.task.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("db.url");
        dataSource.setUsername("db.username");
        dataSource.setPassword("db.password");
        dataSource.setDriverClassName("db.driverClassName");
        return dataSource;
    }

    @Bean
    public EmployeeDao getEmployeeDao() {
        return new EmployeeDaoImpl();
    }

   /* @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl();
    }*/
}
