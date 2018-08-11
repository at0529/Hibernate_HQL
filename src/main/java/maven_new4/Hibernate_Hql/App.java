package maven_new4.Hibernate_Hql;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import com.abc.Dao.CustomerDaoImpl;
import com.abc.Dao.OrderItemDaoImpl;
import com.abc.Dao.OrdersDaoImpl;
import com.abc.bean.ReportBean;
import com.abc.pojo.Address;
import com.abc.pojo.Customer;
import com.abc.pojo.OrderItem;
import com.abc.pojo.OrderItemId;
import com.abc.pojo.Orders;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		CustomerDaoImpl cd= new CustomerDaoImpl();
    		
    		Address address= new Address("2527 Lousie Street", "Denton", "Tx", "76201");
        Customer c= new Customer(null, "Akhil" , Date.valueOf(LocalDate.of(1995, 5, 29)), address, null);
        
        Address address2= new Address("2126 Stella Street", "Denton", "Tx", "76201");
        Customer c2= new Customer(null, "Krishna", Date.valueOf(LocalDate.of(1995, 8, 29)), address2, null);
        
        cd.createCustomer(c);
        cd.createCustomer(c2);
        
        Orders o= new Orders(null, 1, 7232.0, 5, Date.valueOf(LocalDate.of(2018, Month.JANUARY, 10)), null);
        Orders o1= new Orders(null, 1, 8247.0, 5, Date.valueOf(LocalDate.of(2018, Month.JANUARY, 10)), null);
        Orders o2= new Orders(null, 1, 3824.0, 5, Date.valueOf(LocalDate.of(2018, Month.FEBRUARY, 10)), null);
        OrdersDaoImpl od= new OrdersDaoImpl();
        od.createOrders(o);
        od.createOrders(o2);
        od.createOrders(o1);
        
        
        OrderItemId oid= new OrderItemId(1, 2);
        OrderItem oi= new OrderItem(oid, 3);
        OrderItemDaoImpl oidl= new OrderItemDaoImpl();
        oidl.createOrderItem(oi);
        
        List<Customer> list=cd.getCustomers("76201");
        
        for(Customer cus: list) {
        		System.out.println(cus);
        }
        
        Map<String, Double> map= cd.getMonthlySales(2018, 1);
        
        for(Map.Entry m:map.entrySet()){  
        	   System.out.println(m.getKey()+" "+m.getValue());  
        	  }  
        
        List<ReportBean> list1= cd.getReport(1);
        
        list1.forEach(System.out::println);
        
        System.out.println("-----------------------------------");
        
        o2.setNo_of_items(10);
        Orders ord=od.updateOrders(o2);
        System.out.println(ord);
        System.out.println("-----------------------------------");
        Orders ord1=od.getOrders(2);
        System.out.println(ord1);
        
        
        System.out.println("-----------------------------------");
        
        List<Orders> listOrd=od.getOrders1(200.0);
        listOrd.forEach(System.out::println);
        
        
        
        
    }
}
