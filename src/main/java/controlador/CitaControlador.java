package controlador;

import dao.CitaDAO;
import modelo.Cita;
import java.util.List;

public class CitaControlador {
    private CitaDAO citaDAO;

    public CitaControlador() {
        this.citaDAO = new CitaDAO();
    }

    // Método para agregar una nueva cita
    public void agregarCita(String idCita, String fecha, String hora, String runCliente, String idMascota) {
        try {
            if (idCita == null || fecha == null || hora == null || runCliente == null || idMascota == null) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }
            Cita nuevaCita = new Cita(idCita, fecha, hora, runCliente, idMascota);
            citaDAO.agregarCita(nuevaCita);
        } catch (Exception e) {
            System.out.println("Error al agregar la cita: " + e.getMessage());
        }
    }

    // Método para obtener todas las citas
    public List<Cita> obtenerCitas() {
        try {
            return citaDAO.obtenerCitas();
        } catch (Exception e) {
            System.out.println("Error al obtener las citas: " + e.getMessage());
            return null;
        }
    }

    // Método para buscar una cita por su ID
    public Cita buscarCitaPorId(String idCita) {
        try {
            if (idCita == null) {
                throw new IllegalArgumentException("El ID de la cita no puede ser nulo.");
            }
            return citaDAO.buscarCitaPorId(idCita);
        } catch (Exception e) {
            System.out.println("Error al buscar la cita: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar una cita
    public void actualizarCita(String idCita, String fecha, String hora, String runCliente, String idMascota) {
        try {
            if (idCita == null || fecha == null || hora == null || runCliente == null || idMascota == null) {
                throw new IllegalArgumentException("Todos los campos son obligatorios para actualizar la cita.");
            }
            Cita citaActualizada = new Cita(idCita, fecha, hora, runCliente, idMascota);
            citaDAO.actualizarCita(citaActualizada);
        } catch (Exception e) {
            System.out.println("Error al actualizar la cita: " + e.getMessage());
        }
    }

    // Método para eliminar una cita
    public void eliminarCita(String idCita) {
        try {
            if (idCita == null) {
                throw new IllegalArgumentException("El ID de la cita no puede ser nulo.");
            }
            citaDAO.eliminarCita(idCita);
        } catch (Exception e) {
            System.out.println("Error al eliminar la cita: " + e.getMessage());
        }
    }
}
