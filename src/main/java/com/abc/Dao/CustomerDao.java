package com.abc.Dao;

import java.util.List;
import java.util.Map;

import com.abc.bean.ReportBean;
import com.abc.pojo.Customer;

public interface CustomerDao {

	Customer getCustomer(int id);
	
	Customer createCustomer(Customer c);
	
	Customer updateCustomer(Customer c);
	
	boolean deleteCustomer(int id);
	
	List<Customer> getCustomers(String zipCode);
	
	Map<String, Double> getMonthlySales(int year, int id);
	
	List<ReportBean> getReport(int month);
	
	
}
