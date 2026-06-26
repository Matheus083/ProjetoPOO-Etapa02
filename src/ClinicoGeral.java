//classe filha de Profissional, especialização de clinico geral

public class ClinicoGeral extends Profissional {

    public ClinicoGeral(String nome, String cpf) {
        super(nome, cpf);
        setEspecialidade("Clínica Geral");
    }

    public ClinicoGeral(String nome, String cpf, String registro, float valorConsulta) {
        super(nome, cpf, "Clínica Geral", registro, valorConsulta);
    }
}
