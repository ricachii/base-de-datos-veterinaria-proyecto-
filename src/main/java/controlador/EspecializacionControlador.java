package controlador;

import dao.EspecializacionDAO;
import modelo.Especializacion;
import java.util.List;

public class EspecializacionControlador {
    private EspecializacionDAO especializacionDAO;

    public EspecializacionControlador() {
        this.especializacionDAO = new EspecializacionDAO();
    }

    public void agregarEspecializacion(String idEspecializacion, String nombreEspecializacion) {
        Especializacion nuevaEspecializacion = new Especializacion(idEspecializacion, nombreEspecializacion);
        especializacionDAO.agregarEspecializacion(nuevaEspecializacion);
    }

    public List<Especializacion> obtenerEspecializaciones() {
        return especializacionDAO.obtenerEspecializaciones();
    }

    public Especializacion buscarEspecializacionPorId(String idEspecializacion) {
        return especializacionDAO.buscarEspecializacionPorId(idEspecializacion);
    }

    public void actualizarEspecializacion(String idEspecializacion, String nombreEspecializacion) {
        Especializacion especializacionActualizada = new Especializacion(idEspecializacion, nombreEspecializacion);
        especializacionDAO.actualizarEspecializacion(especializacionActualizada);
    }

    public void eliminarEspecializacion(String idEspecializacion) {
        especializacionDAO.eliminarEspecializacion(idEspecializacion);
    }
}
