package com.istv.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istv.auth.model.Client;
import com.istv.auth.model.User;

public interface ClientRepository extends JpaRepository<Client, Long>{
	Client findByUser(User user);
	Client findById(Long id);
}
