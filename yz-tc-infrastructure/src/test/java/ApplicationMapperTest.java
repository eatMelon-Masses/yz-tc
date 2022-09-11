import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"yiezi.ml","com.alibaba.cola"})
@MapperScan("yiezi.ml.customer")
public class ApplicationMapperTest {

    public static void main(String[] args) {
    }

//    private final static String DATASOURCE_PREIFX = "spring.datasource";
//
//    @Bean
//    @ConfigurationProperties(prefix = DATASOURCE_PREIFX)
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        return dataSourceBuilder.build();
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
//
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
}
