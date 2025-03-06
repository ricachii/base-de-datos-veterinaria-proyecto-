package dao;

import modelo.Diagnostico;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO {
    private List<Diagnostico> diagnosticoList;

    public DiagnosticoDAO() {
        this.diagnosticoList = new ArrayList<>();
    }

    // Create
    public void agregarDiagnostico(Diagnostico diagnostico) {
        diagnosticoList.add(diagnostico);
    }

    // Read
    public List<Diagnostico> obtenerDiagnosticos() {
        return diagnosticoList;
    }

    public Diagnostico buscarDiagnosticoPorId(String idDiagnostico) {
        for (Diagnostico diagnostico : diagnosticoList) {
            if (diagnostico.getIdDiagnostico().equals(idDiagnostico)) {
                return diagnostico;
            }
        }
        return null;
    }

    // Update
    public void actualizarDiagnostico(Diagnostico diagnosticoActualizado) {
        for (int i = 0; i < diagnosticoList.size(); i++) {
            Diagnostico diagnostico = diagnosticoList.get(i);
            if (diagnostico.getIdDiagnostico().equals(diagnosticoActualizado.getIdDiagnostico())) {
                diagnosticoList.set(i, diagnosticoActualizado);
                return;
            }
        }
    }

    // Delete
    public void eliminarDiagnostico(String idDiagnostico) {
        diagnosticoList.removeIf(diagnostico -> diagnostico.getIdDiagnostico().equals(idDiagnostico));
    }
}
