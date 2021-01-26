package com.rocket.rocket.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.rocket.rocket.domain.UsersVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private UsersVO user;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(UsersVO user) {
		super(user.getEmail(), user.getPw(), user.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth_num())).collect(Collectors.toList()));
		this.user = user;
	}

}
