package provaM2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Emissor extends Funcionario{


    private String statusAta;
    private String statusEmissao;
    private LocalDateTime dataEmissao;


    Scanner scanner = new Scanner(System.in);

    public void mudarStatusAta (){
        System.out.println("Digite o status atual da Ata: \n" +
                "Criada / Emitida / Em Processo de Revisão / Em Processo de Conclusão");

        String texto = scanner.nextLine();

        switch (texto){

            case "Criada":
                this.statusAta = "Criada";
                System.out.println("Status da Ata: " + statusAta);
                System.out.println("---------------------------------");
                break;

            case "Em Processo de Revisão":
                this.statusAta = "Em Processo de Revisão";
                System.out.println("Status da Ata: " + statusAta);
                System.out.println("---------------------------------");
                break;

            case "Emitida":
                this.statusAta = "Emitida";
                this.dataEmissao = LocalDateTime.now();
                //formatar a data
                DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                String dataFormatada = formatterData.format(this.dataEmissao);
                System.out.println("Status da Ata: " + dataFormatada);
                System.out.println("Data emissão da Ata: " + dataFormatada);
                System.out.println("---------------------------------");
                notificarParticipante();
                break;

            default:
                System.out.println("Opção inválida!");
                this.mudarStatusAta();
        }

    }

    public void notificarParticipante(){
        System.out.println("Deseja notificar os participantes agora? Y / N ");
        String opcao = scanner.nextLine();
        if(opcao.equalsIgnoreCase("Y")){
            System.out.println("Notificações enviadas para: ");
            //email dos participantes
        }else if (opcao.equalsIgnoreCase("N")){
            System.out.println("Notificações não enviadas.");
        }else{
            System.out.println("Opção inválida. Escolha novamente");
        }
    }


    public String getStatusAta() {
        return statusAta;
    }

    public void setStatusAta(String statusAta) {
        this.statusAta = statusAta;
    }

    public String getStatusEmissao() {
        return statusEmissao;
    }

    public void setStatusEmissao(String statusEmissao) {
        this.statusEmissao = statusEmissao;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
