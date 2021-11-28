package provaM2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Ata a1 = new Ata();
        Emissor e1 = new Emissor();

        //criar ata e mudar status ata
        a1.criar();
        e1.mudarStatusAta();

        //adicionar Participantes
        a1.adicionarParticipante();
        a1.adicionarParticipanteExterno();
        a1.escolherAdm();

        //editar ata
        a1.editar();

        //finalizar reunião e mudar status da ata
        a1.finalizarReuniao();
        e1.mudarStatusAta();

        //emitir relatório
        a1.emitirRelatorio();

        //mudarStatus
        e1.mudarStatusAta();
        e1.notificarParticipante();

        //como pegar o email dos participantes na lista?

        //excluir (Titulo, Setor, Pauta, Descrição , Tudo)
        a1.excluir();




    }
}
