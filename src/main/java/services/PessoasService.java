package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Pessoa;

public class PessoasService {


    public PessoasService() throws SQLException {
    }

    public static void cadastrarPessoa(String nome) throws SQLException {
        Connection conexao = Conexao.abrirConexao();

        String sql = "INSERT INTO pessoa (nome) VALUES (?)"; // Código SQL
        PreparedStatement stmt = conexao.prepareStatement(sql); // Prevenindo SQL Injection
        stmt.setString(1, nome); // Definindo dado do primeiro parametro

        stmt.execute(); // Executando statement

        conexao.close();
    }

    public static List<Pessoa> pesquisarPessoas() throws SQLException {
        Connection conexao = Conexao.abrirConexao();

        String sql = "SELECT * FROM pessoa"; // Código SQL
        PreparedStatement stmt = conexao.prepareStatement(sql); // Prevenindo SQL Injection

        ResultSet resultados = stmt.executeQuery(); // Executando comando e pegando resultados

        List<Pessoa> pessoas = new ArrayList(); // Lista de pessoas que a função retornará

        while (resultados.next()) {
            // Criando objeto com dados do banco de dados
            Pessoa objeto = new Pessoa(resultados.getInt("id"), resultados.getString("nome"));
            // Adicionando pessoas à lista
            pessoas.add(objeto);
        }

        conexao.close();

        return pessoas;

    }

    public static List<Pessoa> pesquisarPessoaPorNome(String nome) throws SQLException {
        Connection conexao = Conexao.abrirConexao();

        String sql = "SELECT * FROM pessoa WHERE nome LIKE ?"; // Código SQL
        PreparedStatement stmt = conexao.prepareStatement(sql); // Prevenindo SQL Injection
        stmt.setString(1, "%"+nome+"%");

        ResultSet resultados = stmt.executeQuery(); // Executando comando e pegando resultados

        List<Pessoa> pessoas = new ArrayList(); // Lista de pessoas que a função retornará

        while (resultados.next()) {
            // Criando objeto com dados do banco de dados
            Pessoa objeto = new Pessoa(resultados.getInt("id"), resultados.getString("nome"));
            // Adicionando pessoas à lista
            pessoas.add(objeto);
        }

        conexao.close();

        return pessoas;
    }
}
