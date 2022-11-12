package com.yedam.java.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Setter;

@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter  extends WebSecurityConfigurerAdapter{
	// security-context.xml과 함께 보세요.
	// xml에서 설정할 것을 java로 설정 한 것 뿐입니다.
	// spring은 xml,java 둘 다 설정 가능해요
	// 그런데 !! spring boot는 java기반으로
	
	@Setter(onMethod_ = {@Autowired})
	DataSource dataSource;
	
	@Bean
	protected CustomLoginSuccessHandler successHandler() {
		System.out.println("==========================");
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	protected PasswordEncoder bcrypt() {
		return new BCryptPasswordEncoder();
	}
	
	// security-context.xml과 함께 보세요.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/top.jsp").permitAll() // top.jsp로 들어오는 경우는 permitAll()
			//.antMatchers("/top.jsp","","").permitAll() 콤마로 jsp 더 추가해도 된다.
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().authenticated() 
			.and()
			.formLogin().loginPage("/login.jsp")
						.usernameParameter("userId")
						.loginProcessingUrl("/login")
						.successHandler(successHandler())
						.permitAll()
			.and()
			.logout().logoutUrl("/logout")
				     .logoutSuccessUrl("/top.jsp")
			.and()
			.exceptionHandling().accessDeniedPage("/accessDenied.jsp")
			.and()
			.csrf().disable()
			;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String loginSql = "select LOGIN_ID, PASSWORD, 1 from T_USER where LOGIN_ID = ?";
		String authSql = "select LOGIN_ID, ROLE_NAME from T_ROLE "+ 
				 	  "inner join T_USER_ROLE on T_ROLE.ID = T_USER_ROLE.ROLE_ID "+
				 	  "inner join T_USER on T_USER_ROLE.USER_ID = T_USER.ID "+ 
				 	  "where LOGIN_ID = ?";		
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(loginSql)
		    .authoritiesByUsernameQuery(authSql)
		    //.passwordEncoder(bcrypt())
		    ;
	}

	
}
