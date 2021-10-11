package com.shoes.SportyShoes.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.Shoe;
import com.shoes.SportyShoes.service.SportyShoesService;

@Controller
public class ShoeController {

	@Autowired
	public SportyShoesService sportyShoesService;

	//1...Adding Shoe

	@GetMapping(value = "/addnewshoe")
	public ModelAndView addshoe() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newshoe", new Shoe());
		mav.setViewName("addshoe");
		return mav;
	}

	@SuppressWarnings("unused")
	@PostMapping(value = "/newShoeinfo")
	public ModelAndView addshoe(@ModelAttribute Shoe shoe) throws SportyShoeBusinessException, 
	NullPointerException, NoSuchElementException{

		ModelAndView mav = new ModelAndView();

		try {
			Shoe newshoe = sportyShoesService.createShoe(shoe);
			mav.addObject("message", "Successfully Added the Product!!");	
			mav.setViewName("welcome");
			
		}catch(SportyShoeBusinessException | NullPointerException ex) {
			mav.addObject("newshoe", new Shoe());
			mav.addObject("exception", ex.getMessage());
			mav.setViewName("addshoe");
		}
		return mav;
	}

	//2....DeleteShoe

	@GetMapping(value = "/delete")
	public ModelAndView deleteshoe() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("removeshoe", new Shoe());
		mav.setViewName("deleteshoe");
		return mav;
	}

	@SuppressWarnings("unused")
	@PostMapping(value = "/deleteshoeinfo")
	public ModelAndView deletingshoe(@ModelAttribute Shoe shoe) throws SportyShoeBusinessException{
		ModelAndView mav = new ModelAndView();

		try {
			sportyShoesService.deleteShoeById(shoe);
			mav.addObject("message", "Successfully deleted the Product!!");
			mav.setViewName("welcome");
			
		}catch(SportyShoeBusinessException ex) {
			mav.addObject("removeshoe", new Shoe());
			mav.addObject("exception", ex.getMessage());
			mav.setViewName("deleteshoe");
		}
		return mav;
	}

	//3.... FindByid

	@GetMapping(value = "/findshoe")
	public ModelAndView findshoebyid() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("availableshoe", new Shoe());
		mav.setViewName("find");
		return mav;
	}

	@PostMapping(value = "/searchProcess")
	public ModelAndView findshoebyid(@ModelAttribute Shoe shoe) throws SportyShoeBusinessException {
		ModelAndView model= new ModelAndView();

		try{ 
			List<Shoe> availableshoelist = sportyShoesService.getShoeById(shoe); 
			model.addObject("shoelist", availableshoelist);
			model.setViewName("findresult");
			
		}catch(SportyShoeBusinessException ex){
			model.addObject("availableshoe", new Shoe());
			model.addObject("exception", ex.getMessage());
			model.setViewName("find");	
		}
		return model;
	}

	@GetMapping(value = "/allShoe")
	public ModelAndView findallshoe() throws SportyShoeBusinessException {
		ModelAndView mav= new ModelAndView();

		try {
			List<Shoe> availableshoelist = sportyShoesService.getAllShoes();
			mav.addObject("shoelist", availableshoelist);
			
			mav.setViewName("findresult");
		}catch(SportyShoeBusinessException | NullPointerException ex) {
			mav.addObject("availableshoe", new Shoe());
			mav.addObject("exception", ex.getMessage());
			mav.setViewName("find");
		}
		return mav;
	}

}
