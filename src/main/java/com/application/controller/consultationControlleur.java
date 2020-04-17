package com.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.application.util.DetailModule;
import com.application.util.PageName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.application.dao.CompteRepository;
import com.application.dao.OperationRepository;
import com.application.dao.UserRepository;
import com.application.entity.CompteBancaire;
import com.application.entity.Operation;
import com.application.entity.User;

@SessionAttributes({"currentUser"})
@Controller
public class consultationControlleur {
	
	private static final Logger log = LogManager.getLogger(consultationControlleur.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;
	@Autowired
	private DetailModule moduleActif;

	@RequestMapping(value = "/consultation")
	public String init(HttpServletRequest request, Model model) throws Exception {
		
		
		try {
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = "";

			if (principal instanceof UserDetails) {
				username = ((UserDetails)principal).getUsername();
			} else {
				username = principal.toString();
			}

			log.info("loadUserByUsername() : {}", username);

			User user = userRepository.getUserByUsername(username);
			
			model.addAttribute( "comptes", user.getCompteBancaires() );
		} catch (Exception e) {
			throw new Exception("Fail to load bank accounts");
		}
		
		return definitNavigationEtModule(model, PageName.CONSULTATION);
	}
	
	private String definitNavigationEtModule( Model model, String page) {
		moduleActif.setModuleConsultation( true );
		model.addAttribute( "moduleActif", moduleActif );
		return page;
	}

}
