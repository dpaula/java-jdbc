/**
 * 
 */
package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.dpaula.jdbc.dao.ProdutoDao;
import com.dpaula.jdbc.model.Produto;

/**
 * @author ferna
 *
 */
public class TestaProdutoDao {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Mesa", "Mesa de 6 cadeiras");

		try (Connection conn = new ConnectionPool().getConnection();) {

			ProdutoDao pDao = new ProdutoDao(conn);

			pDao.salva(produto);

			List<Produto> ps = pDao.lista();

			for (Produto p : ps) {
				System.out.println(p);
			}

		}

	}

}
