package modelo;

public class Compra {
    private String numeroBoleta;
    private String fecha;
    private int cantidad;
    private String descripcion;
    private String runCliente; // Llave foránea hacia Cliente
    private String sku;        // Llave foránea hacia Producto

    // Constructor
    public Compra(String numeroBoleta, String fecha, int cantidad, String descripcion, String runCliente, String sku) {
        this.numeroBoleta = numeroBoleta;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.runCliente = runCliente;
        this.sku = sku;
    }

    // Getters y Setters
    public String getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(String numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
