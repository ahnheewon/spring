
package com.yedam.java.security;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.yedam.java")
@MapperScan(basePackages = "com.yedam.java.**.mapper")
public class DataSourceConfig {
	// database-context.xml과 함께보세요.
	// xml에서 설정할 것을 java로 설정 한 것 뿐입니다.
	@Bean
	public DataSource dataSoure() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("hr");
		hikariConfig.setPassword("hr");
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public SqlSessionFactoryBean getSqlSessionFactory() {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSoure());
		factory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		return factory;
	}
	
}
