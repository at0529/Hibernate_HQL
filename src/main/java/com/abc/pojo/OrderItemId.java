package com.abc.pojo;

import java.io.Serializable;

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
public class OrderItemId implements Serializable {

	private Integer order_id;
	
	private Integer item_id;
	
	
}
