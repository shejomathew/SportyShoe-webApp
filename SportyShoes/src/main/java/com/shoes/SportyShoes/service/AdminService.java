package com.shoes.SportyShoes.service;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.AdminLogin;

public interface AdminService{
	
	public AdminLogin adminlogin(String username, String password) throws SportyShoeBusinessException ;
	
	public AdminLogin updatePassword(AdminLogin update) throws SportyShoeBusinessException;
}

