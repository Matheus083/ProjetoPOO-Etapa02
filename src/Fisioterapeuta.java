//Classe filha de Profissional, especialização de fisioterapeuta

public class Fisioterapeuta extends Profissional {

    public Fisioterapeuta(String nome, String cpf) {
        super(nome, cpf);
        setEspecialidade("Fisioterapia");
    }

    public Fisioterapeuta(String nome, String cpf, String registro, float valorConsulta) {
        super(nome, cpf, "Fisioterapia", registro, valorConsulta);
    }
}


//a
