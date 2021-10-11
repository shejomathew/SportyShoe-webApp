package com.shoes.SportyShoes.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
	
    @Id
	private String username;
	private String password;
	private String newpassword;
	private String confirmpassword;
	
	
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public AdminLogin(String username, String password, String newpassword, String confirmpassword) {
		super();
		this.username = username;
		this.password = password;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}

	@Override
	public String toString() {
		return "AdminLogin [username=" + username + ", password=" + password + ", newpassword=" + newpassword
				+ ", confirmpassword=" + confirmpassword + "]";
	}

	public AdminLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
			

}
