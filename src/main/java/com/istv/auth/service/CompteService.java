package com.istv.auth.service;

import java.util.List;

import com.istv.auth.model.Compte;

public interface CompteService {

	void save(Compte compte);
	
	Compte findById(Long id);
	
	List<Compte> findAllCompte();
	
	void deleteCompteById(Long id);
}
