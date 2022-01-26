package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection abrirConexao() throws SQLException {
        final String url = "jdbc:mysql://localhost/loja_virtual?verifyCertificate=false&useSSL=true";
        final String user = "root";
        final String pass = "";

        Connection connection = DriverManager
                .getConnection(url, user, pass);

        return connection;
    }

}
