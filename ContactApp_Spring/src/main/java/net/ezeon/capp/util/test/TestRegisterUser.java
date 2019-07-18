
package net.ezeon.capp.util.test;

import javafx.application.Application;
import net.ezeon.capp.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRegisterUser {

  // private final Logger logger=LoggerFactory.getLogger( TestRegisterUser.class);
    public static void main(String[] args) {
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jt=ctx.getBean(JdbcTemplate.class);
      
       
       String sql="INSERT INTO user(`userId`, `name`, `phone`,"
      + " `email`, `address`, `loginName`, `password`,"
      + " `role`, `status`)";
        
    }
    
}
