package provaM2;

public class Relatorio extends Ata{

    private Administrador adm;
    private Ata relatorio;

    public void emitirRelatorio (){
        System.out.println("---RESUMO---");
        System.out.println("Título: " + lista.get(0));
        System.out.println("Setor: " + lista.get(1));
        System.out.println("Pauta: " + lista.get(2));
        System.out.println("Descrição: " + lista.get(3));
        System.out.println("Quantidade de Participantes: " + listaDeParticipante.size());
    }
}
