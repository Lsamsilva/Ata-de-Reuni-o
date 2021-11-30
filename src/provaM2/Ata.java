package provaM2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ata {

    private String titulo;
    private Participante participante;
    private LocalDateTime dataInicio;
    private LocalDateTime datafim;
    private String pauta;
    private String setor;
    private String descricao;
    private String palavraChave;
    private Emissor emissorAta;
    private Administrador administradorAta;
    private boolean status;


    //criar() inicializa e formata a hora quando é chamado
    public void criar (){

        this.status = true;

        System.out.println("---------------------------------");
        System.out.println("Ata de Reunião criada com sucesso!");
        System.out.println("---------------------------------");

        this.dataInicio = LocalDateTime.now(); //dataInicio recebe hora atual do computador
        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(this.dataInicio);
        System.out.println("Data criação da Ata: " + dataFormatada);
        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(this.dataInicio);
        System.out.println("Hora criação da Ata: " + horaFormatada);
        System.out.println("---------------------------------");

        String enter = scanner.nextLine();
    }

    Scanner scanner = new Scanner(System.in);
    ArrayList<String> lista = new ArrayList<>();

    //editar() título, setor, pauta, descrição
    public void editar(){
        if (this.status){
            System.out.print("Título da Ata: ");
            String titulo = scanner.nextLine();
            setTitulo(titulo);

            System.out.print("Setor: ");
            String setor = scanner.nextLine();
            setSetor(setor);

            System.out.print("Pauta: ");
            String pauta = scanner.nextLine();
            setPauta(pauta);

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            setDescricao(descricao);

            String enter = scanner.nextLine();

        }else{
            System.out.println("Ata não pode ser editada.");
        }

        lista.add(getTitulo());
        lista.add(getSetor());
        lista.add(getPauta());
        lista.add(getDescricao());
    }

    public void excluir(){

        System.out.println("Escolha entre as opções abaixo a que deseja excluir: \n " +
                "Título /   Setor   /   Pauta   /   Descrição   /   Tudo");

        String texto = scanner.nextLine();

        switch (texto){

            case "Título":
                lista.remove(titulo);
                System.out.println("Título removido com sucesso");
                break;

            case "Setor":
                lista.remove(setor);
                System.out.println("Setor removido com sucesso");
                break;

            case "Pauta":
                lista.remove(pauta);
                System.out.println("Pauta removida com sucesso");
                break;

            case "Descrição":
                lista.remove(descricao);
                System.out.println("Descrição removida com sucesso");
                break;

            case "Tudo":
                lista.removeAll(lista);
                System.out.println("Lista removida com sucesso");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    }

    public void finalizarReuniao(){

        this.status = false;

        System.out.println("---------------------------------");
        System.out.println("Reunião Encerrada");
        System.out.println("                                 ");

        this.datafim = LocalDateTime.now();

        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(this.datafim);
        System.out.println("Data encerramento da Ata: " + dataFormatada);

        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(this.datafim);
        System.out.println("Hora encerramento da Ata: " + horaFormatada);

        System.out.print("Palavras-Chave: ");
        String palavrasChave = scanner.nextLine();
        setPalavraChave(palavrasChave);
        System.out.println("---------------------------------");

        String enter = scanner.nextLine();
    }

    ArrayList<Participante> listaDeParticipante = new ArrayList<>();

    public void adicionarParticipante (){

        //só é possível adicionar participante se o status da Ata for true
        if (this.status){

            Participante participante = new Participante();

            //nome
            System.out.print("Nome do Participante: ");
            String nomeParticipante = scanner.nextLine();
            participante.setNome(nomeParticipante);
            //email
            System.out.print("Email do Participante: ");
            String emailParticipante = scanner.nextLine();
            participante.setEmail(emailParticipante);

            listaDeParticipante.add(participante);

            String enter = scanner.nextLine();

        }else{
            System.out.println("Não foi possível adicionar participante." +
                    "Para adicionar um participante certifique-se que a Ata foi criada.");

            String enter = scanner.nextLine();
        }
    }

    public void adicionarParticipanteExterno(){
        if (this.status){

            ParticipanteExterno externo = new ParticipanteExterno();

            //nome
            System.out.print("Nome do Participante: ");
            String nomeParticipante = scanner.nextLine();
            externo.setNome(nomeParticipante);
            //email
            System.out.print("Email do Participante: ");
            String emailParticipante = scanner.nextLine();
            externo.setEmail(emailParticipante);
            //empresa
            System.out.print("Empresa do Participante: ");
            String empresaParticipante = scanner.nextLine();
            externo.setEmpresa(empresaParticipante);

            listaDeParticipante.add(externo);

            String enter = scanner.nextLine();

        }else{
            System.out.println("Não foi possível adicionar participante.");
            String enter = scanner.nextLine();
        }
    }


    public void escolherAdm (){
        //ADM é da própria empresa - FUNCIONÁRIO
        System.out.println("Colaborador Administrador da Ata");
        administradorAta = new Administrador();

        //nome
        System.out.print("Nome do Administrador: ");
        String nomeAdm = scanner.nextLine();
        administradorAta.setNome(nomeAdm);
        //email
        System.out.print("Email do Administrador: ");
        String emailAdm = scanner.nextLine();
        administradorAta.setEmail(emailAdm);

        listaDeParticipante.add(administradorAta);

        String enter = scanner.nextLine();
    }

    public void emitirRelatorio(){

        if (administradorAta != null && isStatus() == false){ //esse método só poderá ser chamado depois do método escolherAdm que instancia Administrador

            //deve ser emitido após a finalização do método finalizarReuniao
            System.out.println("-----RELATÓRIO-----");
            System.out.println("Título: " + lista.get(0));
            System.out.println("Setor: " + lista.get(1));
            System.out.println("Pauta: " + lista.get(2));
            System.out.println("Descrição: " + lista.get(3));
            System.out.println("Palavras Chave: " + getPalavraChave());
            System.out.println("Quantidade de Participantes: " + listaDeParticipante.size());
            String enter = scanner.nextLine();

        }else{
            System.out.println("Administrador deve emitir a Ata após a finalização da reunião.");
            String enter = scanner.nextLine();
        }
    }



    //Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDateTime datafim) {
        this.datafim = datafim;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public Administrador getAdministradorAta() {
        return administradorAta;
    }

    public void setAdministradorAta(Administrador administradorAta) {
        this.administradorAta = administradorAta;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Emissor getEmissorAta() {
        return emissorAta;
    }

    public void setEmissorAta(Emissor emissorAta) {
        this.emissorAta = emissorAta;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
