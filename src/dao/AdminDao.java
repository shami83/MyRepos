package dao;

import java.sql.ResultSet;
import java.util.List;

import bean.AdminBean;
import bean.UKPLBean;

public class AdminDao extends JDBCDao{
	
	public AdminDao()throws Exception
	{
		super();
	}
	/* test*/
	public AdminBean findByNameAndPassword(AdminBean bean) throws Exception
	{
		con = open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(bean.getTable());
		query.append(WHERE);
		query.append(" Name = '");
		query.append(bean.getName());
		query.append("'");
		query.append(AND);
		query.append(" PASSWORD = '");
		query.append(bean.getPassword());
		query.append("'");
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		bean =(AdminBean)processSingleRow(result);
		closeAll();
		return bean;
	}
	
	public  UKPLBean processSingleRow(ResultSet  set) throws Exception
	{
		AdminBean bean  = null;
		while(set.next())
		{
			 bean = new  AdminBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setSex(set.getInt(3));
			 bean.setUrl(set.getString(4));
			 bean.setPassword(set.getString(5));
			 bean.setTable("u_admin");
		}
		return bean;
	}
	
	public  List processRow(ResultSet  set)throws Exception
	{
		return null;
	}

}
