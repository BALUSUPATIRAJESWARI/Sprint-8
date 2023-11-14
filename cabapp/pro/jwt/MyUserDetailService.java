package com.cabapp.pro.jwt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cabapp.pro.entity.Admin;
import com.cabapp.pro.entity.Customer;
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.repository.IAdminRepository;
import com.cabapp.pro.repository.ICustomerRepository;
import com.cabapp.pro.repository.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	@Autowired
	private IAdminRepository adminRepository;
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IDriverRepository driverRepository;
	 private String name; 
	    private String password; 
	    private List<GrantedAuthority> authorities; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = customerRepository.findByUsername(username);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getCustomerAuthority(user));
		}
		Admin admin = adminRepository.findByUsername(username);
		if(admin !=null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getAdminAuthority(user));
		}
		Driver driver = driverRepository.findByUsername(username);
		if(driver !=null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getAdminAuthority(user));
		}
		throw new UsernameNotFoundException("User not found with username: " + username);

	}
	
	  private Set<SimpleGrantedAuthority> getCustomerAuthority(Customer user) {
	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	            authorities.add(new SimpleGrantedAuthority("ROLE_" + "Customer"));
	        return authorities;
	    }

	private Set<SimpleGrantedAuthority> getAdminAuthority(Customer user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + "Admin"));
		return authorities;
	}

	private Set<SimpleGrantedAuthority> getDriverAuthority(Customer user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + "driver"));
		return authorities;
	}
}
