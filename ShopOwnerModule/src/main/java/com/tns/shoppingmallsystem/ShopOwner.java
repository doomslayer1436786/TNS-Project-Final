package com.tns.shoppingmallsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShopOwner {
	@Id
	private int id;
	private String name;
	private String dob;
	private int shop_id;
	
	public ShopOwner(int id, String name, String dob, int shop_id) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.shop_id = shop_id;
	}
	public ShopOwner() {
		super();
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	@Override
	public String toString() {
		return "ShopOwner [id=" + id + ", name=" + name + ", dob=" + dob + ", shop_id=" + shop_id + "]";
	}
}
