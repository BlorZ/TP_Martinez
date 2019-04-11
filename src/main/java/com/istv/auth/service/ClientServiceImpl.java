package com.istv.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istv.auth.model.Client;
import com.istv.auth.model.User;
import com.istv.auth.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void save(Client client) {
		clientRepository.save(client);
	}

	@Override
	public Client findByUser(User user) {
		return clientRepository.findByUser(user);
	}

	@Override
	public Client findById(Long id) {
		return clientRepository.findById(id);
	}

}
