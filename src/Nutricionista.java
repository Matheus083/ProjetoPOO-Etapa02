//Classe filha de Profissional, especialização de nutricionista


public class Nutricionista extends Profissional {

    public Nutricionista(String nome, String cpf) {
        super(nome, cpf);
        setEspecialidade("Nutrição");
    }

    public Nutricionista(String nome, String cpf, String registro, float valorConsulta) {
        super(nome, cpf, "Nutrição", registro, valorConsulta);
    }
}
