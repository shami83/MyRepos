package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import util.GameProperties;

import bean.PlayerBean;
import bean.TeamBean;
import bean.UKPLBean;

public class TeamDao extends JDBCDao{
	public TeamDao()throws Exception
	{
		super();
	}
	
	public List findAllTeam() throws Exception
	{
		List list =null;
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)processRow(result);
		closeAll();
		return list;
	}
	
	public TeamBean findByID(Integer id) throws Exception
	{
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		TeamBean bean =(TeamBean)processSingleRow(result);
		closeAll();
		return bean;
	}


	@Override
	public List processRow(ResultSet set) throws Exception {
		List list = new ArrayList();
		TeamBean bean  = null;
		while(set.next())
		{
		
			 bean = new  TeamBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setOwner(set.getString(3));
			 bean.setAddress(set.getString(4));
			 bean.setPhone(set.getString(5));
			 bean.setTable(getTable());
			 System.out.println(bean);
			 list.add(bean);
		}
		return list;
	}
	
	public void updateTeam(Integer id,String name,String owner,String address,String phone) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(UPDATE);
		query.append(getTable()+" ");
		query.append("set");
		query.append(" name = ");
		query.append("'");
		query.append(name);
		query.append("'");
		query.append(",");
		
		query.append(" owner = ");
		query.append("'");
		query.append(owner);
		query.append("'");
		query.append(",");
		
		query.append(" adress = ");
		query.append("'");
		query.append(address);
		query.append("'");
		query.append(",");
		
		query.append(" phone = ");
		query.append("'");
		query.append(phone);
		query.append("'");
		
		
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}
	public void deleteTeam(Integer id) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(DELETE);
		query.append(getTable());
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}

	@Override
	public UKPLBean processSingleRow(ResultSet set) throws Exception {
		TeamBean bean  = null;
		while(set.next())
		{
			 bean = new  TeamBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setOwner(set.getString(3));
			 bean.setAddress(set.getString(4));
			 bean.setPhone(set.getString(5));
			 bean.setTable(getTable());
		}
		return bean;
	}
	
	public String getTable()
	{
		String mode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
		String table="u_team";
		if(!mode.equalsIgnoreCase("cricket"))
		{
			table = table+"_"+mode;
		}
		return table;
	}

}
