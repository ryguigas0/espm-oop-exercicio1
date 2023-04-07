package comandos;

import java.util.ArrayList;

import models.Comando;
import models.Empregado;
import models.Pessoa;

public class ListarEmpregados extends Comando {

    @Override
    public void executar(ArrayList<Pessoa> database) {
        String output = "";

        for (Pessoa pessoa : database) {
            if (pessoa instanceof Empregado empregado) {
                output += empregado + "\n";
            }
        }

        if (output.equals("")) {
            Auxiliar.dialogoMensagem("Empregados não encontrados!");
        } else {
            output = "Empregados encontrados:\n" + output;
            Auxiliar.dialogoMensagem(output);
        }
    }

}
