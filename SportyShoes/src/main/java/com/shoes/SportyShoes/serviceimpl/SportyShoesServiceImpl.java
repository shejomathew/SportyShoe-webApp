package com.shoes.SportyShoes.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.shoes.SportyShoes.exception.ErrorConstants;
import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.PurchaseReport;
import com.shoes.SportyShoes.model.Shoe;
import com.shoes.SportyShoes.repository.PurchaseReportRepository;
import com.shoes.SportyShoes.repository.ShoesRepository;
import com.shoes.SportyShoes.service.SportyShoesService;

@Service
public class SportyShoesServiceImpl implements SportyShoesService{

	@Autowired
	private ShoesRepository shoesRepo;

	@Autowired
	private PurchaseReportRepository prRepo;

	public SportyShoesServiceImpl() {
		super();
	}

	@PostConstruct
	public void init() {
		Shoe s1 = new Shoe(1,"Adidas","Basketball",2000.24);
		Shoe s2 = new Shoe(2,"Nike","Cricket",1100.18);
		Shoe s3 = new Shoe(3,"Puma","Running",1000.50);
		Shoe s4 = new Shoe(4,"Woodland","Football",3000.00);

		shoesRepo.save(s1);
		shoesRepo.save(s2);
		shoesRepo.save(s3);
		shoesRepo.save(s4);

		PurchaseReport pr1 = new PurchaseReport(5,"Customer_1","Running","01-02-2021","adidas_runner:5,nike_airmax:10");
		PurchaseReport pr2 = new PurchaseReport(6,"Customer_2","Cricket","01-04-2021","nike_cricket:5,nike_cricket:10");
		PurchaseReport pr3 = new PurchaseReport(7,"Customer_3","Basketball","01-08-2021","puma_basketball:5,puma_basketball:10");
		PurchaseReport pr4 = new PurchaseReport(8,"Customer_4","Football","01-07-2021","woodland_football:5,woodland_football:10");

		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
	}

	public Shoe createShoe(Shoe shoe) throws SportyShoeBusinessException {

		if (shoe.getId() == 0) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_SHOEID);
		}
		if (shoe.getName()== null || shoe.getName().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_SHOENAME);
		}
		if (shoe.getCategory()==null || shoe.getCategory().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_SHOE_CATEGORY);
		}
		if (shoe.getPrice() == 0.0) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_PRICE);
		}

		Integer id = shoe.getId();
		Shoe oldShoe = null;
		try{
			oldShoe = shoesRepo.findById(id).get();
			if(shoe.getId() == oldShoe.getId()) {
				throw new SportyShoeBusinessException(ErrorConstants.DUPLICATE_SHOEID);
			}
		}catch(NoSuchElementException | NullPointerException ex) {
		}
		return shoesRepo.save(shoe);

	}

	///....Finding Shoe

	public List<Shoe> getShoeById(Shoe shoe) throws SportyShoeBusinessException {

		List<Shoe> shoelist = new ArrayList<>();
		if(shoe.getId()<=0 ) {
			throw new SportyShoeBusinessException(ErrorConstants.INVALID_SHOEID);
		}
		try {
			shoe = shoesRepo.findById(shoe.getId()).get();

		}catch(NoSuchElementException e) {
			throw new SportyShoeBusinessException(ErrorConstants.SHOEID_DONOT_EXIST);
		}
		shoelist.add(shoe);
		return shoelist;
	}

	//.... Delete Shoe

	public void deleteShoeById(Shoe shoe) throws SportyShoeBusinessException {

		if(shoe.getId()<=0) {
			throw new SportyShoeBusinessException(ErrorConstants.INVALID_SHOEID);
		}
		try {
			shoesRepo.deleteById(shoe.getId());
		}catch(EmptyResultDataAccessException e) {
			throw new SportyShoeBusinessException(ErrorConstants.SHOEID_DONOT_EXIST);
		}
	}

	public List<Shoe> getAllShoes() throws SportyShoeBusinessException {

		List<Shoe> listofshoe = shoesRepo.findAll();
		if(listofshoe.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_SHOELIST);
		}
		return listofshoe;
	}

	////////////...///....... All about Purchase Report

	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws SportyShoeBusinessException, ParseException {

		if (pr.getId() <= 0 ) {
			throw new SportyShoeBusinessException(ErrorConstants.INVALID_PR_ID);
		}
		if (pr.getPurchasedBy() == null || pr.getPurchasedBy().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.PR_PURCHASEDBY);
		}
		if (pr.getCategory()==null || pr.getCategory().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.PR_CATEGORY);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if (pr.getDop()== null|| pr.getDop().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.DATE_INVALID);
		}
		try{
			if (sdf.parse(pr.getDop()).after(new Date())) {
				throw new SportyShoeBusinessException(ErrorConstants.DATE_INVALID);}
		}catch(ParseException ex) {
		}
		if (pr.getOrderList()==null || pr.getOrderList().isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.PR_ORDERLIST);
		}

		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
			if(oldPr.getId()==pr.getId()) {
				throw new SportyShoeBusinessException(ErrorConstants.PR_DUPLICATE_ID);
			}
		}catch(NoSuchElementException | NullPointerException e) {
		}

		return prRepo.save(pr);	
	}

	//... Finding report BY id 

	public List<PurchaseReport> getPurchaseReportById(PurchaseReport pr) throws SportyShoeBusinessException {

		List<PurchaseReport> reportlist =  new ArrayList<>();
		if(pr.getId()<=0) {
			throw new SportyShoeBusinessException(ErrorConstants.INVALID_PR_ID);
		}
		try {
			pr = prRepo.findById(pr.getId()).get();
		}catch(NoSuchElementException e) {
			throw new SportyShoeBusinessException(ErrorConstants.PR_DONOT_EXIST);
		}
		reportlist.add(pr);
		return reportlist;
	}

	////....Delete report by id

	public void deletePurchaseReportById(PurchaseReport pr) throws SportyShoeBusinessException {

		if(pr.getId()<=0) {
			throw new SportyShoeBusinessException(ErrorConstants.INVALID_PR_ID);
		}
		try {
			prRepo.deleteById(pr.getId());

		}catch(EmptyResultDataAccessException e) {
			throw new SportyShoeBusinessException(ErrorConstants.PR_DONOT_EXIST);
		}
	}

	//...Get all report

	public List<PurchaseReport> getAllPurchaseReports() throws SportyShoeBusinessException {
		List<PurchaseReport> listofpr = prRepo.findAll();
		if(listofpr.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_PR_LIST);
		}
		return listofpr;
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(PurchaseReport purchasereport) throws SportyShoeBusinessException {

		List<PurchaseReport> listofpr = prRepo.findByCategory(purchasereport.getCategory());
		if(listofpr.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_PR_CAT);
		}
		return listofpr;
	}

	public List<PurchaseReport> getAllPurchaseReportsByDOP(PurchaseReport purchasereport) throws SportyShoeBusinessException  {

		List<PurchaseReport> listofpr = prRepo.findByDop(purchasereport.getDop());
		if(listofpr.isEmpty()) {
			throw new SportyShoeBusinessException(ErrorConstants.EMPTY_PR_DOP);
		}
		return listofpr;
	}

}
