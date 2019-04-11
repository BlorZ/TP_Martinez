package com.istv.auth.webservices.payer;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.istv.auth.model.Compte;
import com.istv.auth.model.Virement;
import com.istv.auth.service.CompteService;
import com.istv.auth.service.VirementService;

@WebService(endpointInterface = "com.istv.auth.webservices.payer.WSPayer")
public class WSPayerImpl implements WSPayer{
	
	@Autowired
	private CompteService compteService;
	
	@Autowired
	private VirementService virementService;
	
	@Override
	public void payer(String libelle, Float montant, Long idCompte) throws Exception {
		Compte compte = compteService.findById(idCompte);
		if(null == compte) {
			throw new Exception("Le compte bancaire n'a pas été trouvé");
		}
		if(compte.getSolde() < montant) {
			throw new Exception("vous n'avez pas assez d'argent pour votre achat");
		}

		Virement v = new Virement();
		v.setIdCompteDestinataire(9999L); // cet id correspond à notre site e-commerce
		v.setLibelle(libelle);
		v.setMontantVersement(montant);
		
		virementService.save(v);
		
		compte.getVirements().add(v);
		compte.setSolde(compte.getSolde() - montant);
		
		compteService.save(compte);
	}
	
	@Override
	public String afficheNumCompte(Long idCompte) {
		
		return "Le numéro de compte envoyé est : " + idCompte;
	}
}
