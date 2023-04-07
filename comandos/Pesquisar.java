package comandos;

import java.util.ArrayList;

import models.Cliente;
import models.Comando;
import models.Empregado;
import models.Pessoa;

public class Pesquisar extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        String cpfPesquisa = Auxiliar.dialogoEscrever("Digite o CPF para pesquisa");
        if (cpfPesquisa == null) {
            return;
        }

        Pessoa pessoaEncontrada = null;
        for (Pessoa pessoa : database) {
            if (pessoa.equals(new Pessoa("", cpfPesquisa))) {
                pessoaEncontrada = pessoa;
            }
        }

        String mensagem = "";

        if (pessoaEncontrada == null) {
            mensagem = "Pessoa com CPF '" + cpfPesquisa + "' não foi encontrada!";
        } else if (pessoaEncontrada instanceof Empregado empregadoEncontrado) {
            mensagem = "Empregado encontrado\n" + empregadoEncontrado;
        } else if (pessoaEncontrada instanceof Cliente clienteEncontrado) {
            mensagem = "Cliente encontrado\n" + clienteEncontrado;
        }

        Auxiliar.dialogoMensagem(mensagem);
    }

}
