package com.istv.auth.web;

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
import com.istv.auth.model.Virement;
import com.istv.auth.service.ClientService;
import com.istv.auth.service.CompteService;
import com.istv.auth.service.UserService;
import com.istv.auth.service.VirementService;

@Controller
public class VirementController {

	@Autowired
	private VirementService virementService;
	
	@Autowired
	private CompteService compteService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "addVirement", method = RequestMethod.POST)
	public String addVirement(Model model, @RequestParam("idCompteDebitaire") Long idCompteDebitaire,
			@RequestParam("idCompteCreditaire") Long idCompteCreditaire, 
			@RequestParam("montant") Float montant,
			@RequestParam("libelle") String libelle) {
		
		Compte compteDebitaire = compteService.findById(idCompteDebitaire);
		Compte compteCreditaire = compteService.findById(idCompteCreditaire);
		
		if(null == compteCreditaire) {
			model.addAttribute("error", "Le compte " + idCompteCreditaire + " n'a pas été trouvé");
			return "welcome";
		}
		
		Virement v1 = new Virement();
		v1.setIdCompteDestinataire(idCompteCreditaire);
		v1.setLibelle(libelle);
		v1.setMontantVersement(-montant); 
		virementService.save(v1);
		
		Virement v2 = new Virement();
		v2.setIdCompteDestinataire(idCompteDebitaire);
		v2.setLibelle(libelle);
		v2.setMontantVersement(montant); 
		virementService.save(v2);
		
		compteDebitaire.getVirements().add(v1);
		compteDebitaire.setSolde(compteDebitaire.getSolde() - montant);
		compteCreditaire.getVirements().add(v2);
		compteCreditaire.setSolde(compteCreditaire.getSolde() + montant);
		
		compteService.save(compteDebitaire);
		compteService.save(compteCreditaire);
		
		model.addAttribute("validation", "Le virement a été effectué avec succès");
		return "welcome";
	}
	
	@RequestMapping(value = "getCompteToVirement", method = RequestMethod.GET)
	public String getCompteToVirement(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User userPrincipal = userService.findByUsername(authentication.getName());
		Client client = clientService.findByUser(userPrincipal);
		model.addAttribute("comptes", client.getComptes());
		return "selectCompteToVirement";
	}

	@RequestMapping(value = "redirectVirement", method = RequestMethod.GET)
	public String redirectVirement(Model model, @RequestParam("idCompte") Long idCompte){
		model.addAttribute("idCompteDebitaire", idCompte);
		return "virement";
	}
}
