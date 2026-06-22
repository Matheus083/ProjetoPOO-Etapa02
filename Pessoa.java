public abstract class Pessoa {

    private String nome, cpf;

    protected Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

   public String getnome(){
        return nome;
    }

    //Métodos para acesso em outras classes
    public String getcpf(){
        return cpf;
    }


    //Método para mostrar dados do objeto
    protected void exibirDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);

    }

    protected Pessoa(){}

}


