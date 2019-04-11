package com.istv.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istv.auth.model.Compte;
import com.istv.auth.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService{

	@Autowired
	private CompteRepository compteRepository;
	
	@Override
	public void save(Compte compte) {
		compteRepository.save(compte);
		
	}

	@Override
	public Compte findById(Long id) {
		return compteRepository.findOne(id);
	}

	@Override
	public List<Compte> findAllCompte() {
		return compteRepository.findAll();
	}

	@Override
	public void deleteCompteById(Long id) {
		compteRepository.deleteCompteById(id);
	}

}
