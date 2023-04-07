import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import models.Comando;
import models.Pessoa;
import models.comandos.*;

public class Sistema {

    private ArrayList<Pessoa> databasePessoas = new ArrayList<Pessoa>();

    private Comando[] mapComandos = { new CadastrarEmpregado(), new CadastrarCliente(), new Pesquisar(),
            new ListarEmpregados(), new ListarClientes(), new Remover() };

    public void loop() {
        boolean alive = true;

        do {
            try {
                int opcao = dialogoOpcoes("Cadastrar empregado", "Cadastrar cliente", "Pesquisar", "Listar empregados",
                        "Listar clientes", "Remover", "Finalizar");

                if (opcao == -2) {
                    throw new RuntimeException("Opção inválida!");
                } else if (opcao == -1 || opcao == 6) {
                    return;
                }

                Comando comandoEscolhido = mapComandos[opcao];

                System.out.println(comandoEscolhido);

                comandoEscolhido.executar(databasePessoas);

            } catch (Exception e) {
                showMessageDialog(getRootFrame(), e.getMessage());
            }

        } while (alive);
    }

    private int dialogoOpcoes(String... opcoes) {
        String msg = "";

        for (int i = 0; i < opcoes.length; i++) {
            msg += String.format("%d. %s\n", i + 1, opcoes[i]);
        }

        String userInput = showInputDialog(getRootFrame(), msg);

        try {
            int parsedUserInput = Integer.parseInt(userInput) - 1;

            if (parsedUserInput < 0 || parsedUserInput > (opcoes.length - 1)) {
                return -2;
            }

            return parsedUserInput;

        } catch (Exception e) {
            if (userInput == null) {
                return -1;
            }

            return -2;

        }
    }
}