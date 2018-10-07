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

			// por padrão o commit é true, então colocamos para false para controlar cada
			// execução
			conn.setAutoCommit(false);

			// retorna true somente caso retorne alguma lista de consulta, neste caso não
			// tem retorno
			String sql = "insert into produto (nome, descricao) values (?, ?)";

			// gera o id de cada execução, podendo trazer na consulta depois// gera o id de
			// cada execução, podendo trazer na consulta depois
			try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

				insereProduto(ps, "Xadrez'", "Jogo de Xadrez");
				insereProduto(ps, "Relogio", "Relogio de ponteiro");

				// commita o bloco todo caso não der erro
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				// caso der algum erro da um rollback
				conn.rollback();
				System.out.println("Rollback realizado");
			}
		}

	}

	/**
	 * @param ps
	 * @param nome
	 * @param desc
	 * @throws SQLException
	 */
	private static void insereProduto(PreparedStatement ps, String nome, String desc) throws SQLException {

		if (nome.equals("Relogio")) {
			throw new IllegalArgumentException();
		}

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
