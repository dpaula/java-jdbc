/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ferna
 *
 */
public class Database {

	/**
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual", "SA", "");
	}
}
