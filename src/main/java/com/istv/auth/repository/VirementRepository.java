package com.istv.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istv.auth.model.Virement;

public interface VirementRepository extends JpaRepository<Virement, Long>{

}
