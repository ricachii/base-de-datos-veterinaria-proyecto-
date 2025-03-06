package dao;

import modelo.Servicio;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    private List<Servicio> servicioList;

    public ServicioDAO() {
        this.servicioList = new ArrayList<>();
    }

    // Create
    public void agregarServicio(Servicio servicio) {
        servicioList.add(servicio);
    }

    // Read
    public List<Servicio> obtenerServicios() {
        return servicioList;
    }

    public Servicio buscarServicioPorId(String idServicio) {
        for (Servicio servicio : servicioList) {
            if (servicio.getIdServicio().equals(idServicio)) {
                return servicio;
            }
        }
        return null;
    }

    // Update
    public void actualizarServicio(Servicio servicioActualizado) {
        for (int i = 0; i < servicioList.size(); i++) {
            Servicio servicio = servicioList.get(i);
            if (servicio.getIdServicio().equals(servicioActualizado.getIdServicio())) {
                servicioList.set(i, servicioActualizado);
                return;
            }
        }
    }

    // Delete
    public void eliminarServicio(String idServicio) {
        servicioList.removeIf(servicio -> servicio.getIdServicio().equals(idServicio));
    }
}
