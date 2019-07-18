
package net.ezeon.capp.service;

import net.ezeon.capp.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Anurag
 */
public class SpringUtil {
public static final     ApplicationContext ctx;
             static {
                ctx= new AnnotationConfigApplicationContext(SpringConfig.class); 
             }
               
}

