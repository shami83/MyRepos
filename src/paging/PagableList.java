package paging;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import java.util.Iterator;

import dao.UKPLConnection;

public class PagableList {
	private int resultPerPage=10;
	private int totalPage=0;
	private int totalRows=0;
	private String tableName=null;
	private Connection con;
	String extraSql=null;
	int currentPage=0;
	public PagableList(String tableName,Integer resultPerPage,Map additionalParam) throws Exception
	{
		con = UKPLConnection.getConnection();
		this.tableName =tableName;
		if(resultPerPage != null)
		{
			this.resultPerPage = resultPerPage;
		}
		if(additionalParam != null)
		{
			extraSql = createExtraSql(additionalParam);
		}
		totalRows = getTotalRows();
		totalPage = totalRows/resultPerPage;
		if(totalRows%resultPerPage != 0)
		{
			totalPage ++;
		}
	}
	private int getTotalRows() throws Exception
	{
		int totalRow=0;
		Statement st =con.createStatement();
		String sql ="Select count(*) from "+tableName;
		if(extraSql != null)
		{
			sql = sql + extraSql;
		}
		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next())
		{
			totalRow =rs.getInt(1);
		}
		return totalRow;
	}
	
	private String createExtraSql(Map additionalParam)
	{
		StringBuffer buf =new StringBuffer();
		buf.append(" Where ");
		for(Iterator it =additionalParam.keySet().iterator();it.hasNext();)
		{
			String key =(String)it.next();
			String value =(String)additionalParam.get(key);
			buf.append(key);
			buf.append(" like ");
			buf.append("'");
			buf.append(value);
			buf.append("%");
			buf.append("'");
			
			if(it.hasNext())
			{
				buf.append(" and ");
			}
		}
		return buf.toString();
	}
	
	public ResultSet doPrevious() throws Exception
	{
		ResultSet rs = null;
		if(this.hasPrevious())
		{
			int startIndex =currentPage-2;
			startIndex = startIndex*resultPerPage;
			Statement st =con.createStatement();
			String sql ="Select * from "+tableName;
			if(extraSql != null)
			{
				sql = sql + extraSql;
			}
			sql =sql + " Limit "+startIndex + ", "+resultPerPage;
			System.out.println(sql);
			rs = st.executeQuery(sql);
			currentPage--;
			}
		return rs;
	}
	
	public ResultSet doNext() throws Exception
	{
		ResultSet rs = null;
		if(this.hasNext())
		{
			int startIndex =currentPage;
			startIndex = startIndex*resultPerPage;
			Statement st =con.createStatement();
			String sql ="Select * from "+tableName;
			if(extraSql != null)
			{
				sql = sql + extraSql;
			}
			sql =sql + " Limit "+startIndex + ", "+resultPerPage;
			System.out.println(sql);
			rs = st.executeQuery(sql);
			currentPage++;
		}
		return rs;
	}
	
	public boolean hasNext()
	{
		return currentPage<totalPage;
	}
	
	public boolean hasPrevious()
	{
		return currentPage>0;
	}


}
