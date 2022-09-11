package yiezi.ml.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import yiezi.ml.customer.CustomerMapper;


/**
 * @author zhouye
 * @date 2022/8/28
 */
@RunWith(SpringRunner.class)
@MapperScan(basePackages = "yiezi.ml.customer")
@EnableAutoConfiguration
@TestPropertySource("classpath:application.properties")
public class MapperTest {

    @Autowired
    private CustomerMapper customerMapper;
    @Test
    public void customerTest() {
        System.out.println(customerMapper.selectAll());
    }

}
