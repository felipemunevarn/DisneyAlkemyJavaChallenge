package com.alkemyDisney.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User as UserSec;

import com.alkemyDisney.dao.IUserDao;
import com.alkemyDisney.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDao repo;
	
	@Override
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		User user = repo.findUserByUserName(user_name)
				.orElseThrow(() -> new UsernameNotFoundException("User " + user_name + " not found"));
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapingRoles());
	}
	
	private Collection<? extends GrantedAuthority> mapingRoles(){
		Collection<GrantedAuthority> authorization = new ArrayList<>();
		authorization.add(new SimpleGrantedAuthority("user"));
		return authorization;
	}
}
