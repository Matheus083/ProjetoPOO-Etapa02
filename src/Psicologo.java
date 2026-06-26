//Classe filha de Profissional, especialização de psicologo

public class Psicologo extends Profissional {

    public Psicologo(String nome, String cpf) {
        super(nome, cpf);
        setEspecialidade("Psicologia");
    }

    public Psicologo(String nome, String cpf, String registro, float valorConsulta) {
        super(nome, cpf, "Psicologia", registro, valorConsulta);
    }
}

//a