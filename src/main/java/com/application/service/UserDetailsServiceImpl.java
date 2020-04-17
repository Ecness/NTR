package com.application.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.dao.UserRepository;
import com.application.domaine.PdfUserDetails;
import com.application.entity.Authority;
import com.application.entity.User;
@Service()
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

	private static final Logger log = LogManager.getLogger(UserDetailsServiceImpl.class);
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	log.info("Username : " + username);
        
    	User user = userRepository.getUserByUsername(username);	
		
    	
        if (user == null) {
        	log.info("User not found.");
            throw new UsernameNotFoundException("User not found.");
        }
        
        log.info("User name : " + user.getName());


        log.info("loadUserByUsername() : {}", username);
        return new PdfUserDetails(user);
    }
}