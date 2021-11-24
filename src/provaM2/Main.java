package provaM2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Ata
        Ata a1 = new Ata();
        a1.criar();
        a1.editar();
        //a1.excluir();
        a1.escolherAdm();
        //a1.escolherEmissor();
        a1.adicinarParticipante();
        //a1.adicionarParticipanteExterno();
        a1.finalizarReuniao();
        a1.emitirRelatorio();

    }
}
