package com.shoes.SportyShoes.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.PurchaseReport;
import com.shoes.SportyShoes.model.Shoe;
import com.shoes.SportyShoes.service.SportyShoesService;

@Controller
public class PurchaseReportController {

	@Autowired
	public SportyShoesService sportyShoeService;

	//1...Adding purchase report

	@GetMapping(value = "/addpurchase")
	public ModelAndView addpurchasereport() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("newpurchasereport", new PurchaseReport());
		mav.setViewName("addpurchasereport");
		return mav;
	}


	@SuppressWarnings("unused")
	@PostMapping(value = "/newpurchasereportinfo")
	public ModelAndView createpurchasereport(@ModelAttribute PurchaseReport purchasereport) throws SportyShoeBusinessException, ParseException{
		ModelAndView mav = new ModelAndView();

		try {
			PurchaseReport newpurchasereport = sportyShoeService.createPurchaseReport(purchasereport);
			mav.addObject("message", "Successfully Added the Product!!");	
			mav.setViewName("welcome");
		}catch(SportyShoeBusinessException | ParserException ex) {
			mav.addObject("newpurchasereport", new PurchaseReport());
			mav.addObject("exception", ex.getMessage());	
			mav.setViewName("addpurchasereport");		
		}
		return mav;
	}

	//2....Deletepurchasereport

	@GetMapping(value = "/deletepurchase")
	public ModelAndView deletepurchasereport() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("removepurchasereport", new PurchaseReport());
		mav.setViewName("deletepurchasereport");
		return mav;
	}

	@SuppressWarnings("unused")
	@PostMapping(value = "/deletepurchasereportinfo")
	public ModelAndView deletingpurchasereport(@ModelAttribute PurchaseReport purchasereport) throws SportyShoeBusinessException{
		ModelAndView mav = new ModelAndView();
		
		try {
			sportyShoeService.deletePurchaseReportById(purchasereport);
			mav.addObject("message", "Successfully deleted the Product!!");
			mav.setViewName("welcome");
			
		}catch(SportyShoeBusinessException ex) {
			mav.addObject("removepurchasereport", new PurchaseReport());
			mav.addObject("exception", ex.getMessage());
			mav.setViewName("deletepurchasereport");
		}
		return mav;
	}

	//3.... FindPurchaseReportByid

	@GetMapping(value = "/getreport")
	public ModelAndView findpurchasereportbyid() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("getreport", new PurchaseReport());
		mav.setViewName("getpurchasereport");
		return mav;
	}

	@PostMapping(value = "/findreportprocess")
	public ModelAndView findpurchasereport(@ModelAttribute PurchaseReport purchasereport) throws SportyShoeBusinessException {

		ModelAndView model= new ModelAndView();
		List<PurchaseReport> availablepurchasereportlist = new ArrayList<PurchaseReport>();
		try {
			if(purchasereport.getId()!=0) {
				availablepurchasereportlist = sportyShoeService.getPurchaseReportById(purchasereport);
				model.addObject("purchasereportlist", availablepurchasereportlist);
				model.setViewName("reportresult");

			}else if(!purchasereport.getCategory().isEmpty()){
				availablepurchasereportlist = sportyShoeService.getAllPurchaseReportsByCategory(purchasereport);
				model.addObject("purchasereportlist", availablepurchasereportlist);
				model.setViewName("reportresult");

			}else if(!purchasereport.getDop().isEmpty()){
				availablepurchasereportlist = sportyShoeService.getAllPurchaseReportsByDOP(purchasereport); 
				model.addObject("purchasereportlist", availablepurchasereportlist);
				model.setViewName("reportresult");

			}else {
				model.addObject("getreport", new PurchaseReport());
				model.addObject("exception", "Please Choose an option ");
				model.setViewName("getpurchasereport");	
			}
		}catch(SportyShoeBusinessException ex){
			model.addObject("getreport", new PurchaseReport());
			model.addObject("exception", ex.getMessage());
			model.setViewName("getpurchasereport");	
		}
		return model;
	}

	//4...Search all reports

	@GetMapping(value = "/allreport")
	public ModelAndView findallreport() throws SportyShoeBusinessException {

		ModelAndView model= new ModelAndView();
		try {
			List<PurchaseReport> availablepurchasereportlist = sportyShoeService.getAllPurchaseReports();	
			model.addObject("purchasereportlist", availablepurchasereportlist);
			model.setViewName("reportresult");
			
		}catch(SportyShoeBusinessException | NullPointerException ex) {
			model.addObject("getreport", new Shoe());
			model.addObject("exception", ex.getMessage());
			model.setViewName("getpurchasereport");	
		}
		return model;
	}
}
