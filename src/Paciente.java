import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {

    List<Paciente> pacientes = new ArrayList<>();

    private String email;
    private String convenio;
    private String telefone;
    private int idade;
    private String sexo;

   protected Paciente(String nome, String cpf){
        super(nome, cpf);
    }

    protected Paciente (String nome, String cpf, String telefone, int idade, String sexo){
       super(nome, cpf);
       this.telefone = telefone;
        this.idade = idade;
    }

    protected Paciente(String nome, String cpf, String email, String convenio){
        super(nome, cpf);
        this.email = email;
        this.convenio = convenio;
    }

    //Inicialização de Paciente
    protected Paciente(){}
    //Acesso dos dados para outra classe
    public String getEmail() {
        return email;
    }
    public String getConvenio() {
        return convenio;
    }

    //Método para cadastrar o paciente
    protected void cadastroPaciente(Paciente p){

    //Verificação de existência do paciente no sistema
       for (Paciente paciente : pacientes) {

           if(paciente.getcpf().equals(p.getcpf())){
               System.out.println("Paciente já cadastrado no sistema.");
               return;
           }
           //Caso não exista, paciente novo é cadastrado
           pacientes.add(paciente);
           System.out.println("Paciente cadastrado com sucesso");
       }
    }

    //Método para exibir os dados do paciente
    protected void exibirDados()
    {
        System.out.println("====| Dados do Paciente |====\n");
        super.exibirDados();
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Idade: " + this.idade);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Convenio: " + this.convenio);
    }

}
