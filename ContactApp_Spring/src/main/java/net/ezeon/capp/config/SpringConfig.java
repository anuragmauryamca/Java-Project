/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ezeon.capp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 *
 * @author Anurag
 */
@Configuration
@ComponentScan(basePackages={"net.ezeon.capp.service"})

public class SpringConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
        
    }
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
    DataSourceTransactionManager tm=new DataSourceTransactionManager();
    tm.setDataSource(dataSource());
        return tm;
    }
    @Bean(destroyMethod="close")
    
    public DataSource dataSource(){
        HikariConfig hc = new HikariConfig();
        hc.setDriverClassName("com.mysql.jdbc.Driver");
        hc.setJdbcUrl("jdbc:mysql://localhost:3306/contact_app_adv_db");
        hc.setUsername("root");
        hc.setPassword("anurag");
        hc.setMaximumPoolSize(2);
        hc.setConnectionTestQuery("SELECT 1");
        hc.setPoolName("my_cp");
        
        hc.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        hc.addDataSourceProperty("dataSource.cachePrepStmts", "10");
        hc.addDataSourceProperty("dataSource.cachePrepStmts", "10");
        hc.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        HikariDataSource dataSource=new HikariDataSource(hc);
        return dataSource;
    }
 
    
}
