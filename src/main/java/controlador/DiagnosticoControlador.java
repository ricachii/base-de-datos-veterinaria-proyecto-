package controlador;

import dao.DiagnosticoDAO;
import modelo.Diagnostico;
import java.util.List;

public class DiagnosticoControlador {
    private DiagnosticoDAO diagnosticoDAO;

    public DiagnosticoControlador() {
        this.diagnosticoDAO = new DiagnosticoDAO();
    }

    public void agregarDiagnostico(String idDiagnostico, String nombreDiagnostico, String descripcion, String idMascota, String runPersonal) {
        Diagnostico nuevoDiagnostico = new Diagnostico(idDiagnostico, nombreDiagnostico, descripcion, idMascota, runPersonal);
        diagnosticoDAO.agregarDiagnostico(nuevoDiagnostico);
    }

    public List<Diagnostico> obtenerDiagnosticos() {
        return diagnosticoDAO.obtenerDiagnosticos();
    }

    public Diagnostico buscarDiagnosticoPorId(String idDiagnostico) {
        return diagnosticoDAO.buscarDiagnosticoPorId(idDiagnostico);
    }

    public void actualizarDiagnostico(String idDiagnostico, String nombreDiagnostico, String descripcion, String idMascota, String runPersonal) {
        Diagnostico diagnosticoActualizado = new Diagnostico(idDiagnostico, nombreDiagnostico, descripcion, idMascota, runPersonal);
        diagnosticoDAO.actualizarDiagnostico(diagnosticoActualizado);
    }

    public void eliminarDiagnostico(String idDiagnostico) {
        diagnosticoDAO.eliminarDiagnostico(idDiagnostico);
    }
}
