package com.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.dao.CompteRepository;
import com.application.dao.OperationRepository;
import com.application.dao.UserRepository;
import com.application.entity.CompteBancaire;
import com.application.entity.User;

import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


@RestController
public class RestControlleur {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;

	@GetMapping(path="/infoUser/{numeroUser}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Get EnseignantFavoris by numeroAgrement")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "EnseignantFavoris found"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal error") })
	public List<CompteBancaire> getInformationUser(@PathVariable @NotBlank Integer numeroUser) {
		Optional<User> userFind = userRepository.findById(numeroUser);
		User user = userFind.get();
		List<CompteBancaire> compteBancaires = new ArrayList<CompteBancaire>();
		
		if (user != null) {
			compteBancaires = user.getCompteBancaires();
		}
		return compteBancaires;
	}
	
}
