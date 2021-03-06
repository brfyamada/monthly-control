package com.bfyamada.monthlyexpensescontrol.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;


import lombok.Data;

public class IncomeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private int line;
	private BigDecimal value;
	private boolean isReceived;
	private int year;
	private int month;
	
	
	public IncomeDTO() {
		
	}
	
	public IncomeDTO(Integer id, int line, String name, BigDecimal value, boolean isReceived, int year,
			int month) {
		super();
		this.id = id;
		this.line = line;
		this.name = name;
		this.value = value;
		this.isReceived = isReceived;
		this.year = year;
		this.month = month;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}

}
