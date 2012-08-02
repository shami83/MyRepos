package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UKPLConnection {
	public static String CONN_URL="jdbc:mysql://localhost:3306/ukpl";
	public static Connection con=null;
	public static Connection getConnection()throws Exception
	{
		Class.forName("org.gjt.mm.mysql.Driver");
		con =DriverManager.getConnection(CONN_URL,"root","Passw0rd");
		return con;
	}
	
	public static void closeConnetion()throws Exception
	{
		con.close();
	}

}
