package provaM2;

public class Relatorio extends Ata{

//ESSA CLASSE SE TORNOU INÚTIL, POR ENQUANTO, POIS METODO emitirRelatorio ESTÁ NA CLASSE ATA
    public void emitirRelatorio (){
        if(this.isStatus() == false){ //correto seria emitir o relatório depois de finalizarReunião
            System.out.println("-----RELATÓRIO-----");

            //System.out.println("Título: " + lista.get(0));
            System.out.println("Título: " + getTitulo());

            //System.out.println("Setor: " + lista.get(1));
            System.out.println("Setor: " + getSetor());

            //System.out.println("Pauta: " + lista.get(2));
            System.out.println("Pauta: " + getPauta());

            //System.out.println("Descrição: " + lista.get(3));
            System.out.println("Descrição: " + getDescricao());

            System.out.println("Palavras Chave: " + getPalavraChave());

            //System.out.println("Tempo de Reunião: " );
            //System.out.println("Quantidade de Participantes: " + listaDeParticipante.size());
            //System.out.println("Admnistrador Ata: " + getAdministradorAta());
        }
    }
}
