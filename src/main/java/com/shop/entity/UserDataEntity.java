package com.shop.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class UserDataEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String cashMemoNo;
	
	private String houseNo;
	
	private String ebNo;
	
	private String cardHolderName;
	
	private Integer aadharNo;
	
	private String wheat;
	
	private String rice;
	
	private String kerosene;
	
	private BigDecimal price;
	
	private String billMonth;
	
	@CreationTimestamp
	@JsonIgnore
	private Date createdOn;
	
	@UpdateTimestamp
	@JsonIgnore
	private Date updatedOn;

}
