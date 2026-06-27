import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//Classe que reúne a lógica de negócio da clínica
public class ClinicaServico {
    
    private List<Pessoa> todasAsPessoas = new ArrayList<>(); //Lista de todas as pessoas cadastradas no sistema
    
/*=========================| PACIENTE |=========================*/ 
    private HashMap<String, Paciente> mapaPacientes = new HashMap<>(); //Dicionário de pacientes
    private HashSet<String> cpfsCadastrados = new HashSet<>(); //Set para garantir que não existirão cpfs repetidos no sistema

    //Cadastra Pacientes
    public void cadastrarPaciente(Paciente novoPaciente){

        String cpf = novoPaciente.getCpf();

        //Validando se o cpf já existe nos cadastros
        if(cpfsCadastrados.contains(cpf)){
            System.out.println("Erro: Paciente já cadastrado!"); // TODO: Implementar exception
            return;
        }
        //Se o cpf for novo, adiciona nas coleções
        cpfsCadastrados.add(cpf); //Set
        mapaPacientes.put(cpf, novoPaciente);
        todasAsPessoas.add(novoPaciente);
        novoPaciente.setStatus(true); //Define o status do paciente como ativo
        System.out.println("Cadastro finalizado");
    }

    //Atualiza o cadastro de Pacientes com idade e telefone
    public void atualizarPaciente(Paciente p, int idade, String telefone){
        
        p.setIdade(idade);
        p.setTelefone(telefone);
    }

    //SOBRECARGA: Atualiza o cadastro de Pacientes com idade, telefone e Convenio
    public void atualizarPaciente(Paciente p, int idade, String telefone, Convenio convenio){
        
        p.setIdade(idade);
        p.setTelefone(telefone);
        p.setConvenio(convenio);
    }

    //Busca um paciente pelo cpf no Dicionário
    public Paciente buscarPorCpf(String cpf){
        
        return mapaPacientes.get(cpf); //TODO: implementar excessão pra caso não encontre
    }

    //Listar todos os Pacientes
    public void listarPacientes(){

        //Percorre a lista de Pessoas e chama exibirResumo() só quando a pessoa for um Paciente
        for(Pessoa p : todasAsPessoas){
            if(p instanceof Paciente){
                p.exibirDados();
            }
        }
    }

    //Desativar o paciente alterando seu status para inativo
    public void desativarPaciente(String cpf){

        //Procura o Paciente no dicionário e altera seu atributo status
        buscarPorCpf(cpf).setStatus(false);
    }
/* ============================================================== */
/*=======================| PROFISSIONAL |========================*/ 
    private HashMap<String, Profissional> mapaProfissionais = new HashMap<>(); //Dicionário de profissionais
    
    //Cadastrar profissionais
    public void cadastrarProfissional(Profissional novoProfissional){
        
        String nome = novoProfissional.getNome();

        //Adiciona nas coleções
        mapaProfissionais.put(nome, novoProfissional);
        todasAsPessoas.add(novoProfissional);
        System.out.println("Cadastro finalizado");
    }

    //Atualizar cadastro só com registro e valor de consultas
    public void atualizarProfissional(String nome, String registro, double valorConsulta){

        buscarProfissionalNome(nome).setRegistro(registro);
        buscarProfissionalNome(nome).setValorConsulta(valorConsulta);
    }

    //SOBRECARGA: Atualizar cadastro completamente
    public void atualizarProfissional(String nome, String registro, double valorConsulta, int quantosDias){

        buscarProfissionalNome(nome).setRegistro(registro);
        buscarProfissionalNome(nome).setValorConsulta(valorConsulta);
        //leitura dos dias
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= quantosDias; i++){
            System.out.print("Dia " +i+ ": ");
            String dia = sc.nextLine();
            HorarioDisponivel dias = new HorarioDisponivel(dia, null);
            buscarProfissionalNome(nome).adicionarHorario(dias);
        }
    }

    //Buscar profissional por nome no Dicionário, retornando um objeto
    private Profissional buscarProfissionalNome(String nome){
        
        //Verifica se a chave existe no mapa
        if (mapaProfissionais == null || !mapaProfissionais.containsKey(nome)) {
            System.out.println("Aviso: Chave não encontrada ou mapa inválido.");
            return null; 
        } //TODO: exception aqui pra validação

        return mapaProfissionais.get(nome);
    }

    //Listar todos os profissionais
    public void listarProfissionais(){

        //Percorre a lista de Pessoas e exibe as informações só quando a pessoa for um Profissional
        for(Pessoa p : todasAsPessoas){
            if(p instanceof Profissional){
                p.exibirDados();
            }
        }
    }

    //SOBRECARGA: Listar filtrando por especialidade.
    public void listarProfissionais(int op){

        switch(op){
            case 1: //Clínico geral
                for(Pessoa p : todasAsPessoas){
                    if(p instanceof ClinicoGeral){
                        p.exibirDados();
                    }
                }
                break;
            case 2: //Fisioterapeuta
                for(Pessoa p : todasAsPessoas){
                    if(p instanceof Fisioterapeuta){
                        p.exibirDados();
                    }
                }
                break;
            case 3: //Nutricionista
                for(Pessoa p : todasAsPessoas){
                    if(p instanceof Nutricionista){
                        p.exibirDados();
                    }
                }
                break;
            case 4: //Psicólogo
                for(Pessoa p : todasAsPessoas){
                    if(p instanceof Psicologo){
                        p.exibirDados();
                    }
                }
                break;
        }
    }

/* ============================================================== */
/*=========================| CONSULTA |=========================*/
    //criação do objeto agenda para realizar algumas operações relacionadas à consultas, bem como armazenar as consultas
    private Agenda agenda = new Agenda();

    //Agendar (escolher profissional)
    public void agendarConsulta(Consulta novConsulta, String cpf, String nomeProfissional, String data, String horario, String tipo){
        
        agenda.agendarConsulta(novaConsulta, cpf, nomeProfissional, data, horario, tipo);
    }

    //Cancelar
    public void cancelarConsulta(String cpf, String data, String horario, String motivo)
        throws OperacaoInvalidaException{

        agenda.cancelarConsulta(cpf, data, horario, motivo);
    }

    //Remarcar
    public void remarcarConsulta(String cpf, String novaData, String novoHorario)
        throws OperacaoInvalidaException{

        agenda.remarcarConsulta(cpf, novaData, novoHorario);
    }

    //Listar todas as consultas
    public void listarConsultas(){
        agenda.exibirResumoConsultas();
    }

    //Buscar por CPF
    public void buscarConsultasPorCpf(String cpf)
        throws OperacaoInvalidaException{
        agenda.buscaPorCpf(cpf);
    }
/* ============================================================== */

}
