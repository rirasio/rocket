package com.rocket.rocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.rocket.rocket.security.CustomLoginSuccessHandler;

import lombok.AllArgsConstructor;

@Configuration // 자바설정파일임을 선언
@EnableWebSecurity // 시큐리티 설정클래스임을 선언
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 자동
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 ) >> 지금 모든 페이지 다 무시하게 해놓음
//		web.ignoring().antMatchers("/resources/**"); // "/css/**", "/js/**", "/img/**", "/lib/**" 등등
//	}
	
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	

	
	// 필터들
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// 페이지 권한 설정(큰권한이 제일 상단에 있어야됨)
				.antMatchers("/users/admin/**").hasRole("9")// 관리자
				.antMatchers("/users/teacher/**").hasRole("2")// 선생님
				.antMatchers("/users/subs/**").hasRole("1")// 구독회원
				.antMatchers("/users/student/**").hasRole("0")// 일반회원
				.antMatchers("/**").permitAll()// 비회원까지
				// 로그인 설정
				.and()
				.formLogin().
				loginPage("/users/login")//로그인 컨트롤러와 일치
				.loginProcessingUrl("/users/login")//form action이랑 일치
				.successHandler(loginSuccessHandler())//@Bean loginSuccessHandler를 의존성 주입해서 가져왔음
				.permitAll()
				// 로그아웃 설정
				.and()
				.logout().logoutUrl("/users/logout")//로그아웃을 요청할 경로이고 기본값은 /logout											
				.invalidateHttpSession(true) 
				.and()
				// 403 예외처리 핸들링
				.exceptionHandling().accessDeniedPage("/users/access_denied");// 로그인 실패
				//http.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout")) //로그아웃의 기본 URL(/logout) 이 아닌 다른 URL로 재정의합니다.
				//http.logoutSuccessUrl("/users/logout")// 로그아웃이 처리된 후 이동될 경로이고 >> 기본값은/login?logout >> 첫페이지 보낼때 사용할 수 있음

		// http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login");

		// http.csrf().ignoringAntMatchers("/**");

	}
	//권한 아이디 테스트
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("rocketbot1").password("{noop}rocketbot1").roles("9");
		auth.inMemoryAuthentication().withUser("rocketbot2").password("{noop}rocketbot2").roles("2");
		auth.inMemoryAuthentication().withUser("rocketbot3").password("{noop}rocketbot3").roles("1");
		auth.inMemoryAuthentication().withUser("rocketbot4").password("{noop}rocketbot4").roles("0");
		auth.inMemoryAuthentication().withUser("rocketbot5").password("{noop}rocketbot5").roles("2,9");
		
	}


}
