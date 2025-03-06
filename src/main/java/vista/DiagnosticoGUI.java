package vista;

import controlador.DiagnosticoControlador;
import modelo.Diagnostico;
import util.FileUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class DiagnosticoGUI extends JFrame {
    private DiagnosticoControlador diagnosticoControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtIdDiagnostico, txtNombreDiagnostico, txtDescripcion, txtIdMascota, txtRunPersonal;
    private JButton btnSave, btnOpen;

    public DiagnosticoGUI() {
        diagnosticoControlador = new DiagnosticoControlador();
        setTitle("Gestión de Diagnósticos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID Diagnóstico:"));
        txtIdDiagnostico = new JTextField();
        inputPanel.add(txtIdDiagnostico);

        inputPanel.add(new JLabel("Nombre Diagnóstico:"));
        txtNombreDiagnostico = new JTextField();
        inputPanel.add(txtNombreDiagnostico);

        inputPanel.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        inputPanel.add(txtDescripcion);

        inputPanel.add(new JLabel("ID Mascota:"));
        txtIdMascota = new JTextField();
        inputPanel.add(txtIdMascota);

        inputPanel.add(new JLabel("RUN Personal:"));
        txtRunPersonal = new JTextField();
        inputPanel.add(txtRunPersonal);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar los diagnósticos
        tableModel = new DefaultTableModel(new String[]{"ID Diagnóstico", "Nombre Diagnóstico", "Descripción", "ID Mascota", "RUN Personal"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnSearch = new JButton("Buscar");
        btnSave = new JButton("Guardar Archivo");
        btnOpen = new JButton("Abrir Archivo");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnOpen);

        add(buttonPanel, BorderLayout.SOUTH);

        // Acción para agregar diagnóstico
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDiagnostico = txtIdDiagnostico.getText();
                String nombreDiagnostico = txtNombreDiagnostico.getText();
                String descripcion = txtDescripcion.getText();
                String idMascota = txtIdMascota.getText();
                String runPersonal = txtRunPersonal.getText();

                diagnosticoControlador.agregarDiagnostico(idDiagnostico, nombreDiagnostico, descripcion, idMascota, runPersonal);
                tableModel.addRow(new Object[]{idDiagnostico, nombreDiagnostico, descripcion, idMascota, runPersonal});
                clearFields();
            }
        });

        // Acción para actualizar diagnóstico
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idDiagnostico = txtIdDiagnostico.getText();
                    String nombreDiagnostico = txtNombreDiagnostico.getText();
                    String descripcion = txtDescripcion.getText();
                    String idMascota = txtIdMascota.getText();
                    String runPersonal = txtRunPersonal.getText();

                    diagnosticoControlador.actualizarDiagnostico(idDiagnostico, nombreDiagnostico, descripcion, idMascota, runPersonal);

                    tableModel.setValueAt(idDiagnostico, selectedRow, 0);
                    tableModel.setValueAt(nombreDiagnostico, selectedRow, 1);
                    tableModel.setValueAt(descripcion, selectedRow, 2);
                    tableModel.setValueAt(idMascota, selectedRow, 3);
                    tableModel.setValueAt(runPersonal, selectedRow, 4);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un diagnóstico para actualizar.");
                }
            }
        });

        // Acción para eliminar diagnóstico
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idDiagnostico = (String) tableModel.getValueAt(selectedRow, 0);
                    diagnosticoControlador.eliminarDiagnostico(idDiagnostico);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un diagnóstico para eliminar.");
                }
            }
        });

        // Acción para buscar diagnóstico
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDiagnostico = txtIdDiagnostico.getText();
                Diagnostico diagnostico = diagnosticoControlador.buscarDiagnosticoPorId(idDiagnostico);
                if (diagnostico != null) {
                    txtNombreDiagnostico.setText(diagnostico.getNombreDiagnostico());
                    txtDescripcion.setText(diagnostico.getDescripcion());
                    txtIdMascota.setText(diagnostico.getIdMascota());
                    txtRunPersonal.setText(diagnostico.getRunPersonal());
                } else {
                    JOptionPane.showMessageDialog(null, "Diagnóstico no encontrado.");
                }
            }
        });

        // Acción para guardar datos en archivo
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(DiagnosticoGUI.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String rutaArchivo = file.getAbsolutePath();
                    StringBuilder contenido = new StringBuilder();
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
                            contenido.append(tableModel.getValueAt(i, j)).append(",");
                        }
                        contenido.deleteCharAt(contenido.length() - 1);
                        contenido.append("\n");
                    }
                    FileUtil.escribirLinea(rutaArchivo, contenido.toString());
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente.");
                }
            }
        });

        // Acción para abrir y leer archivo
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(DiagnosticoGUI.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String rutaArchivo = file.getAbsolutePath();
                    List<String> lineas = FileUtil.leerArchivo(rutaArchivo);
                    tableModel.setRowCount(0); // Limpiar la tabla antes de mostrar nuevos datos
                    for (String linea : lineas) {
                        String[] datos = linea.split(",");
                        tableModel.addRow(datos);
                    }
                }
            }
        });
    }

    private void clearFields() {
        txtIdDiagnostico.setText("");
        txtNombreDiagnostico.setText("");
        txtDescripcion.setText("");
        txtIdMascota.setText("");
        txtRunPersonal.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiagnosticoGUI().setVisible(true);
            }
        });
    }
}
