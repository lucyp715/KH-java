package model.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class Order implements Serializable  {

	private static final long serialVersionUID = 5L;
	private String userId;
	private Date orderDay;
	private String product;
	private String quantity;
	private String totalPrice;
	private String address;
	private int kcal; 
	
	
	
	public Order(String userId, Date date, String product, String quantity, String totalPrice, String address,int kcal) {
		super();
		this.userId = userId;
		this.orderDay = date;
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.address = address;
		this.kcal=kcal;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public Date getOrderDay() {
		return orderDay;
	}



	public void setOrderDay(Date orderDay) {
		this.orderDay = orderDay;
	}



	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}



	public String getQuantity() {
		return quantity;
	}



	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}



	public String getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getKcal() {
		return kcal;
	}



	public void setKcal(int kcal) {
		this.kcal = kcal;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Order [userId=" + userId + ", orderDay=" + orderDay + ", product=" + product + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", address=" + address + ", kcal=" + kcal + "]";
	}

	
	

}
