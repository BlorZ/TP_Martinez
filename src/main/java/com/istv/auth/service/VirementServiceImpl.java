package com.istv.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istv.auth.model.Virement;
import com.istv.auth.repository.VirementRepository;

@Service
public class VirementServiceImpl implements VirementService{

	@Autowired
	private VirementRepository virementRepository;
	
	@Override
	public void save(Virement virement) {
		virementRepository.save(virement);
	}

}
