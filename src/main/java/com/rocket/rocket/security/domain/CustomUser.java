package com.rocket.rocket.security.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.rocket.rocket.domain.UsersVO;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Getter
public class CustomUser extends User{
	//private static final String ROLE_PREFIX_STRING = "ROLE_";
	private static final long serialVersionUID = 1L;
	
	private UsersVO usersvo;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
		super(username, password, authorities);
		log.info("i am custom user-----1111111-----------");
	}
	public CustomUser(UsersVO vo) {
		super(vo.getUserid(), vo.getPassword(), vo.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		log.info("userid " + vo.getUserid());
		log.info("password " + vo.getPassword());
		this.usersvo = vo;
		log.info("i am custom user--------2222222222------------");
	}
	
}
