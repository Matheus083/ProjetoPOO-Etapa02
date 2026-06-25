public class Agenda {

    public boolean existeConflito(
            Consulta[] consultas,
            int totalConsultas,
            String profissional,
            String data,
            String horario) {

        for (int i = 0; i < totalConsultas; i++) {

            if (consultas[i].nomeProfissional.equals(profissional)
                    && consultas[i].data.equals(data)
                    && consultas[i].horario.equals(horario)
                    && consultas[i].status.equals("agendada")) {

                return true;
            }
        }

        return false;
    }
}