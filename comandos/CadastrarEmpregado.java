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
        if (nomeEmpregado == null) {
            return;
        }

        String cpfEmpregado = Auxiliar.dialogoEscrever("Digite o cpf do empregado");
        if (cpfEmpregado == null) {
            return;
        }

        int opcaoTipo = Auxiliar.dialogoOpcoesComTitulo("Qual o tipo de empregado?", "Gerente", "Vendedor");

        if (opcaoTipo == -2) {
            throw new RuntimeException("Opção inválida!");
        }

        if (opcaoTipo == 0) {
            String salarioString = Auxiliar.dialogoEscrever("Digite o salário do gerente: ");
            if (salarioString == null) {
                return;
            }

            double salario = Double
                    .parseDouble(salarioString.replace(',', '.'));

            String porcentagemBonusString = Auxiliar.dialogoEscrever("Digite a porcentagem de bônus do cliente: ")
                    .replace(',', '.');
            if (porcentagemBonusString == null) {
                return;
            }

            double porcentagemBonus = Double.parseDouble(porcentagemBonusString);

            newEmpregado = new Gerente(nomeEmpregado, cpfEmpregado, salario, porcentagemBonus / 100);
        } else if (opcaoTipo == 1) {
            String totalVendasString = Auxiliar.dialogoEscrever("Digite o total de vendas do vendedor: ");
            if (totalVendasString == null) {
                return;
            }

            int totalVendas = Integer
                    .parseInt(totalVendasString.replace(',', '.'));

            String porcentagemComissaoString = Auxiliar.dialogoEscrever("Digite a porcentagem de comissão por venda: ");
            if (porcentagemComissaoString == null) {
                return;
            }

            double porcentagemComissao = Double.parseDouble(
                    porcentagemComissaoString.replace(',', '.'));

            newEmpregado = new Vendedor(nomeEmpregado, cpfEmpregado, totalVendas, porcentagemComissao / 100);
        }

        database.add(newEmpregado);
    }

}
