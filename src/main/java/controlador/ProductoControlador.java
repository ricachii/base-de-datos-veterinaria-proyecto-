package controlador;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.List;

public class ProductoControlador {
    private ProductoDAO productoDAO;

    public ProductoControlador() {
        this.productoDAO = new ProductoDAO();
    }

    public void agregarProducto(String sku, String nombreProducto, double precio) {
        Producto nuevoProducto = new Producto(sku, nombreProducto, precio);
        productoDAO.agregarProducto(nuevoProducto);
    }

    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerProductos();
    }

    public Producto buscarProductoPorSku(String sku) {
        return productoDAO.buscarProductoPorSku(sku);
    }

    public void actualizarProducto(String sku, String nombreProducto, double precio) {
        Producto productoActualizado = new Producto(sku, nombreProducto, precio);
        productoDAO.actualizarProducto(productoActualizado);
    }

    public void eliminarProducto(String sku) {
        productoDAO.eliminarProducto(sku);
    }
}
