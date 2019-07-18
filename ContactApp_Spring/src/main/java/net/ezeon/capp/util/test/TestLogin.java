package net.ezeon.capp.util.test;

import net.ezeon.capp.config.SpringConfig;
import net.ezeon.capp.domain.User;
import net.ezeon.capp.service.SpringUtil;
import net.ezeon.capp.service.UserBlockedException;
import net.ezeon.capp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestLogin {

    private static final Logger logger = LoggerFactory.getLogger(TestLogin.class);

    public static void main(String[] args) {
        //Initialize Spring Framework       
        UserService service = SpringUtil.ctx.getBean(UserService.class); //get service object from factory(IoC container)
        try {
            User user = service.authenticate("anu", "123");
            if (user == null) {
                logger.info("Login failed. Invalid credentials");
            } else {
                logger.info("Successfully logged in user detail : " + user.getUserId() + " " + user.getName());
            }
        } catch (UserBlockedException ex) {
            logger.info(ex.getMessage());
        }

    }
}
