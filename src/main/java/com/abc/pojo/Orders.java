package com.abc.pojo;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue
	private Integer order_id;
	
	private Integer cust_id;
	
	private Double totalOrderPrice;
	
	private Integer no_of_items;
	
	private Date orderDate;
	
	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name="order_id")
	private List<OrderItem> orderItems;
	
	
	
}
