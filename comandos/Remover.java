package comandos;

import java.util.ArrayList;

import models.Comando;
import models.Pessoa;

public class Remover extends Comando {

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

        if (pessoaEncontrada == null) {
            Auxiliar.dialogoMensagem("Pessoa não encontrada!");
            return;
        }

        boolean confirmado = Auxiliar
                .dialogoConfirmar("Deletar pessoa de " + cpfPesquisa + " abaixo?\n" + pessoaEncontrada + "\n");

        if (confirmado) {
            database.remove(pessoaEncontrada);
            Auxiliar.dialogoMensagem("Pessoa removida!");
        }
    }

}
