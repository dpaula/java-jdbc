package com.dpaula.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		// https://pt.stackoverflow.com/questions/172909/como-funciona-o-try-with-resources

		// Todas elas herdam da interface AutoCloseable que indica que um recurso pode
		// ser fechado automaticamente. Para isto basta abrir tal recurso e atribuí-lo à
		// uma variável dentro da definição de um try:Todas elas herdam da interface
		// AutoCloseable que indica que um recurso pode ser fechado automaticamente.
		// Para isto basta abrir tal recurso e atribuí-lo à uma variável dentro da
		// definição de um try:

		// cria a conexão e o statement
		try (Connection connection = Database.getConnection(); Statement st = connection.createStatement();) {

			System.out.println("Abrindo uma conexão");

			// imprime se tem conteudo
			System.out.println(st.execute("select * from produto"));

			// cria o resultset
			try (ResultSet resultado = st.getResultSet();) {

				// enquanto tiver linha o resultado ele le
				while (resultado.next()) {
					System.out.println();
					int id = resultado.getInt("id");
					System.out.println(id);

					String nome = resultado.getString("nome");
					System.out.println(nome);

					String desc = resultado.getString("descricao");
					System.out.println(desc);

				}
			}
		}
	}

}
