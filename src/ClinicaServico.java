import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
        novoPaciente.setStatus("Ativo"); //Define o status do paciente como ativo
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
    public void listarPacientes(String cpf){

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
        buscarPorCpf(cpf).setStatus("Inativo");
    }
}
