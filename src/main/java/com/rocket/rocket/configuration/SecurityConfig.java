package com.rocket.rocket.configuration;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.ibatis.type.BaseTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.rocket.rocket.security.CustomLoginSuccessHandler;
import com.rocket.rocket.security.CustomUserDetailsService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration // 자바설정파일임을 선언
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity() // 시큐리티 설정클래스임을 선언
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 자동
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();//loginSuccess사용하기위함
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 ) >> 지금 모든 페이지 다 무시하게 해놓음
		web.ignoring().antMatchers("/resources/**"); // "/css/**", "/js/**", "/img/**", "/lib/**" 등등
	}
	

	// 필터들
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// 페이지 권한 설정(큰권한이 제일 상단에 있어야됨)
				.antMatchers("/users/admin/**").hasRole("ADMIN")// 관리자
				.antMatchers("/users/teacher/**").hasRole("2")// 선생님
				.antMatchers("/users/subs/**").hasRole("1")// 구독회원
				.antMatchers("/users/student/**").hasRole("0")// 일반회원
				.antMatchers("/**").permitAll()// 비회원까지
				.anyRequest().authenticated();
				// 로그인 설정
	
				http.formLogin().
				loginPage("/users/login")//로그인 컨트롤러와 일치
				.loginProcessingUrl("/users/login")//form action이랑 일치
				.successHandler(loginSuccessHandler())//@Bean loginSuccessHandler를 의존성 주입해서 가져왔음
				//.defaultSuccessUrl("/users/logout")
				;
				// 로그아웃 설정
				http.logout().logoutUrl("/users/logout")//로그아웃을 요청할 경로이고 기본값은 /logout											
				.invalidateHttpSession(true); 
				
				// 403 예외처리 핸들링
				http.exceptionHandling().accessDeniedPage("/users/access_denied");// 로그인 실패
				//http.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout")) //로그아웃의 기본 URL(/logout) 이 아닌 다른 URL로 재정의합니다.
				//http.logoutSuccessUrl("/users/logout")// 로그아웃이 처리된 후 이동될 경로이고 >> 기본값은/login?logout >> 첫페이지 보낼때 사용할 수 있음

		// http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login");


		//http.csrf().ignoringAntMatchers("/**");
		http.sessionManagement()
       .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

	}
	//권한 아이디설정
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("권한 읽기 시작--------");
		
		auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
		
//		String queryUser = "select email, pw, enabled from users where email = ?";
//		String queryDetails = "select email, auth_num from user_role where email = ?";
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.passwordEncoder(passwordEncoder())
//		.usersByUsernameQuery(queryUser)
//		.authoritiesByUsernameQuery(queryDetails);
		
		
//		test용 임시 계정
//		auth.inMemoryAuthentication().withUser("rocketbot1").password("{noop}rocketbot1").roles("9");
//		auth.inMemoryAuthentication().withUser("rocketbot1").password("$2a$10$kmCUFCNxf0LDqy2OKKdGkuKY7dnZTk.X9/y9vAYtTl8vp9VT4gzs6").roles("9");
//		auth.inMemoryAuthentication().withUser("rocketbot2").password("{noop}rocketbot2").roles("2");
//		auth.inMemoryAuthentication().withUser("rocketbot3").password("{noop}rocketbot3").roles("1");
//		auth.inMemoryAuthentication().withUser("rocketbot4").password("{noop}rocketbot4").roles("0");
//		auth.inMemoryAuthentication().withUser("rocketbot5").password("{noop}rocketbot5").roles("2,9");
		
	}


}
