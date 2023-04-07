package comandos;

import static javax.swing.JOptionPane.*;

public abstract class Auxiliar {
    public static void dialogoMensagem(String msg) {
        showMessageDialog(getRootFrame(), msg);
    }

    public static int dialogoOpcoesComTitulo(String... args) {
        String msg = args[0] + "\n";

        for (int i = 1; i < args.length; i++) {
            msg += String.format("%d. %s\n", i, args[i]);
        }

        String userInput = showInputDialog(getRootFrame(), msg);

        return parseUserInput(userInput, args.length - 1);

    }

    public static int dialogoOpcoes(String... opcoes) {
        String msg = "";

        for (int i = 0; i < opcoes.length; i++) {
            msg += String.format("%d. %s\n", i + 1, opcoes[i]);
        }

        String userInput = showInputDialog(getRootFrame(), msg);

        return parseUserInput(userInput, opcoes.length);

    }

    // -2 -> Opção fora do limite ou errada
    // -1 -> Resposta vazia
    // x -> Número inteiro entre 0 e (opcoesLength - 1)
    private static int parseUserInput(String userInput, int opcoesLength) {
        try {
            int parsedUserInput = Integer.parseInt(userInput) - 1;

            if (parsedUserInput < 0 || parsedUserInput > (opcoesLength - 1)) {
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

    public static String dialogoEscrever(String titulo) {
        return showInputDialog(getRootFrame(), titulo);
    }

    public static boolean dialogoConfirmar(String mensagem) {
        return showConfirmDialog(getRootFrame(), mensagem, "Input", YES_NO_OPTION) == YES_OPTION;
    }
}
