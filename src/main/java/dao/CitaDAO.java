package dao;

import modelo.Cita;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    private List<Cita> citaList;

    public CitaDAO() {
        this.citaList = new ArrayList<>();
    }

    // Create
    public void agregarCita(Cita cita) {
        citaList.add(cita);
    }

    // Read
    public List<Cita> obtenerCitas() {
        return citaList;
    }

    public Cita buscarCitaPorId(String idCita) {
        for (Cita cita : citaList) {
            if (cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }

    // Update
    public void actualizarCita(Cita citaActualizada) {
        for (int i = 0; i < citaList.size(); i++) {
            Cita cita = citaList.get(i);
            if (cita.getIdCita().equals(citaActualizada.getIdCita())) {
                citaList.set(i, citaActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarCita(String idCita) {
        citaList.removeIf(cita -> cita.getIdCita().equals(idCita));
    }
}
