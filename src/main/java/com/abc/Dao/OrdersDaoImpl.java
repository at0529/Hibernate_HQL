package com.abc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.hibernateUtil.HibernateUtil;
import com.abc.pojo.Orders;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public Orders getOrders(int id) {
		Session s= HibernateUtil.openSession();
		try {
		Query query = s.createQuery("from Orders as o where o.id= :id");
		query.setParameter("id", id);
		Orders o= (Orders) query.uniqueResult();
		return o;
		} finally {
			s.close();
		}
		
	}
	
	@Override
	public Orders createOrders(Orders o) {
		Session s= null;
		Transaction t= null;
		try {
			s= HibernateUtil.openSession();
			t=s.beginTransaction();
			s.save(o);
			t.commit();
			return o;
		}
		catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		 finally {
			 s.close();
		 }
		return null;
	}
	
	@Override
	public Orders updateOrders(Orders o) {
		Session s= null;
		Transaction t= null;
		try {
			s= HibernateUtil.openSession();
			t=s.beginTransaction();
			Query query= s.createQuery("update Orders set no_of_items=:no_of_items where id=:id");
			query.setParameter("no_of_items", o.getNo_of_items());
			query.setParameter("id", o.getOrder_id());
			query.executeUpdate();
			t.commit();
			return o;
		}
		catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		}
		 finally {
			 s.close();
		 }
		return null;
	}
	
	@Override
	public boolean deleteOrders(int id) {
		Session s= null;
		Transaction t= null;
		try {
			s= HibernateUtil.openSession();
			t=s.beginTransaction();
			Query query= s.createQuery("delete from Orders where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			t.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		return false;
	}
	
	@Override
	public List<Orders> getOrders1(Double totalOrderPrice) {
		
		Session s= null;
		List<Orders> list= null;
		try {
			s=HibernateUtil.openSession();
			Query query= s.createQuery("from Orders as o where o.totalOrderPrice>:totalOrderPrice");
			query.setParameter("totalOrderPrice", totalOrderPrice);
			list=query.list();
			return list;
		} finally {
			s.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
