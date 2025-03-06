package modelo;

public class Servicio {
    private String idServicio;
    private String nombreServicio;
    private double valorServicio;

    // Constructor
    public Servicio(String idServicio, String nombreServicio, double valorServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.valorServicio = valorServicio;
    }

    // Getters y Setters
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }
}
