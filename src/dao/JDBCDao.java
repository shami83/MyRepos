package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;

import bean.UKPLBean;



public abstract class  JDBCDao {
	protected Connection con=null;
	protected Statement st=null;
	protected final String INSERT ="INSERT INTO ";
	protected final String VALUE =" VALUES ";
	protected final String SELECT_ALL ="SELECT * FROM ";
	protected final String UPDATE ="UPDATE ";
	protected final String WHERE =" WHERE ";
	protected final String AND =" AND ";
	protected final String OR =" OR ";
	protected final String LIKE =" LIKE ";
	protected final String DELETE ="DELETE FROM ";
	protected final String ORDER_BY =" ORDER BY ";
	public JDBCDao()throws Exception
	{
		
	}
	public Connection open() throws SQLException, NamingException
	{
		return UKPLPooledConnection.getInstance().getPooledConnection();
	}
		
	public void insert(String tableName,List values,List columnList)throws Exception
	{
		st=con.createStatement();
		String query = buildInsertQuery(tableName,values,columnList);
		st.executeUpdate(query);
		closeAll();
	}
	
	
	public String buildInsertQuery(String tableName,List values,List columnList)
	{
		StringBuffer buff =new StringBuffer();
		buff.append(INSERT);
		buff.append(tableName);
		buff.append(" ( ");
		for(Iterator it=columnList.iterator();it.hasNext();)
		{
			String col =(String)it.next();
			buff.append(col);
			if(it.hasNext())
			{
				buff.append(", ");
			}
		}
		buff.append(" ) ");
		buff.append(VALUE);
		buff.append("(");
		for(Iterator it1=values.iterator();it1.hasNext();)
		{
			DataType data =(DataType)it1.next();
			if(data.getType().equalsIgnoreCase(DataType.Text))
			{
				buff.append(" '");
				buff.append(data.getValue());
				buff.append("'");
				
				
			}
			else
			{
				buff.append(data.getValue());
			}
			if(it1.hasNext())
			{
				buff.append(",");
			}
		}
		buff.append(")");
		System.out.println(buff.toString());
		return buff.toString();
	}
	
	public String getTable()
	{
		return null;
	}
	
	public void closeAll() throws Exception
	{
		st.close();
		con.close();
	}
	
	public abstract List processRow(ResultSet  set) throws Exception;
	public abstract UKPLBean processSingleRow(ResultSet  set) throws Exception;

}
