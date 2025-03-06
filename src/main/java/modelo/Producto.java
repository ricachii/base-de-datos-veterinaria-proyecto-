package modelo;

public class Producto {
    private String sku;
    private String nombreProducto;
    private double precio;

    // Constructor
    public Producto(String sku, String nombreProducto, double precio) {
        this.sku = sku;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    // Getters y Setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
