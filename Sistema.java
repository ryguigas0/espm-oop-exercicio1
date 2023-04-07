
import java.util.ArrayList;

import comandos.*;
import models.Comando;
import models.Pessoa;

public class Sistema {

    private ArrayList<Pessoa> databasePessoas = new ArrayList<Pessoa>();

    private Comando[] mapComandos = { new CadastrarEmpregado(), new CadastrarCliente(), new Pesquisar(),
            new ListarEmpregados(), new ListarClientes(), new Remover() };

    public void loop() {
        boolean alive = true;

        do {
            try {
                int opcao = Auxiliar.dialogoOpcoesComTitulo("Escolha uma opção abaixo:", "Cadastrar empregado",
                        "Cadastrar cliente", "Pesquisar", "Listar empregados",
                        "Listar clientes", "Remover", "Finalizar");

                if (opcao == -2) {
                    throw new RuntimeException("Opção inválida!");
                } else if (opcao == -1 || opcao == 6) {
                    return;
                }

                Comando comandoEscolhido = mapComandos[opcao];

                comandoEscolhido.executar(databasePessoas);

            } catch (Exception e) {
                Auxiliar.dialogoMensagem(e.getMessage());
            }

        } while (alive);
    }
}