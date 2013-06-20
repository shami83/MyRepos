package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/* This class used for database pooling*/
public class UKPLPooledConnection {

	public static UKPLPooledConnection instance;
	public DataSource ds;
	private Context ctx;

	public static UKPLPooledConnection getInstance() {
		return instance == null ? instance = new UKPLPooledConnection()
				: instance;

	}

	private Context getContext() throws NamingException {
		if (ctx == null) {
			ctx = (Context) new InitialContext().lookup("java:comp/env");

		}
		return ctx;

	}

	private DataSource getDataSouce() throws NamingException {
		if (ds == null) {
			ds = (DataSource) getContext().lookup("jdbc/ukplLookUp");
		}
		return ds;
	}

	public Connection getPooledConnection() throws SQLException, NamingException {
		return getDataSouce().getConnection();
	}

}
