package com.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="brands")
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandId")
	private int brandId ; 
	@Column(name="brandName")
	private String brandName;
	
	@OneToMany(mappedBy = "brandId",cascade = CascadeType.ALL)
	//@ManyToOne(cascade = CascadeType.ALL)
	private List<Cars> cars;
	
	public Brands() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brands(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
