package dao;

import modelo.Sucursal;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {
    private List<Sucursal> sucursalList;

    public SucursalDAO() {
        this.sucursalList = new ArrayList<>();
    }

    // Create
    public void agregarSucursal(Sucursal sucursal) {
        sucursalList.add(sucursal);
    }

    // Read
    public List<Sucursal> obtenerSucursales() {
        return sucursalList;
    }

    public Sucursal buscarSucursalPorId(String idSucursal) {
        for (Sucursal sucursal : sucursalList) {
            if (sucursal.getIdSucursal().equals(idSucursal)) {
                return sucursal;
            }
        }
        return null;
    }

    // Update
    public void actualizarSucursal(Sucursal sucursalActualizada) {
        for (int i = 0; i < sucursalList.size(); i++) {
            Sucursal sucursal = sucursalList.get(i);
            if (sucursal.getIdSucursal().equals(sucursalActualizada.getIdSucursal())) {
                sucursalList.set(i, sucursalActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarSucursal(String idSucursal) {
        sucursalList.removeIf(sucursal -> sucursal.getIdSucursal().equals(idSucursal));
    }
}
