public class HorarioDisponivel {

    private String diaSemana;
    private String horario;

    public HorarioDisponivel(String diaSemana, String horario) {
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHorario() {
        return horario;
    }
}