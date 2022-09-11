package yiezi.ml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"yiezi.ml","com.alibaba.cola"})
@MapperScan("yiezi.ml.customer")
public class Application {

    public static void main(String[] args) {
    }
}
