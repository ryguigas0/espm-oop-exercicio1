package comandos;

import java.util.ArrayList;

import models.Comando;
import models.Empregado;
import models.Gerente;
import models.Pessoa;
import models.Vendedor;

public class CadastrarEmpregado extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        Empregado newEmpregado = null;

        String nomeEmpregado = Auxiliar.dialogoEscrever("Digite o nome do empregado");

        String cpfEmpregado = Auxiliar.dialogoEscrever("Digite o cpf do empregado");

        int opcaoTipo = Auxiliar.dialogoOpcoesComTitulo("Qual o tipo de empregado?", "Gerente", "Vendedor");

        if (opcaoTipo == -2) {
            throw new RuntimeException("Opção inválida!");
        }

        if (opcaoTipo == 0) {
            double salario = Double
                    .parseDouble(Auxiliar.dialogoEscrever("Digite o salário do gerente: ").replace(',', '.'));

            double porcentagemBonus = Double.parseDouble(
                    Auxiliar.dialogoEscrever("Digite a porcentagem de bônus do cliente: ").replace(',', '.'));

            newEmpregado = new Gerente(nomeEmpregado, cpfEmpregado, salario, porcentagemBonus / 100);
        } else if (opcaoTipo == 1) {
            int totalVendas = Integer
                    .parseInt(Auxiliar.dialogoEscrever("Digite o total de vendas do vendedor: ").replace(',', '.'));

            double porcentagemComissao = Double.parseDouble(
                    Auxiliar.dialogoEscrever("Digite a porcentagem de comissão por venda: ").replace(',', '.'));

            newEmpregado = new Vendedor(nomeEmpregado, cpfEmpregado, totalVendas, porcentagemComissao / 100);
        }

        database.add(newEmpregado);
    }

}
