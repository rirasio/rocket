package com.rocket.rocket.domain;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
public class Account implements UserDetails {
		
	private String id;
	private String password;
	
	private String name;
	private String nickname;
	private String birthday;
	private String phone;
	
	private boolean agree_e;	
	private boolean agree_ue;
	
	private Date regdate;
	private Date deldate;

	private String intro;
	private String mbti;
	
	private int failCnt;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	private Collection <? extends GrantedAuthority> authorities;

	

	//--UserDetails----------------------------
	
//	public void setPassword(String password) {
//		PasswordEncoder pwencoder = new BCryptPasswordEncoder();
//		this.password = pwencoder.encode(password);
//	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.isEnabled;
	}

}
