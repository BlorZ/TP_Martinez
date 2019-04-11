package com.istv.auth.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.istv.auth.model.Client;
import com.istv.auth.model.Compte;
import com.istv.auth.model.User;
import com.istv.auth.repository.ClientRepository;
import com.istv.auth.service.CompteService;
import com.istv.auth.service.UserService;

@Controller
public class ComptesController {

	@Autowired
	private CompteService compteService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping(value = "getComptes", method = RequestMethod.GET)
	public String getComptes(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User userPrincipal = userService.findByUsername(authentication.getName());
		Client client = clientRepository.findByUser(userPrincipal);
		model.addAttribute("comptes", client.getComptes());
		return "comptes";
	}

	@RequestMapping(value = "getCompteById", method = RequestMethod.GET)
	public String getCompteById(Model model, @RequestParam("idCompte") Long id) {
		Compte compte = compteService.findById(id);
		model.addAttribute("compte", compte);
		return "compte";
	}
	
	@RequestMapping(value = "createCompte", method = RequestMethod.POST)
	public String createCompte(Model model,
			@RequestParam("libelle") String libelle,
			@RequestParam("solde") Float solde,
			@RequestParam("commentaire") String commentaire) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User userPrincipal = userService.findByUsername(authentication.getName());
		Client client = clientRepository.findByUser(userPrincipal);
		Compte c = new Compte();
		c.setVirements(new ArrayList<>());
		c.setLibelle(libelle);
		c.setCommentaire(commentaire);
		c.setSolde(solde);
		
		compteService.save(c);
		client.getComptes().add(c);
		clientRepository.save(client);
		
		model.addAttribute("validation", "Votre compte a été créé avec succès");
		return "welcome";
	}

	@RequestMapping(value = "deleteCompte", method = RequestMethod.POST)
	public String deleteCompte(Model model,
			@RequestParam("idCompte") Long id) {
		compteService.deleteCompteById(id);
		model.addAttribute("validation", "Votre compte a été supprimé avec succès");
		return "welcome";
	}
	
}
