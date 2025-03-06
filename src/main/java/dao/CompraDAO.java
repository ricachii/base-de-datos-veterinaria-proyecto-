package dao;

import modelo.Compra;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    private List<Compra> compraList;

    public CompraDAO() {
        this.compraList = new ArrayList<>();
    }

    // Create
    public void agregarCompra(Compra compra) {
        compraList.add(compra);
    }

    // Read
    public List<Compra> obtenerCompras() {
        return compraList;
    }

    public Compra buscarCompraPorNumeroBoleta(String numeroBoleta) {
        for (Compra compra : compraList) {
            if (compra.getNumeroBoleta().equals(numeroBoleta)) {
                return compra;
            }
        }
        return null;
    }

    // Update
    public void actualizarCompra(Compra compraActualizada) {
        for (int i = 0; i < compraList.size(); i++) {
            Compra compra = compraList.get(i);
            if (compra.getNumeroBoleta().equals(compraActualizada.getNumeroBoleta())) {
                compraList.set(i, compraActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarCompra(String numeroBoleta) {
        compraList.removeIf(compra -> compra.getNumeroBoleta().equals(numeroBoleta));
    }
}
