package com.abc.pojo;

import javax.persistence.Embeddable;

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
@Embeddable
public class Address {

	private String streetName;
	
	private String city;
	
	private String state;
	
	private String zipCode;
	
	
}
