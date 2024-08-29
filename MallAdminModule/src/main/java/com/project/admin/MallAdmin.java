package com.project.admin;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "malladmin")
public class MallAdmin {
	
	@Id
	private int ad_id;
    private String ad_name;
    private String ad_password;
    
//   // @JdbcTypeCode(SqlTypes.JSON)
//   // @ManyToOne
//    private MallAdmin mall;
    private String ad_phone;
    
    
	public MallAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MallAdmin(int ad_id, String ad_name, String ad_password, String ad_phone) {
		super();
		this.ad_id = ad_id;
		this.ad_name = ad_name;
		this.ad_password = ad_password;
		//this.mall = mall;
		this.ad_phone = ad_phone;
	}

	
	public int getAd_id() {
		return ad_id;
	}

	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}

	public String getAd_name() {
		return ad_name;
	}

	public void setAd_name(String ad_name) {
		this.ad_name = ad_name;
	}

	public String getAd_password() {
		return ad_password;
	}

	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}

//	public MallAdmin getMall() {
//		return mall;
//	}
//
//	public void setMall(MallAdmin mall) {
//		this.mall = mall;
//	}

	public String getAd_phone() {
		return ad_phone;
	}

	public void setAd_phone(String ad_phone) {
		this.ad_phone = ad_phone;
	}

	@Override
	public String toString() {
		return "MallAdmin [ad_id=" + ad_id + ", ad_name=" + ad_name + ", ad_password=" + ad_password 
				+ ", ad_phone=" + ad_phone + "]";
	}
    
	
	
	
    

	
	
    
    

}
