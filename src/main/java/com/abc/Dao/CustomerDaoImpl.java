package com.abc.Dao;


import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;

import com.abc.bean.ReportBean;
import com.abc.hibernateUtil.HibernateUtil;
import com.abc.pojo.Customer;

import maven_new4.Hibernate_Hql.ReportResultTransformer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getCustomer(int id) {
		Session s= null;
		try {
			s=HibernateUtil.openSession();
			Customer c= (Customer) s.get(Customer.class, id);
			return c;
		}finally {
			s.close();
		}
	}
	
	@Override
	public Customer createCustomer(Customer c) {
		Session s= null;
		Transaction t= null;
		try {
			s= HibernateUtil.openSession();
			t=s.beginTransaction();
			s.save(c);
			t.commit();
			return c;
			
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		finally {
			s.close();
		}
		return  null;
		
	}
	
	@Override
	public Customer updateCustomer(Customer c) {
		Session s= null;
		Transaction t= null;
		try {
			s= HibernateUtil.openSession();
			t=s.beginTransaction();
			s.update(c);
			t.commit();
			return c;
		} catch(Exception e ) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return null;
	}
	
	@Override
	public boolean deleteCustomer(int id) {
		Session s= null;
		Transaction t= null;
		try {
			s=HibernateUtil.openSession();
			t=s.beginTransaction();
			Customer c= (Customer) s.get(Customer.class, id);
			if(c.getCust_id() == id) {
				s.delete(c);
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return false;
	}
	
	@Override
	public List<Customer> getCustomers(String zipCode) {
		List<Customer> list= null;
		Session s= null;
		try {
			s=HibernateUtil.openSession();
			Query query= s.createQuery("from Customer where zipCode= :zipcode");
			query.setParameter("zipcode", zipCode);
			list = query.list();
			return list;
			
		}finally {
			s.close();
		}
	}

	@Override
	public Map<String, Double> getMonthlySales(int year, int id) {
		Map<String, Double> map= new HashMap<>();
		Session s= null; 
		try {
			s=HibernateUtil.openSession();
			
			Query query=s.createQuery("select month(o.orderDate), sum(o.totalOrderPrice) from Customer as cus inner join cus.orders as o "
					+ "where cus.cust_id= :id and year(o.orderDate)=:year group by month(o.orderDate) ");
			query.setParameter("id", id);
			query.setParameter("year", year);
			
			List<Object[]> list= query.list();
			
			for(Object[] object: list) {
				String value1= Month.of((int) object[0]).name();
				Double value2 = (Double) object[1];
				map.put(value1, value2);
			}
			return map;
		} finally {
			s.close();
		}

	}
	
	@Override
	public List<ReportBean> getReport(int month) {
		List<ReportBean> list= null; 
		Session s= null;
		try {
			s= HibernateUtil.openSession();
			Query query= s.createQuery("select c.cust_id, c.name, o.totalOrderPrice from Customer as c inner join c.orders as o "
					+ "where month(o.orderDate)= :month order by o.totalOrderPrice");
			query.setParameter("month", month);
			ResultTransformer transformer= new ReportResultTransformer();
			query.setResultTransformer(transformer);
			list=query.list();
			return list;
		} finally {
			s.close();
		}
	}
	

}
