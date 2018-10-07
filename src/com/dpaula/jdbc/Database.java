/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hsqldb.jdbc.JDBCPool;

/**
 * @author ferna
 *
 */
public class Database {

	private DataSource dataSource;

	Database() {

		// criando um pool de conexões para o dataSource controlar as conexões
		JDBCPool pool = new JDBCPool();
		pool.setUrl("jdbc:hsqldb:hsql://localhost/loja-virtual");
		pool.setUser("SA");
		pool.setPassword("");
		this.dataSource = pool;
	}

	Connection getConnection() throws SQLException {
		// return
		// DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/loja-virtual",
		// "SA", "");

		// pegando a conexão agora do dataSource
		return this.dataSource.getConnection();
	}
}
