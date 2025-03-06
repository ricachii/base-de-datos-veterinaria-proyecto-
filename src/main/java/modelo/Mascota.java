package modelo;

public class Mascota {
    private String idMascota;
    private String nombreMascota;
    private String especie;
    private String fechaNacimiento;
    private boolean estadoEsterilizacion;
    private String runCliente;

    // Constructor completo
    public Mascota(String idMascota, String nombreMascota, String especie, String fechaNacimiento, boolean estadoEsterilizacion, String runCliente) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoEsterilizacion = estadoEsterilizacion;
        this.runCliente = runCliente;
    }

    // Getters y Setters
    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstadoEsterilizacion() {
        return estadoEsterilizacion;
    }

    public void setEstadoEsterilizacion(boolean estadoEsterilizacion) {
        this.estadoEsterilizacion = estadoEsterilizacion;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }
}
