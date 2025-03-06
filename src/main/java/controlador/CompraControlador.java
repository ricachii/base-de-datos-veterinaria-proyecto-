package controlador;

import dao.CompraDAO;
import modelo.Compra;
import java.util.List;

public class CompraControlador {
    private CompraDAO compraDAO;

    public CompraControlador() {
        this.compraDAO = new CompraDAO();
    }

    public void agregarCompra(String numeroBoleta, String fecha, int cantidad, String descripcion, String skuProducto, String runCliente) {
        Compra nuevaCompra = new Compra(numeroBoleta, fecha, cantidad, descripcion, skuProducto, runCliente);
        compraDAO.agregarCompra(nuevaCompra);
    }

    public List<Compra> obtenerCompras() {
        return compraDAO.obtenerCompras();
    }

    public Compra buscarCompraPorNumeroBoleta(String numeroBoleta) {
        return compraDAO.buscarCompraPorNumeroBoleta(numeroBoleta);
    }

    public void actualizarCompra(String numeroBoleta, String fecha, int cantidad, String descripcion, String skuProducto, String runCliente) {
        Compra compraActualizada = new Compra(numeroBoleta, fecha, cantidad, descripcion, skuProducto, runCliente);
        compraDAO.actualizarCompra(compraActualizada);
    }

    public void eliminarCompra(String numeroBoleta) {
        compraDAO.eliminarCompra(numeroBoleta);
    }
}
