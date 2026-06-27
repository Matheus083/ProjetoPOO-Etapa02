
public class Paciente extends Pessoa {

    private String email;
    private String telefone;
    private int idade;
    private String sexo;
    private boolean status;

   protected Paciente(String nome, String cpf, boolean status){
        super(nome, cpf);
        this.status = status;
    }

    protected Paciente (String nome, String cpf, String telefone, int idade, String sexo, boolean status){
       super(nome, cpf);
       this.telefone = telefone;
        this.idade = idade;
        this.sexo = sexo;
        this.status = status;
    }

    protected Paciente(String nome, String cpf, String email, boolean status){
        super(nome, cpf);
        this.email = email;
        this.status = status;
    }

    //Inicialização de Paciente
    protected Paciente(){
    }
    //Acesso dos dados
    public String getEmail() {
        return this.email;
    }
    public String getTelefone() { return this.telefone; }
    public int getIdade() { return this.idade; }
    public String getSexo() { return this.sexo; }
    public boolean isStatus() { return this.status; }

    @Override
    public void setNome(String nome) {
        // Validação segura contra NullPointer e espaços em branco
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do paciente não pode ser nulo ou vazio.");
        }
        super.setNome(nome);

    }

    @Override
    public void setCpf(String cpf) {
       if (cpf == null || cpf.trim().isEmpty()) {
           throw new IllegalArgumentException("CPF inválido! CPF do cadastro é obrigatório");
       }
       super.setCpf(cpf);
    }

    public void setEmail(String email){
       if (email == null || email.trim().isEmpty() || !email.contains("@")) {
           throw new IllegalArgumentException("Email inválido para cadastro!");
       }
       this.email = email;
    }

    public void setTelefone(String telefone){
       if (telefone == null || telefone.trim().isEmpty()) {
           throw new IllegalArgumentException("Número inválido! Telefone obrigatório para cadastro!");
       }
       this.telefone = telefone;
    }

    public void setIdade(int idade){
       if (idade < 0 || idade > 100) {
           throw new IllegalArgumentException("Idade inválida para cadastro.");
       }
       this.idade = idade;
    }

    @Override
    public void exibirDados(){
       System.out.println("----| Dados do Paciente |----");
       System.out.println("Nome do paciente: " + getNome());
       System.out.println("CPF do paciente: " + getCpf());
       System.out.println("Idade do paciente: " + this.idade);
       System.out.println("Sexo do paciente: " + this.sexo);
       System.out.println("Email do paciente: " + this.email);
       System.out.println("Telefone do paciente: " + this.telefone);
       System.out.println("Status do paciente: " + this.status);
       System.out.println("--------------------------------------------");
    }






}
