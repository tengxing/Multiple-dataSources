package cn.yjxxclub.demo.datasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Author: Starry.Teng
 * Email: tengxing7452@163.com
 * Date: 17-11-1
 * Time: 下午9:15
 * Describe: MybatisDb1 Config
 */
@Configuration
@MapperScan(basePackages = {"cn.yjxxclub.demo.datasource.dao.db1"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisDb1Config {

    @Qualifier("ds1")
    @Autowired
    DataSource dataSource;

    @Bean(name = "sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mappers/db1/*.xml"));
        factoryBean.setTypeAliasesPackage("cn.yjxxclub.demo.datasource.model");
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }
}