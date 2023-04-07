package comandos;

import java.util.ArrayList;

import models.Cliente;
import models.Comando;
import models.Pessoa;

public class CadastrarCliente extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        String nomeCliente = Auxiliar.dialogoEscrever("Digite o nome do cliente");

        String cpfCliente = Auxiliar.dialogoEscrever("Digite o CPF do cliente");

        double valorDividaCliente = Double
                .parseDouble(Auxiliar.dialogoEscrever("Digite o valor da divída do cliente").replace(",", "."));

        Cliente newCliente = new Cliente(nomeCliente, cpfCliente, valorDividaCliente);

        database.add(newCliente);
    }

}
