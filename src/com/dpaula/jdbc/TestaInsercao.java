/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ferna
 *
 */
public class TestaInsercao {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		try (Connection conn = Database.getConnection(); Statement st = conn.createStatement();) {

			// retorna true somente caso retorne alguma lista de consulta, neste caso não
			// tem retorno
			boolean resultado = st.execute("insert into produto (nome, descricao) values ('Cubo', 'Cubo Magico')",
					Statement.RETURN_GENERATED_KEYS);// gera o id de cada execução, podendo trazer na consulta depois

			System.out.println(resultado);

			ResultSet rs = st.getGeneratedKeys();

			while (rs.next()) {
				// pega o id que foi gerado no insert
				System.out.println("ID gerado: " + rs.getString("id"));

			}
		}

	}

}
