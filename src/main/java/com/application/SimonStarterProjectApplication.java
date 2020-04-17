package com.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.application.configuration.WebSecurityConfig;
import com.application.dao.AuthorityRepository;
import com.application.dao.CompteRepository;
import com.application.dao.OperationRepository;
import com.application.dao.UserRepository;
import com.application.entity.Authority;
import com.application.entity.AuthorityType;
import com.application.entity.CompteBancaire;
import com.application.entity.Operation;
import com.application.entity.OperationType;
import com.application.entity.User;

@SpringBootApplication
public class SimonStarterProjectApplication {


	private static final Logger log = LogManager.getLogger(WebSecurityConfig.class);
	
	public static void main(String[] args) {
	 	 ApplicationContext context =   SpringApplication.run(SimonStarterProjectApplication.class, args);
	 	insertUserAndGetUser(context);
	}

	
	private static void insertUserAndGetUser(ApplicationContext context) {
		UserRepository userRepository = context.getBean(UserRepository.class);
		AuthorityRepository authorityRepository = context.getBean(AuthorityRepository.class);
		OperationRepository operationRepository = context.getBean(OperationRepository.class);
		CompteRepository compteRepository = context.getBean(CompteRepository.class);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String pwd = passwordEncoder.encode("user");
		String pwd2 = passwordEncoder.encode("user2");
		
		Authority authority = new Authority(AuthorityType.USER);
			
		Set<Authority> authorities = new HashSet<>();
		authorities.add(authority);
		Set<Authority> authorities2 = new HashSet<>();
		authorities.add(authority);
		
		User user = new User("user",pwd,"User_Test",authorities);
		User user2 = new User("user2",pwd2,"User_Test2",authorities2);

		
		
		Operation operation = new Operation(50, OperationType.RETRAIT.toString());
		Operation operation2 = new Operation(50, OperationType.DEPOT.toString());
		Operation operation3 = new Operation(30, OperationType.RETRAIT.toString());
		Operation operation4 = new Operation(910, OperationType.DEPOT.toString());
		
		CompteBancaire compteBancaire = new CompteBancaire(500);
		CompteBancaire compteBancaire2 = new CompteBancaire(-500);
		
		compteBancaire.getOperationBancaires().add(operation);
		compteBancaire.getOperationBancaires().add(operation2);

		compteBancaire2.getOperationBancaires().add(operation3);
		compteBancaire2.getOperationBancaires().add(operation4);
		
		user.getCompteBancaires().add(compteBancaire);
		user2.getCompteBancaires().add(compteBancaire2);
		
		userRepository.save(user);
		log.info("ici");
		userRepository.save(user2);
	}
}