package dao;

import modelo.Personal;
import java.util.ArrayList;
import java.util.List;

public class PersonalDAO {
    private List<Personal> personalList;

    public PersonalDAO() {
        this.personalList = new ArrayList<>();
    }

    // Create
    public void agregarPersonal(Personal personal) {
        personalList.add(personal);
    }

    // Read
    public List<Personal> obtenerPersonal() {
        return personalList;
    }

    public Personal buscarPersonalPorRun(String runPersonal) {
        for (Personal personal : personalList) {
            if (personal.getRunPersonal().equals(runPersonal)) {
                return personal;
            }
        }
        return null;
    }

    // Update
    public void actualizarPersonal(Personal personalActualizado) {
        for (int i = 0; i < personalList.size(); i++) {
            Personal personal = personalList.get(i);
            if (personal.getRunPersonal().equals(personalActualizado.getRunPersonal())) {
                personalList.set(i, personalActualizado);
                return;
            }
        }
    }

    // Delete
    public void eliminarPersonal(String runPersonal) {
        personalList.removeIf(personal -> personal.getRunPersonal().equals(runPersonal));
    }
}
