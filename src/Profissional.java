import java.util.ArrayList;
import java.util.List;
 
public class Profissional extends Pessoa {
 
    private String registro;
    private String especialidade;
    private float valorConsulta;
    private List<HorarioDisponivel> horariosDisponiveis = new ArrayList<>();
    
    // Lista global para armazenar todos os profissionais cadastrados no sistema
    private static List<Profissional> todosProfissionais = new ArrayList<>();
 
    // Inicialização de Profissional
    public Profissional(String nome, String cpf) {
        super(nome, cpf);
    }
 
    // Inicialização de Profissional com dados completos
    public Profissional(String nome, String cpf, String especialidade, String registro, float valorConsulta) {
        super(nome, cpf);
        this.especialidade = especialidade;
        this.registro = registro;
        this.valorConsulta = valorConsulta;
    }
 
    // Inicialização de Profissional vazio
    public Profissional() {}
 
    // Acesso dos dados para outra classe
    public String getRegistro() { return registro; }
    public String getEspecialidade() { return especialidade; }
    public float getValorConsulta() { return valorConsulta; }
    public List<HorarioDisponivel> getHorariosDisponiveis() { return horariosDisponiveis; }
    
    // Acesso à lista global de profissionais do sistema
    public static List<Profissional> getTodosProfissionais() { return todosProfissionais; }
 
    public void setRegistro(String registro) { this.registro = registro; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public void setValorConsulta(float valorConsulta) { this.valorConsulta = valorConsulta; }
 
    // Gerenciamento de horários do profissional
    public void adicionarHorario(HorarioDisponivel horario) {
        horariosDisponiveis.add(horario);
    }
 
    /*  Cadastro de um novo profissional 
        Padrão: CG (Clinico Geral), PSI (Psicologo), FISIO (Fisioterapia), NUTRI (Nutricionista)
    */
    public static void cadastrarNovo(String nome, String cpf, String especialidade, String registro, float valorConsulta) { 
        Profissional novo = new Profissional(nome, cpf, especialidade, registro, valorConsulta);
        todosProfissionais.add(novo);
    }
    
 
    // Método para exibir o resumo do profissional
    public void exibirResumo() {
        System.out.println("====| Resumo do Profissional |====\n");
        super.exibirDados();
        System.out.println("Especialidade: " + this.especialidade);
        System.out.println("Registro: " + this.registro);
        System.out.println("Valor da Consulta: R$ " + this.valorConsulta);
    }
}