package dao;

import modelo.Mascota;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    private List<Mascota> mascotaList;

    public MascotaDAO() {
        this.mascotaList = new ArrayList<>();
    }

    // Create
    public void agregarMascota(Mascota mascota) {
        mascotaList.add(mascota);
    }

    // Read
    public List<Mascota> obtenerMascotas() {
        return mascotaList;
    }

    public Mascota buscarMascotaPorId(String idMascota) {
        for (Mascota mascota : mascotaList) {
            if (mascota.getIdMascota().equals(idMascota)) {
                return mascota;
            }
        }
        return null;
    }

    // Update
    public void actualizarMascota(Mascota mascotaActualizada) {
        for (int i = 0; i < mascotaList.size(); i++) {
            Mascota mascota = mascotaList.get(i);
            if (mascota.getIdMascota().equals(mascotaActualizada.getIdMascota())) {
                mascotaList.set(i, mascotaActualizada);
                return;
            }
        }
    }

    // Delete
    public void eliminarMascota(String idMascota) {
        mascotaList.removeIf(mascota -> mascota.getIdMascota().equals(idMascota));
    }

    // Nuevo método para eliminar todas las mascotas
    public void eliminarTodasLasMascotas() {
        mascotaList.clear();
    }
}
