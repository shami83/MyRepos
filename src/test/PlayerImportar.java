package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import util.GameProperties;

public class PlayerImportar {
	
	 public final String LOC ="C:\\ukpl\\playerList.txt";   
	 private Connection conn =null;
	 
	   public Connection connect()
			     {
			         String CONN_URL="jdbc:mysql://localhost:3306/ukpl";
			         try 
			         {
			             Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			             conn = DriverManager.getConnection(CONN_URL,"root","Passw0rd");
			         
			         }
			         catch(Exception e)
			         {
			             e.printStackTrace();
			             conn = null;
			         }
			  
			         return conn;    
			     }
			     
			     public void importData()
			     {
			         Statement stmt;
			         String query;
			  
			         try
			         {
			        	 //path is C:\Documents and Settings\All Users\Application Data\MySQL\MySQL Server 5.5\data ukplplayerList.txt
			             stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			             String mode =GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
			             String table = "u_player";
			             if(!mode.equalsIgnoreCase("cricket"))
			              table="u_player_"+GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
			             query = "LOAD DATA INFILE '"+LOC+"' INTO TABLE "+ table +" FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n' (name,grade,category,team,image)";
		  
			             stmt.executeUpdate(query);
			             System.out.println(query);
			             System.out.println("FINISHED");
			                 
			         }
			         catch(Exception e)
			         {
			             e.printStackTrace();
			             stmt = null;
			         }
			     }
			

			
}


