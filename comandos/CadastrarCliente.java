package comandos;

import java.util.ArrayList;

import models.Cliente;
import models.Comando;
import models.Pessoa;

public class CadastrarCliente extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        String nomeCliente = Auxiliar.dialogoEscrever("Digite o nome do cliente");
        if (nomeCliente == null) {
            return;
        }

        String cpfCliente = Auxiliar.dialogoEscrever("Digite o CPF do cliente");
        if (cpfCliente == null) {
            return;
        }

        String valorDividaClienteString = Auxiliar.dialogoEscrever("Digite o valor da divída do cliente");
        if (valorDividaClienteString == null) {
            return;
        }

        double valorDividaCliente = Double
                .parseDouble(valorDividaClienteString.replace(",", "."));

        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, valorDividaCliente);

        database.add(newCliente);
    }

}
