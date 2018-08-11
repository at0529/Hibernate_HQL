package com.abc.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abc.hibernateUtil.HibernateUtil;
import com.abc.pojo.OrderItem;
import com.abc.pojo.OrderItemId;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public OrderItem getOrderItem(OrderItemId id) {
		Session s= null;
		try {
			s= HibernateUtil.openSession();
			OrderItem ord= (OrderItem) s.get(OrderItem.class, id);
			return ord;
			
		} finally {
			s.close();
		}
	}
	
	@Override
	public OrderItem updateOrderItem(OrderItem ord) {
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.update(ord);
			transaction.commit();
			return ord;
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}
	
	@Override
	public OrderItem createOrderItem(OrderItem ord) {
		Session s= null;
		Transaction transaction = null;
		try {
			s= HibernateUtil.openSession();
			transaction = s.beginTransaction();
			s.save(ord);
			transaction.commit();
			return ord;
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			s.close();
		}
		return null;
	}
	
	@Override
	public boolean deleteOrderItem(OrderItemId id) {
		Session s= null;
		Transaction t= null;
		
		try {
			s= HibernateUtil.openSession();
			t= s.beginTransaction();
			OrderItem c = (OrderItem) s.get(OrderItem.class, id);
			if(c!= null) {
				s.delete(c);
				t.commit();
				return true;
			}
		} catch (Exception e) {
			System.out.println("Hello this not done");
			t.rollback();
		}
		finally {
			s.close();
		}
		return false;
	}
}
