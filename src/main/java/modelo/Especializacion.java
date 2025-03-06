package modelo;

public class Especializacion {
    private String idEspecializacion;
    private String nombreEspecializacion;

    public Especializacion(String idEspecializacion, String nombreEspecializacion) {
        this.idEspecializacion = idEspecializacion;
        this.nombreEspecializacion = nombreEspecializacion;
    }

    public String getIdEspecializacion() {
        return idEspecializacion;
    }

    public void setIdEspecializacion(String idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }

    public String getNombreEspecializacion() {
        return nombreEspecializacion;
    }

    public void setNombreEspecializacion(String nombreEspecializacion) {
        this.nombreEspecializacion = nombreEspecializacion;
    }
}
