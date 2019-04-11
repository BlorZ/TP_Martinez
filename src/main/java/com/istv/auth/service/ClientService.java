package com.istv.auth.service;

import com.istv.auth.model.Client;
import com.istv.auth.model.User;

public interface ClientService {
	void save(Client client);
	
	Client findByUser(User user);
	
	Client findById(Long id);
}
