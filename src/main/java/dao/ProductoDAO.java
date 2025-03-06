package dao;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private List<Producto> productoList;

    public ProductoDAO() {
        this.productoList = new ArrayList<>();
    }

    // Create: Agregar un producto a la lista
    public void agregarProducto(Producto producto) {
        productoList.add(producto);
    }

    // Read: Obtener todos los productos
    public List<Producto> obtenerProductos() {
        return productoList;
    }

    // Read: Buscar un producto por SKU
    public Producto buscarProductoPorSku(String sku) {
        for (Producto producto : productoList) {
            if (producto.getSku().equals(sku)) {
                return producto;
            }
        }
        return null;
    }

    // Update: Actualizar un producto existente
    public void actualizarProducto(Producto productoActualizado) {
        for (int i = 0; i < productoList.size(); i++) {
            Producto producto = productoList.get(i);
            if (producto.getSku().equals(productoActualizado.getSku())) {
                productoList.set(i, productoActualizado);
                return;
            }
        }
    }

    // Delete: Eliminar un producto por SKU
    public void eliminarProducto(String sku) {
        productoList.removeIf(producto -> producto.getSku().equals(sku));
    }
}
