package com.digi.unitouch.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.digi.unitouch.model.LoggedUser;
import com.digi.unitouch.model.Users;
import com.digi.unitouch.repository.UserRepo;

@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;


	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Users user = null;
		System.out.println(username);
		if (username != null) {
			user = userRepo.findByUsername(username);
			
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new LoggedUser(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),user.getActive(),
				getGrantedAuthorities(user));

	}

	private List<GrantedAuthority> getGrantedAuthorities(Users user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return authorities;
	}

}
