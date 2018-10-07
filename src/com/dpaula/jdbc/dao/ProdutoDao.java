/**
 * 
 */
package com.dpaula.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dpaula.jdbc.model.Produto;

/**
 * @author ferna
 *
 */
public class ProdutoDao {

	private Connection conn;

	public ProdutoDao(Connection conn) {
		this.conn = conn;
	}

	public void salva(Produto produto) throws SQLException {

		String sql = "insert into produto (nome, descricao) values (?, ?)";

		try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDesc());
			ps.execute();

			try (ResultSet rs = ps.getGeneratedKeys();) {
				if (rs.next()) {
					produto.setId(rs.getInt("id"));
				}
			}
		}
	}

	public List<Produto> lista() throws SQLException {

		ArrayList<Produto> produtos = new ArrayList<>();

		String sql = "select * from produto";

		try (PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.execute();

			try (ResultSet rs = ps.getResultSet();) {
				while (rs.next()) {

					produtos.add(new Produto().setId(rs.getInt("id")).setNome(rs.getString("nome"))
							.setDesc(rs.getString("descricao")));

				}
			}
		}

		return produtos;
	}

}
