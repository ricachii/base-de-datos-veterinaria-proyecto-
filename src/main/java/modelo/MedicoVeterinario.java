package modelo;

public class MedicoVeterinario extends Personal {
    private String especialidad;

    public MedicoVeterinario(String runPersonal, String nombrePersonal, String cargo, String especialidad) {
        super(runPersonal, nombrePersonal, cargo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
