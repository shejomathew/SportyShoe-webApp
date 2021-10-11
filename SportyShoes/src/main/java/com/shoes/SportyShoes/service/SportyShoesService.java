package com.shoes.SportyShoes.service;

import java.text.ParseException;
import java.util.List;

import com.shoes.SportyShoes.exception.SportyShoeBusinessException;
import com.shoes.SportyShoes.model.PurchaseReport;
import com.shoes.SportyShoes.model.Shoe;


public interface SportyShoesService {
	
	public Shoe createShoe(Shoe shoe) throws SportyShoeBusinessException;
	public List<Shoe> getShoeById(Shoe shoe) throws SportyShoeBusinessException;
	public void deleteShoeById(Shoe shoe) throws SportyShoeBusinessException;
	public List<Shoe> getAllShoes() throws SportyShoeBusinessException;
	
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws SportyShoeBusinessException, ParseException;
	public List<PurchaseReport> getPurchaseReportById(PurchaseReport pr) throws SportyShoeBusinessException;
	public void deletePurchaseReportById(PurchaseReport pr) throws SportyShoeBusinessException;
	public List<PurchaseReport> getAllPurchaseReports() throws SportyShoeBusinessException;
	public List<PurchaseReport> getAllPurchaseReportsByCategory(PurchaseReport purchasereport) throws SportyShoeBusinessException;
	public List<PurchaseReport> getAllPurchaseReportsByDOP(PurchaseReport purchasereport) throws SportyShoeBusinessException ;

}
