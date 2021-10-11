package com.shoes.SportyShoes.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class PurchaseReport {



	public PurchaseReport(int id, String purchasedBy, String category, String dop, String orderList) {
		super();
		this.id = id;
		this.purchasedBy = purchasedBy;
		this.category = category;
		this.dop = dop;
		this.orderList = orderList;
	}

	@Id
	@GeneratedValue
	private int id;
	private String purchasedBy; // This can be extended to utilize one to one relation with User Table [Future Implemetations]
	private String category;

//	@Temporal(TemporalType.String)
	private String dop;

	String orderList;

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPurchasedBy() {
		return purchasedBy;
	}



	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDop() {
		return dop;
	}



	public void setDop(String dop) {
		this.dop = dop;
	}



	public String getOrderList() {
		return orderList;
	}



	public void setOrderList(String orderList) {
		this.orderList = orderList;
	}


	@Override
	public String toString() {
		return "PurchaseReport [id=" + id + ", purchasedBy=" + purchasedBy + ", category=" + category + ", dop=" + dop
				+ ", orderList=" + orderList + "]";
	}


	public PurchaseReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This can be used for storing orderlist as <Qty, Shoe>
	 * Here implementation is made simple by using shoeId instead
	 * of shoe in string format.
	 */
	//	@ManyToMany(cascade = CascadeType.ALL)
	//	Map<Integer,Shoe> orderList = new HashMap<Integer,Shoe>();
	//								OR
	//	Map<Integer,Integer> orderList = new HashMap<Integer,Integer>();


}
