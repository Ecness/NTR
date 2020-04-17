package com.application.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.dao.CompteRepository;
import com.application.dao.OperationRepository;
import com.application.dao.UserRepository;
import com.application.entity.CompteBancaire;
import com.application.entity.Operation;
import com.application.entity.User;
import com.application.xml.CompteBancaireVO;
import com.application.xml.OperationVO;
import com.application.xml.UserVO;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class RestServiceControlleur {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	OperationRepository operationRepository;

	@RequestMapping(value = "/service/{numeroUser}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "EnseignantFavoris found"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal error") })
    public ResponseEntity<UserVO> getuserById (@PathVariable("numeroUser") int id) 
    {
		Optional<User> userFind = userRepository.findById(id);
		User user = userFind.get();
		List<CompteBancaire> compteBancaires = new ArrayList<CompteBancaire>();
		
		if (user != null) {
			compteBancaires = user.getCompteBancaires();
			UserVO userReponse = new UserVO(new ArrayList<CompteBancaireVO>());
			OperationVO operationreponse = null;
			CompteBancaireVO compteBancairesReponse = null;
			
			for (CompteBancaire compteBancaire : compteBancaires) {
				compteBancairesReponse = new CompteBancaireVO(compteBancaire.getIdCompte(), new ArrayList<OperationVO>());
				for (Operation operation : compteBancaire.getOperationBancaires()) {
					operationreponse = new OperationVO(operation.getIdOperation(), operation.getSomme(), operation.getOperation());
					compteBancairesReponse.getOperationBancaires().add(operationreponse);
				}
				userReponse.getoperationBancaires().add(compteBancairesReponse);
			}
			userReponse.setId(user.getId());
			return new ResponseEntity<UserVO>(userReponse, HttpStatus.OK);
		}
		return new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
    }
	
	

}
