package modelo;

public class Diagnostico {
    private String idDiagnostico;
    private String nombreDiagnostico;
    private String descripcion;
    private String idMascota;
    private String runPersonal;

    public Diagnostico(String idDiagnostico, String nombreDiagnostico, String descripcion, String idMascota, String runPersonal) {
        this.idDiagnostico = idDiagnostico;
        this.nombreDiagnostico = nombreDiagnostico;
        this.descripcion = descripcion;
        this.idMascota = idMascota;
        this.runPersonal = runPersonal;
    }

    public String getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(String idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getNombreDiagnostico() {
        return nombreDiagnostico;
    }

    public void setNombreDiagnostico(String nombreDiagnostico) {
        this.nombreDiagnostico = nombreDiagnostico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getRunPersonal() {
        return runPersonal;
    }

    public void setRunPersonal(String runPersonal) {
        this.runPersonal = runPersonal;
    }
}
