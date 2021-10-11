package com.shoes.SportyShoes.repository;

import org.springframework.stereotype.Repository;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, Long>{
	
	 AdminLogin findByUsernameAndPassword(String username, String password) throws SportyShoeBusinessException;
//	 
//	 int save(AdminLogin save);

}