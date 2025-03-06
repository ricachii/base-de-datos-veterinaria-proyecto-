package modelo;

public class Cita {
    private String idCita;
    private String fecha;
    private String hora;
    private String runCliente;
    private String idMascota;

    // Constructor
    public Cita(String idCita, String fecha, String hora, String runCliente, String idMascota) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.runCliente = runCliente;
        this.idMascota = idMascota;
    }

    // Getters y Setters
    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }
}
