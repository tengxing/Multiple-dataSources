package cn.yjxxclub.demo.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-11-1
 * Time: 下午9:14
 * Describe: DataSource Config
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    Environment env;

    @Bean(name = "ds1")
    public DataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(env.getProperty("spring.datasource.db1.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.db1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db1.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.db1.driver-class-name"));
        return dataSource;
    }

    @Bean(name = "ds2")
    public DataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(env.getProperty("spring.datasource.db2.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.db2.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db2.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.db2.driver-class-name"));
        return dataSource;
    }

}
