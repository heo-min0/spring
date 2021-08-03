package org.springframework.samples.petclinic.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUrl("jdbc:oracle:thin:@nexgrid2.iptime.org:21521:ORCL");
        basicDataSource.setUsername("COMMUTE_DEV");
        basicDataSource.setPassword("grid#14ghdeo");
        return basicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryMt (DataSource dataSource, ApplicationContext ctx) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(ctx.getResource("classpath:/mybatis/sqlSession-config.xml"));
        sessionFactory.setMapperLocations(ctx.getResources("classpath:/mybatis/mappers/*.xml"));

        return sessionFactory;
    }

    @Bean
    public SqlSessionTemplate sqlTemplate(SqlSessionFactoryBean sqlSession) throws Exception {
        return new SqlSessionTemplate(sqlSession.getObject());
    }

    @Bean
    public MapperScannerConfigurer mapperScanner() {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage("org.springframework.samples.petclinic");

        return scanner;
    }

    @Bean
    public DataSourceTransactionManager transactionManagerDasMt (DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}
