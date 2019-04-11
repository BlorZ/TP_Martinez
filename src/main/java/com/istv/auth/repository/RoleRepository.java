package com.istv.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istv.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
