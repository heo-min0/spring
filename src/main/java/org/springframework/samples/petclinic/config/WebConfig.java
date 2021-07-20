package org.springframework.samples.petclinic.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@PropertySource("classpath:/application.properties")
public class WebConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:db/h2/schema.sql")
            .addScript("classpath:db/h2/data.sql")
            .build();
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
