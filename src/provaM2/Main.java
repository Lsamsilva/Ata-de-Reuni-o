package provaM2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Ata a1 = new Ata();
        Emissor e1 = new Emissor();

        //criar ata e mudar status
        a1.criar();
        e1.mudarStatusAta();

        //adicionar Participantes
        a1.adicionarParticipante();
        a1.adicionarParticipanteExterno();
        a1.escolherAdm();

        //editar ata
        a1.editar();

        //finalizar reunião e mudar status
        a1.finalizarReuniao();
        e1.mudarStatusAta();

        //emitir relatório
        a1.emitirRelatorio();

        //excluir (Titulo, Setor, Pauta, Descrição , Tudo)
        a1.excluir();

        //mudarStatus e notificar
        e1.mudarStatusAta();
        e1.notificarParticipante();
    }
}
