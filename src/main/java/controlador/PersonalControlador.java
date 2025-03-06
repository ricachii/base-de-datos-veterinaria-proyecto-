package controlador;

import dao.PersonalDAO;
import modelo.Personal;
import java.util.List;

public class PersonalControlador {
    private PersonalDAO personalDAO;

    public PersonalControlador() {
        this.personalDAO = new PersonalDAO();
    }

    public void agregarPersonal(String runPersonal, String nombre, String cargo) {
        Personal nuevoPersonal = new Personal(runPersonal, nombre, cargo);
        personalDAO.agregarPersonal(nuevoPersonal);
    }

    public List<Personal> obtenerPersonal() {
        return personalDAO.obtenerPersonal();
    }

    public Personal buscarPersonalPorRun(String runPersonal) {
        return personalDAO.buscarPersonalPorRun(runPersonal);
    }

    public void actualizarPersonal(String runPersonal, String nombre, String cargo) {
        Personal personalActualizado = new Personal(runPersonal, nombre, cargo);
        personalDAO.actualizarPersonal(personalActualizado);
    }

    public void eliminarPersonal(String runPersonal) {
        personalDAO.eliminarPersonal(runPersonal);
    }
}
