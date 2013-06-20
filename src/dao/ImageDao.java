package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.ImageBean;
import bean.PlayerBean;
import bean.UKPLBean;

public class ImageDao extends JDBCDao{

	public ImageDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ImageBean findById(Integer id)throws Exception
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
		ImageBean bean =(ImageBean)processSingleRow(result);
		closeAll();
		return bean;
	}
	
	public List viewAllByAlbumId(String...var)throws Exception
	{
		String albumId = var[0];
		String gameMode = var[1];
		String site = var[2];
		
		List list =null;
		con=open();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		query.append(WHERE);
		query.append(" album_id = '");
		query.append(albumId);
		query.append("'");
		query.append(AND);
		query.append(" gamemode = '");
		query.append(gameMode);
		query.append("'");
		query.append(AND);
		query.append(" site = '");
		query.append(site);
		query.append("'");
			
		
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)processRow(result);
		closeAll();
		return list;
		
		
	}

	@Override
	public List processRow(ResultSet set) throws Exception {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		ImageBean bean  = null;
		while(set.next())
		{
		
			 bean = new  ImageBean();
			 bean.setId(set.getInt(1));
			 bean.setAlbumId(set.getString(2));
			 bean.setDisplayName(set.getString(3));
			 bean.setInternalName(set.getString(4));
			 bean.setGameMode(set.getString(5));
			 bean.setSite(set.getString(6));
			 bean.setTable(getTable());
			 System.out.println(bean);
			 
			 list.add(bean);
		}
		return list;
	}
	
	@Override
	public UKPLBean processSingleRow(ResultSet set) throws Exception {
		ImageBean bean  = null;
		while(set.next())
		{

			 bean = new  ImageBean();
			 bean.setId(set.getInt(1));
			 bean.setAlbumId(set.getString(2));
			 bean.setDisplayName(set.getString(3));
			 bean.setInternalName(set.getString(4));
			 bean.setGameMode(set.getString(5));
			 bean.setSite(set.getString(6));
			 bean.setTable(getTable());
			 System.out.println(bean);
			
		}
		return bean;
	}
	public String getTable()
	{
		return "u_img";
	}

}
