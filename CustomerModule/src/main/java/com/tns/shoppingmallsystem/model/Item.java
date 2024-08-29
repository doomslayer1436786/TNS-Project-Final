package com.tns.shoppingmallsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Item {
	@Id
	 private long id;
	    private String name;
	    private double price;
	    
		public Item() {
			super();
		}
		public Item(long id, String name, double price) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Mall [id=" + id + ", name=" + name + ", price=" + price + "]";
		}
}
