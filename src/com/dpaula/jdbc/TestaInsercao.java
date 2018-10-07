/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

		try (Connection conn = Database.getConnection();) {

			String nome = "Xadrez'";
			String desc = "Jogo de Xadrez";

			// retorna true somente caso retorne alguma lista de consulta, neste caso não
			// tem retorno
			String sql = "insert into produto (nome, descricao) values (?, ?)";

			// gera o id de cada execução, podendo trazer na consulta depois// gera o id de
			// cada execução, podendo trazer na consulta depois
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, nome);
			ps.setString(2, desc);

			boolean resultado = ps.execute();
			System.out.println(resultado);

			ResultSet rs = ps.getGeneratedKeys();

			while (rs.next()) {
				// pega o id que foi gerado no insert
				System.out.println("ID gerado: " + rs.getString("id"));

			}
		}

	}

}
