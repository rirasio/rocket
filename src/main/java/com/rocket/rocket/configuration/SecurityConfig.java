package com.rocket.rocket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import lombok.AllArgsConstructor;

@Configuration // 자바설정파일임을 선언
@EnableWebSecurity // 시큐리티 설정클래스임을 선언
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 자동
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 ) >> 지금 모든 페이지 다 무시하게 해놓음
		web.ignoring().antMatchers("/resources/**"); // "/css/**", "/js/**", "/img/**", "/lib/**" 등등
	}

	// 필터들
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();

		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);

		http.addFilterBefore(filter, CsrfFilter.class);
		// Cross-site request forgery ::
		// 타사이트에서 본인의 사이트로 form 데이터를 사용하여 공격하려고 할 때, 그걸 방지하기 위해 csrf 토큰 값을 사용하는 것 >>
		// hidden 으로 값 들어옴
		// https://velog.io/@max9106/Spring-Security-csrf

		http.authorizeRequests()
				// 페이지 권한 설정(큰권한이 제일 상단에 있어야됨)
				.antMatchers("/admin/**").hasRole("9")// 관리자
				.antMatchers("/users/myTeacher/**").hasRole("2")// 선생님
				.antMatchers("/users/StudentSub/**").hasRole("1")// 구독회원
				.antMatchers("/users/Student/**").hasRole("0")// 일반회원
				.antMatchers("/**").permitAll()// 비회원까지
				.and()
				// 로그인 설정
				.formLogin().loginPage("/users/login").defaultSuccessUrl("/users/login/result").permitAll().and()
				// 로그아웃 설정
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
				.logoutSuccessUrl("/users/logout/result").invalidateHttpSession(true).and()
				// 403 예외처리 핸들링
				.exceptionHandling().accessDeniedPage("/user/denied");// 로그인 실패

		// http.formLogin().loginPage("/customLogin").loginProcessingUrl("/login");

		// http.csrf().ignoringAntMatchers("/**");

	}

}
