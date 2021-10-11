package com.shoes.SportyShoes.serviceimpl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoes.SportyShoes.exception.ErrorConstants;
import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.AdminLogin;
import com.shoes.SportyShoes.repository.AdminRepository;
import com.shoes.SportyShoes.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repo;

	@PostConstruct
	public void init(){

		AdminLogin admin = new AdminLogin("admin", "password");
		repo.save(admin);

	}

	public AdminLogin adminlogin(String username, String password) throws SportyShoeBusinessException {

		AdminLogin user = repo.findByUsernameAndPassword(username, password);

		if (username== null || username.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_USERNAME);
		}

		if (password == null || password.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_PASSWORD);
		}

		if ((!user.getUsername().equals(username)) || (!user.getPassword().equals(password))) {
			throw new SportyShoeBusinessException(ErrorConstants.WRONG_CREDENTIALS);
		}

		return user;

	}

	public AdminLogin updatePassword(AdminLogin update) throws SportyShoeBusinessException {

		if (update.getUsername() == null || update.getUsername().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_USERNAME);
		}
		if (update.getPassword() == null || update.getPassword().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_NEW_PASSWORD);
		}

		if (update.getPassword() == null || update.getPassword().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_CONFIRM_PASSWORD);
		}

		if(!update.getPassword().equals(update.getConfirmpassword())) {
			throw new SportyShoeBusinessException(ErrorConstants.MISMATCH);		
		}

		return repo.save(update);

	}

}