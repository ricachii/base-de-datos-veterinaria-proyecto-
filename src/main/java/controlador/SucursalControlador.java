package controlador;

import dao.SucursalDAO;
import modelo.Sucursal;
import java.util.List;

public class SucursalControlador {
    private SucursalDAO sucursalDAO;

    public SucursalControlador() {
        this.sucursalDAO = new SucursalDAO();
    }

    public void agregarSucursal(String idSucursal, String nombre, String direccion, String horario, String telefono) {
        Sucursal nuevaSucursal = new Sucursal(idSucursal, nombre, direccion, horario, telefono);
        sucursalDAO.agregarSucursal(nuevaSucursal);
    }

    public List<Sucursal> obtenerSucursales() {
        return sucursalDAO.obtenerSucursales();
    }

    public Sucursal buscarSucursalPorId(String idSucursal) {
        return sucursalDAO.buscarSucursalPorId(idSucursal);
    }

    public void actualizarSucursal(String idSucursal, String nombre, String direccion, String horario, String telefono) {
        Sucursal sucursalActualizada = new Sucursal(idSucursal, nombre, direccion, horario, telefono);
        sucursalDAO.actualizarSucursal(sucursalActualizada);
    }

    public void eliminarSucursal(String idSucursal) {
        sucursalDAO.eliminarSucursal(idSucursal);
    }
}
