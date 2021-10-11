package com.shoes.SportyShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.AdminLogin;
import com.shoes.SportyShoes.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;


	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("admin", new AdminLogin());
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("admin") AdminLogin admin) throws SportyShoeBusinessException, NullPointerException {

		ModelAndView mav = new ModelAndView();

		try{
			@SuppressWarnings("unused")
			AdminLogin oauthUser = adminService.adminlogin(admin.getUsername(), admin.getPassword());
						
			mav = new ModelAndView("welcome");
			mav.addObject("username", admin.getUsername());
		} catch(SportyShoeBusinessException | NullPointerException ex) {

			mav = new ModelAndView("login");
			mav.addObject("admin", new AdminLogin());

			mav.addObject("exception", ex.getMessage());

		}
		return mav;
	}       


	@GetMapping(value = {"/logout"})
	public ModelAndView logoutDo()
	{
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("admin", new AdminLogin());
		return mav;

	}

	@GetMapping(value = "/forgotpassword")
	public ModelAndView forgotpassword() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newcredentials", new AdminLogin());
		mav.setViewName("forgotpassword");

		return mav;
	}

	@GetMapping(value = "/resetpassword")
	public ModelAndView forgotpassword(@ModelAttribute AdminLogin update) throws SportyShoeBusinessException, NullPointerException {
		ModelAndView mav= new ModelAndView();
		
		try{ @SuppressWarnings("unused")
		AdminLogin n = adminService.updatePassword(update);
		
			mav = new ModelAndView("login");
			mav.addObject("admin", new AdminLogin());

		}catch(SportyShoeBusinessException | NullPointerException ex) {
			
			mav.addObject("newcredentials", new AdminLogin());
			mav.addObject("exception", ex.getMessage());
			mav.setViewName("forgotpassword");

		}
		return mav;
	}


}


