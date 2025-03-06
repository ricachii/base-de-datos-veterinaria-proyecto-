package controlador;

import dao.MascotaDAO;
import modelo.Mascota;
import java.util.List;

public class MascotaControlador {
    private MascotaDAO mascotaDAO;

    public MascotaControlador() {
        this.mascotaDAO = new MascotaDAO();
    }

    public void agregarMascota(String idMascota, String nombre, String especie, String fechaNac, boolean estadoEsterilizacion, String runCliente) {
        Mascota nuevaMascota = new Mascota(idMascota, nombre, especie, fechaNac, estadoEsterilizacion, runCliente);
        mascotaDAO.agregarMascota(nuevaMascota);
    }

    public List<Mascota> obtenerMascotas() {
        return mascotaDAO.obtenerMascotas();
    }

    public Mascota buscarMascotaPorId(String idMascota) {
        return mascotaDAO.buscarMascotaPorId(idMascota);
    }

    public void actualizarMascota(String idMascota, String nombre, String especie, String fechaNac, boolean estadoEsterilizacion, String runCliente) {
        Mascota mascotaActualizada = new Mascota(idMascota, nombre, especie, fechaNac, estadoEsterilizacion, runCliente);
        mascotaDAO.actualizarMascota(mascotaActualizada);
    }

    public void eliminarMascota(String idMascota) {
        mascotaDAO.eliminarMascota(idMascota);
    }

    // Nuevo método para eliminar todas las mascotas
    public void eliminarTodasLasMascotas() {
        mascotaDAO.eliminarTodasLasMascotas();
    }
}
