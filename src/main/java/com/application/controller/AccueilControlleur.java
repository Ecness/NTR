package com.application.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.application.util.DetailModule;
import com.application.util.PageName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.application.domaine.PdfUserDetails;
import com.application.entity.User;

import javax.servlet.http.HttpSession;
@SessionAttributes({"currentUser"})
@Controller
public class AccueilControlleur {
	
	  private static final Logger log = LogManager.getLogger(AccueilControlleur.class);

	@Autowired
	private DetailModule moduleActif;

	@RequestMapping(value = "/accueil")
	public String init(HttpServletRequest request, Model model) {
		return definitNavigationEtModule(model, PageName.ACCEUIL);
	}
	@RequestMapping(value = {"", "/"})
	public String init2(HttpServletRequest request, Model model) {
		return definitNavigationEtModule(model, PageName.REDIRECT_ACCEUIL);
	}
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return definitNavigationEtModule(model, PageName.LOGIN);
	}

	@RequestMapping(value = "/loginFailed")
	public String loginError(Model model) {
		model.addAttribute("error", "true");
		return definitNavigationEtModule(model, PageName.LOGIN_FAIL);
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model,SessionStatus session) {
		return definitNavigationEtModule(model, PageName.REDIRECT_ACCEUIL);
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session) {
		 log.info("postLogin()");
		// read principal out of security context and set it to session
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
		User loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();
		model.addAttribute("currentUser", loggedInUser.getUsername());
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/";
	}
	private void validatePrinciple(Object principal) {
		if (!(principal instanceof PdfUserDetails)) {
			throw new  IllegalArgumentException("Principal can not be null!");
		}
	}

	private String definitNavigationEtModule( Model model, String page) {
		moduleActif.setModuleAccueil( true );
		model.addAttribute( "moduleActif", moduleActif );
		return page;
	}

}
