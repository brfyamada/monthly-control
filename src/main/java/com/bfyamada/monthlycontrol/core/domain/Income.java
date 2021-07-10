package com.bfyamada.monthlycontrol.core.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Income_TB")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Income {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;
	
	@NotEmpty(message = "name of income is mantatory")
	@Column(nullable = false)
	private String name;
	
	@Column(nullable =true)
	private String description;
	
	@NotNull(message = "value of income is mantatory")
	@Column(nullable = false)
	private BigDecimal value;
	
	@Column(nullable = false)
	private boolean isReceived;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "spreadSheetId")
	private SpreadSheet spreadSheetId;
	
	
}
