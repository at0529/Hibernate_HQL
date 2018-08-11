package maven_new4.Hibernate_Hql;

import java.util.List;

import org.hibernate.transform.ResultTransformer;

import com.abc.bean.ReportBean;


public class ReportResultTransformer implements ResultTransformer{

	private static final long serialVersionUID = 1L;

	public Object transformTuple(Object[] paramArrayOfObject, String[] paramArrayOfString) {
		ReportBean rptBean = new ReportBean();
		
		rptBean.setCust_id((Integer)paramArrayOfObject[0]);
		rptBean.setName((String)paramArrayOfObject[1]);
		rptBean.setTotalOrderPrice((Double)paramArrayOfObject[2]);
		
		return rptBean;
	}

	public List transformList(List paramList) {
		return paramList;
	}
}
