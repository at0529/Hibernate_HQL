package com.abc.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReportBean implements Serializable {

	private Integer cust_id;
	
	private String name;
	
	private Double totalOrderPrice;
	
	
}
