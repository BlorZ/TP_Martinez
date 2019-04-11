package com.istv.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istv.auth.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
	@Transactional
	void deleteCompteById(Long id);
}
