package controlador;

import dao.CiudadDAO;
import modelo.Ciudad;
import java.util.List;

public class CiudadControlador {
    private CiudadDAO ciudadDAO;

    public CiudadControlador() {
        this.ciudadDAO = new CiudadDAO();
    }

    public void agregarCiudad(String idCiudad, String nombreCiudad) {
        Ciudad nuevaCiudad = new Ciudad(idCiudad, nombreCiudad);
        ciudadDAO.agregarCiudad(nuevaCiudad);
    }

    public List<Ciudad> obtenerCiudades() {
        return ciudadDAO.obtenerCiudades();
    }

    public Ciudad buscarCiudadPorId(String idCiudad) {
        return ciudadDAO.buscarCiudadPorId(idCiudad);
    }

    public void actualizarCiudad(String idCiudad, String nombreCiudad) {
        Ciudad ciudadActualizada = new Ciudad(idCiudad, nombreCiudad);
        ciudadDAO.actualizarCiudad(ciudadActualizada);
    }

    public void eliminarCiudad(String idCiudad) {
        ciudadDAO.eliminarCiudad(idCiudad);
    }
}
