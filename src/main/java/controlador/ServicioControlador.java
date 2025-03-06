package controlador;

import dao.ServicioDAO;
import modelo.Servicio;
import java.util.List;

public class ServicioControlador {
    private ServicioDAO servicioDAO;

    public ServicioControlador() {
        this.servicioDAO = new ServicioDAO();
    }

    public void agregarServicio(String idServicio, String nombreServicio, double valorServicio) {
        Servicio nuevoServicio = new Servicio(idServicio, nombreServicio, valorServicio);
        servicioDAO.agregarServicio(nuevoServicio);
    }

    public List<Servicio> obtenerServicios() {
        return servicioDAO.obtenerServicios();
    }

    public Servicio buscarServicioPorId(String idServicio) {
        return servicioDAO.buscarServicioPorId(idServicio);
    }

    public void actualizarServicio(String idServicio, String nombreServicio, double valorServicio) {
        Servicio servicioActualizado = new Servicio(idServicio, nombreServicio, valorServicio);
        servicioDAO.actualizarServicio(servicioActualizado);
    }

    public void eliminarServicio(String idServicio) {
        servicioDAO.eliminarServicio(idServicio);
    }
}
