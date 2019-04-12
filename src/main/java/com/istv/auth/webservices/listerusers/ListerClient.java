package com.istv.auth.webservices.listerusers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istv.auth.model.Client;
import com.istv.auth.repository.ClientRepository;

@RestController
public class ListerClient implements IListerClient{

	@Autowired
	private ClientRepository clientService;
	
	@Override
	@RequestMapping("/users")
	public List<InfosUsers> listerUser() {
		List<InfosUsers> users = new ArrayList<>();
		List<Client> clients = clientService.findAll();
		
		for(Client c: clients) {
			InfosUsers iu = new InfosUsers();
			iu.setUsername(c.getUser().getUsername());
			iu.setComptes(c.getComptes());
			users.add(iu);	
		}
		return users;
	}

}
