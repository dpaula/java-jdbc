/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ferna
 *
 */
public class TestaRemocao {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		try (Connection conn = new Database().getConnection(); Statement st = conn.createStatement();) {

			st.execute("delete from produto where id > 7");
			// traz a quantidade de linhas excluidas
			int linhasAtualizadas = st.getUpdateCount();

			System.out.println("Quantidade de linhas excluidas: " + linhasAtualizadas);
		}
	}

}
