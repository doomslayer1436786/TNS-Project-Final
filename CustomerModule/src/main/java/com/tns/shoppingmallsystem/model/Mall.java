package com.tns.shoppingmallsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mall {
	@Id
    private long id;
    private String name;
    private String location;
	public Mall(long id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public Mall() {
		super();
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Mall [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
    
}
