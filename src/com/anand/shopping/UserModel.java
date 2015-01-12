package com.anand.shopping;

public class UserModel {
	int id;
	String name="";
	int qty;
	int price;
	public UserModel(int id, String name,int qty,int price){
		this.id=id;
		this.name=name;
		this.qty=qty;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

//	public String getEmail() {
//		return email;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
}