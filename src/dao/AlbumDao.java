package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.AlbumBean;
import bean.PlayerBean;
import bean.UKPLBean;

public class AlbumDao extends JDBCDao{
	
	public AlbumDao()throws Exception
	{
		super();
	}
	public AlbumBean findByID(Integer id) throws Exception
	{
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append("u_album");
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		AlbumBean bean =(AlbumBean)processSingleRow(result);
		closeAll();
		return bean;
	}

	@Override
	public List processRow(ResultSet set) throws Exception {
		List list = new ArrayList();
		AlbumBean bean  = null;
		while(set.next())
		{
		
			 bean = new  AlbumBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setDescription(set.getString(3));
			 bean.setTable("u_album");
			 System.out.println(bean);
			 list.add(bean);
		}
		return list;
	}
	@Override
	public UKPLBean processSingleRow(ResultSet set) throws Exception {
		AlbumBean bean  = null;
		while(set.next())
		{
			 bean = new  AlbumBean();
			 bean.setId(set.getInt(1));
			 bean.setName(set.getString(2));
			 bean.setDescription(set.getString(3));
			 bean.setTable("u_album");
			 System.out.println(bean);
		}
		return bean;
	}
	

}
