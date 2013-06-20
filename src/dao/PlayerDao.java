package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import util.GameProperties;



import bean.AdminBean;
import bean.PlayerBean;
import bean.TeamBean;
import bean.UKPLBean;

public class PlayerDao extends JDBCDao{
	
	public PlayerDao()throws Exception
	{
		super();
	}
	public void updateTeam(Integer id,String team) throws Exception
	{
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(UPDATE);
		query.append(getTable()+" ");
		query.append("set");
		query.append(" team = ");
		query.append(team);
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		closeAll();
		
	}
	public void updatePlayer(Integer id,String name,String grade,String category,String img) throws Exception
	{
		con=open();
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
		
		query.append(" grade = ");
		query.append("'");
		query.append(grade);
		query.append("'");
		query.append(",");
		
		query.append(" category = ");
		query.append("'");
		query.append(category);
		query.append("'");
		query.append(",");
		
		query.append(" image = ");
		query.append("'");
		query.append(img);
		query.append("'");
		
		
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		closeAll();
		
	}
	public void deletePlayer(Integer id) throws Exception
	{
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(DELETE);
		query.append(getTable());
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		closeAll();
		
	}
	
	public PlayerBean findByID(Integer id) throws Exception
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
		PlayerBean bean =(PlayerBean)processSingleRow(result);
		closeAll();
		return bean;
	}
	
	public List findAllPlayer(Map paramMap,String orderColumn) throws Exception
	{
		List list =null;
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		if(paramMap != null && paramMap.size()>0)
		{
			query.append(WHERE);
			for(Iterator it=paramMap.keySet().iterator();it.hasNext();)
			{
				String key = (String)it.next();
				if(key.equalsIgnoreCase("team"))
				{
					query.append(key + " = ");
					query.append(paramMap.get(key));
					
				}
				else
				{
					query.append(key + " LIKE '");
					query.append(paramMap.get(key));
					query.append("%'");
				}
				
				if(it.hasNext())
				{
					query.append(" AND ");
				}
			}
		}
		query.append(ORDER_BY);
		query.append(orderColumn);
		
		
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)processRow(result);
		closeAll();
		return list;
	}

	@Override
	public List processRow(ResultSet set) throws Exception {
		List list = new ArrayList();
		PlayerBean bean  = null;
		while(set.next())
		{
		
			 bean = new  PlayerBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setGrade(set.getString(3));
			 bean.setCategory(set.getString(4));
			 bean.setTeam(set.getInt(5));
			 bean.setImage(set.getString(6));
			 bean.setTable(getTable());
			 setTeamName(bean);
			 System.out.println(bean);
			 
			 list.add(bean);
		}
		return list;
	}

	@Override
	public UKPLBean processSingleRow(ResultSet set) throws Exception {
		PlayerBean bean  = null;
		while(set.next())
		{
			 bean = new  PlayerBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setGrade(set.getString(3));
			 bean.setCategory(set.getString(4));
			 bean.setTeam(set.getInt(5));
			 bean.setImage(set.getString(6));
			 bean.setTable(getTable());
			 setTeamName(bean);
		}
		return bean;
	}
	
	private void setTeamName(PlayerBean bean) throws Exception
	{
		TeamDao dao =new TeamDao();
		if(!(bean.getTeam().intValue() == 0))
		{
			TeamBean tbean = dao.findByID(bean.getTeam());
			bean.setTeamName(tbean.getName());	
		}
		else
		{
			bean.setTeamName("Not Assign");	
		}
		
	}
	
	public String getTable()
	{
		String mode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
		String table="u_player";
		if(!mode.equalsIgnoreCase("cricket"))
		{
			table = table+"_"+mode;
		}
		return table;
	}
	

}
