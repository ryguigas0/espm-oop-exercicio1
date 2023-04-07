package comandos;

import java.util.ArrayList;

import models.Cliente;
import models.Comando;
import models.Pessoa;

public class ListarClientes extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        String output = "";

        for (Pessoa pessoa : database) {
            if (pessoa instanceof Cliente cliente) {
                output += cliente + "\n";
            }
        }

        if (output.equals("")) {
            Auxiliar.dialogoMensagem("Clientes não encontrados!");
        } else {
            output = "Clientes encontrados:\n" + output;
            Auxiliar.dialogoMensagem(output);
        }
    }

}
