package com.abc.pojo;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue
	private Integer cust_id;
	
	private String name;
	
	private Date dob;
	
	@Embedded
	private Address address;
	
	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name="cust_id")
	private List<Orders> orders;
	
	
}
