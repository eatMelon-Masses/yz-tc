package yiezi.ml;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@EnableApolloConfig
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
