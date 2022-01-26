package controllers;

import models.Pessoa;
import services.PessoasService;

import java.sql.SQLException;
import java.util.List;

public class GerenciarPessoas {
    public static void cadastrarPessoa(String nome) throws SQLException {
        PessoasService.cadastrarPessoa(nome);
    }

    public static List<Pessoa> pesquisarPessoas() throws SQLException {
        return PessoasService.pesquisarPessoas();
    }

    public static List<Pessoa> pesquisarPessoaPorNome(String pesquisa) throws SQLException {
        return PessoasService.pesquisarPessoaPorNome(pesquisa);
    }
}
