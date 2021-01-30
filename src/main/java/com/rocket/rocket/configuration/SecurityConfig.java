package com.rocket.rocket.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity() // 시큐리티 설정클래스임을 선언
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@AllArgsConstructor // 클래스에 존재하는 모든 필드에 대한 생성자를 자동
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 ) >> 지금 모든 페이지 다 무시하게 해놓음
		web.ignoring().antMatchers("/resources/**"); // "/css/**", "/js/**", "/img/**", "/lib/**" 등등
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests() // 해당 메소드 아래는 각 경로에 따른 권한을 지정할 수 있다.
                .antMatchers("/users/admin").hasRole("ADMIN") // 괄호의 권한을 가진 유저만 접근가능, ROLE_가 붙어서 적용 됨. 즉, 테이블에 ROLE_권한명 으로 저장해야 함.
                .antMatchers("/users/student").hasRole("STUDENT")
                .antMatchers("/users/teacher").hasRole("TEACHER")
                .anyRequest().authenticated()  //  로그인된 사용자가 요청을 수행할 떄 필요하다  만약 사용자가 인증되지 않았다면, 스프링 시큐리티 필터는 요청을 잡아내고 사용자를 로그인 페이지로 리다이렉션 해준다.
                .and()
            .formLogin() // 하위에 내가 직접 구현한 로그인 폼, 로그인 성공시 이동 경로 설정 가능. , 로그인 폼의 아이디,패스워드는 username, password로 맞춰야 함
                        .loginPage("/users/login") // 로그인이 수행될 경로.
                        .loginProcessingUrl("/users/login")// 로그인form의  action과 일치시켜주어야 함.
                        .defaultSuccessUrl("/") // 로그인 성공 시 이동할 경로.
                        .failureUrl("/login?error=true") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸
                .permitAll()
                .and()
             .logout()
                 .permitAll()
                 .logoutUrl("/logout")
                 .logoutSuccessUrl("/")
                 .and()
             .exceptionHandling()
                 .accessDeniedPage("/accessDenied_page"); // 권한이 없는 대상이 접속을시도했을 때
        
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

    }
    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		log.info("권한 읽기 시작--------");

		// test용 임시 계정
		// 하드코딩 비밀번호는 1111입니다.
		String epassword = new BCryptPasswordEncoder().encode("1111");
		auth.inMemoryAuthentication().withUser("9999").password(epassword).roles("9");
		auth.inMemoryAuthentication().withUser("1111").password(epassword).roles("1");
		auth.inMemoryAuthentication().withUser("2222").password(epassword).roles("2");
		auth.inMemoryAuthentication().withUser("0000").password(epassword).roles("0");



	}
}

