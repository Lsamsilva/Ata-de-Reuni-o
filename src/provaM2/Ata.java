package provaM2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ata {

    private String titulo;
    //private Date dataEmissao; provável que tenha que estar na classe Emissor
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

    //construtor
    public Ata(){
        System.out.println("---------------------------------");
        System.out.println("Ata de Reunião criada com sucesso!");
        System.out.println("---------------------------------");
    }

    //criar() inicializa e formata a hora quando é chamado
    public void criar (){
        this.status = true;
        this.dataInicio = LocalDateTime.now(); //dataInicio recebe hora atual do computador
        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(this.dataInicio);
        System.out.println("Data criação da Ata: " + dataFormatada);
        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(this.dataInicio);
        System.out.println("Hora criação da Ata: " + horaFormatada);
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

        this.datafim = LocalDateTime.now();
        // formatar a data
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(this.datafim);
        System.out.println("Data encerramento da Ata: " + dataFormatada);
        // formatar a hora
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(this.datafim);
        System.out.println("Hora encerramento da Ata: " + dataFormatada);

        System.out.print("Palavras-Chave: ");
        String palavrasChave = scanner.nextLine();
        setPalavraChave(palavrasChave);

        System.out.println("---------------------------------");
        System.out.println("Ata de Reunião encerrada com sucesso!");
        System.out.println("---------------------------------");
        System.out.println("Data Encerramento: " + dataFormatada);
        System.out.println("Hora Encerramento: " + horaFormatada);
        System.out.println("Palavras Chave: " + palavrasChave);
    }

    ArrayList<Participante> listaDeParticipante = new ArrayList<>();

    public void adicinarParticipante (){

        //só é possível adicionar participante se o status da Ata for true
        if (this.status){
            Participante participante = new Participante();
            //nome
            System.out.println("Nome do Participante: ");
            String nomeParticipante = scanner.nextLine();
            participante.setNome(nomeParticipante);
            //email
            System.out.println("Email do Participante: ");
            String emailParticipante = scanner.nextLine();
            participante.setEmail(emailParticipante);

            listaDeParticipante.add(participante);

            //DEVE-SE MOSTRAR A LISTAGEM DE TODOS OS PARTICIPANTES

        }else{
            System.out.println("Não foi possível adicionar participante." +
                    "Para adicionar um participante certifique-se que a Ata foi criada.");
        }
    }

    public void adicionarParticipanteExterno(){
        if (this.status){
            ParticipanteExterno externo = new ParticipanteExterno();
            //nome
            System.out.println("Nome do Participante: ");
            String nomeParticipante = scanner.nextLine();
            externo.setNome(nomeParticipante);
            //email
            System.out.println("Email do Participante: ");
            String emailParticipante = scanner.nextLine();
            externo.setEmail(emailParticipante);
            //empresa
            System.out.println("Empresa do Participante: ");
            String empresaParticipante = scanner.nextLine();
            externo.setEmpresa(empresaParticipante);

            listaDeParticipante.add(externo);

        }else{
            System.out.println("Não foi possível adicionar participante.");
        }
    }


    public void escolherAdm (){
        //ADM é da própria empresa - FUNCIONÁRIO
        System.out.println("Colaborador Administrador da Ata");
        Administrador adm = new Administrador();
        //nome
        System.out.print("Nome do Administrador: ");
        String nomeAdm = scanner.nextLine();
        adm.setNome(nomeAdm);
        //email
        System.out.print("Email do Administrador: ");
        String emailAdm = scanner.nextLine();
        adm.setEmail(emailAdm);

        listaDeParticipante.add(adm);
    }

    public void escolherEmissor (){
        //EMISSOR é da própria empresa - FUNCIONÁRIO
        System.out.println("Emisso da Ata");
        Emissor emissor = new Emissor();
        //nome
        System.out.println("Nome do Emissor: ");
        String nomeEmissor = scanner.nextLine();
        emissor.setNome(nomeEmissor);
        //email
        System.out.println("Email do Emissor: ");
        String emailEmissor = scanner.nextLine();
        emissor.setEmail(emailEmissor);

        listaDeParticipante.add(emissor);
    }

        /*public void retirarParticipante (){
        System.out.println("Remover Participante por nome.");
        System.out.print("Digite o nome do participante: ");
        String nomeParticipanteRemove = scanner.nextLine();

        if (listaDeParticipante.contains(nomeParticipanteRemove)){
            //remover participante correspondente
            participante.setNome(nomeParticipanteRemove);
            listaDeParticipante.remove(getParticipante().getNome());

            System.out.println("Remoção feita com sucesso!");
        }else{
            System.out.println("Participante não encontrado.");
        }
    }*/


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
