package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import util.GameProperties;

public class UKPLConnection {
	public static final String CONN_URL="jdbc:mysql://localhost:3306/ukpl";
	public static Connection con=null;
	public static Connection getConnection()throws Exception
	{
		Class.forName("org.gjt.mm.mysql.Driver");
		con =DriverManager.getConnection(CONN_URL,GameProperties.getInstance().getStringProperty(GameProperties.DB_USER),"");
		return con;
	}
	
	public static void closeConnetion()throws Exception
	{
		con.close();
	}

}
