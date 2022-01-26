package index;

import controllers.GerenciarPessoas;
import models.Pessoa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Inicio {
    public static void main(String[] args) throws SQLException {

        List<Pessoa> listaPessoas = GerenciarPessoas.pesquisarPessoaPorNome("as");

        listaPessoas.forEach(System.out::println);

    }
}
