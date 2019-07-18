
package net.ezeon.capp.util.test;

import javafx.application.Application;
import net.ezeon.capp.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJdbctempate {

 private static final Logger logger=LoggerFactory.getLogger(TestJdbctempate.class);
    public static void main(String[] args) {
        ApplicationContext ctx=
                new AnnotationConfigApplicationContext(SpringConfig.class);
        JdbcTemplate jt=ctx.getBean(JdbcTemplate.class);
      // Integer res= jt.queryForObject("SELECT 1",Integer.class);
     // logger.info("logger information");
     // System.out.println("Result of select query 1"+res);
      String sql="INSERT INTO user( `name`, `phone`,"
              + " `email`, `address`, `loginName`, "
              + "`password`, `role`, `status`) VALUES(?,?,?,?,?,?,?,?)";
      jt.update(sql,"Amit kumar","983737763","anur66@gmail.com",
              "mirzapuur","Ranu","25523",1,1);
      logger.info("Data saved successfully");
     
    }
    
}
