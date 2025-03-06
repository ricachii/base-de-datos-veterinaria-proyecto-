package vista;

import controlador.MascotaControlador;
import modelo.Mascota;
import util.FileUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MascotaGUI extends JFrame {
    private MascotaControlador mascotaControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtIdMascota, txtNombreMascota, txtEspecie, txtFechaNacimiento, txtRunCliente;
    private JCheckBox chkEsterilizado; // Checkbox para estado de esterilización

    public MascotaGUI() {
        mascotaControlador = new MascotaControlador();
        setTitle("Gestión de Mascotas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("ID Mascota:"));
        txtIdMascota = new JTextField();
        inputPanel.add(txtIdMascota);

        inputPanel.add(new JLabel("Nombre Mascota:"));
        txtNombreMascota = new JTextField();
        inputPanel.add(txtNombreMascota);

        inputPanel.add(new JLabel("Especie:"));
        txtEspecie = new JTextField();
        inputPanel.add(txtEspecie);

        inputPanel.add(new JLabel("Fecha Nacimiento:"));
        txtFechaNacimiento = new JTextField();
        inputPanel.add(txtFechaNacimiento);

        inputPanel.add(new JLabel("RUN Cliente:"));
        txtRunCliente = new JTextField();
        inputPanel.add(txtRunCliente);

        inputPanel.add(new JLabel("Esterilizado:"));
        chkEsterilizado = new JCheckBox();
        inputPanel.add(chkEsterilizado);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar las mascotas
        tableModel = new DefaultTableModel(new String[]{"ID Mascota", "Nombre Mascota", "Especie", "Fecha Nacimiento", "Esterilizado", "RUN Cliente"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnSearch = new JButton("Buscar");
        JButton btnSaveToFile = new JButton("Guardar");
        JButton btnOpenFile = new JButton("Abrir");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnSaveToFile);
        buttonPanel.add(btnOpenFile);

        add(buttonPanel, BorderLayout.SOUTH);

        // Acción para agregar mascota
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idMascota = txtIdMascota.getText();
                String nombreMascota = txtNombreMascota.getText();
                String especie = txtEspecie.getText();
                String fechaNacimiento = txtFechaNacimiento.getText();
                boolean estadoEsterilizacion = chkEsterilizado.isSelected();
                String runCliente = txtRunCliente.getText();

                mascotaControlador.agregarMascota(idMascota, nombreMascota, especie, fechaNacimiento, estadoEsterilizacion, runCliente);
                tableModel.addRow(new Object[]{idMascota, nombreMascota, especie, fechaNacimiento, estadoEsterilizacion, runCliente});
                clearFields();
            }
        });

        // Acción para actualizar mascota
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idMascota = txtIdMascota.getText();
                    String nombreMascota = txtNombreMascota.getText();
                    String especie = txtEspecie.getText();
                    String fechaNacimiento = txtFechaNacimiento.getText();
                    boolean estadoEsterilizacion = chkEsterilizado.isSelected();
                    String runCliente = txtRunCliente.getText();

                    mascotaControlador.actualizarMascota(idMascota, nombreMascota, especie, fechaNacimiento, estadoEsterilizacion, runCliente);

                    tableModel.setValueAt(idMascota, selectedRow, 0);
                    tableModel.setValueAt(nombreMascota, selectedRow, 1);
                    tableModel.setValueAt(especie, selectedRow, 2);
                    tableModel.setValueAt(fechaNacimiento, selectedRow, 3);
                    tableModel.setValueAt(estadoEsterilizacion, selectedRow, 4);
                    tableModel.setValueAt(runCliente, selectedRow, 5);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una mascota para actualizar.");
                }
            }
        });

        // Acción para eliminar mascota
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idMascota = (String) tableModel.getValueAt(selectedRow, 0);
                    mascotaControlador.eliminarMascota(idMascota);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una mascota para eliminar.");
                }
            }
        });

        // Acción para buscar mascota
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idMascota = txtIdMascota.getText();
                Mascota mascota = mascotaControlador.buscarMascotaPorId(idMascota);
                if (mascota != null) {
                    txtNombreMascota.setText(mascota.getNombreMascota());
                    txtEspecie.setText(mascota.getEspecie());
                    txtFechaNacimiento.setText(mascota.getFechaNacimiento());
                    chkEsterilizado.setSelected(mascota.isEstadoEsterilizacion());
                    txtRunCliente.setText(mascota.getRunCliente());
                } else {
                    JOptionPane.showMessageDialog(null, "Mascota no encontrada.");
                }
            }
        });

        // Acción para guardar mascotas en archivo
        btnSaveToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rutaArchivo = "mascotas.txt";
                List<String> lineas = mascotaControlador.obtenerMascotas().stream()
                        .map(mascota -> mascota.getIdMascota() + "," + mascota.getNombreMascota() + "," + mascota.getEspecie() + "," +
                                mascota.getFechaNacimiento() + "," + mascota.isEstadoEsterilizacion() + "," + mascota.getRunCliente())
                        .toList();
                FileUtil.reescribirArchivo(rutaArchivo, lineas);
                JOptionPane.showMessageDialog(null, "Datos guardados en el archivo " + rutaArchivo);
            }
        });

        // Acción para abrir archivo de mascotas
        btnOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rutaArchivo = "mascotas.txt";
                List<String> lineas = FileUtil.leerArchivo(rutaArchivo);
                mascotaControlador.eliminarTodasLasMascotas(); // Limpiar la lista existente

                tableModel.setRowCount(0); // Limpiar tabla

                for (String linea : lineas) {
                    String[] datos = linea.split(",");
                    if (datos.length == 6) {
                        String idMascota = datos[0];
                        String nombreMascota = datos[1];
                        String especie = datos[2];
                        String fechaNacimiento = datos[3];
                        boolean estadoEsterilizacion = Boolean.parseBoolean(datos[4]);
                        String runCliente = datos[5];

                        mascotaControlador.agregarMascota(idMascota, nombreMascota, especie, fechaNacimiento, estadoEsterilizacion, runCliente);
                        tableModel.addRow(new Object[]{idMascota, nombreMascota, especie, fechaNacimiento, estadoEsterilizacion, runCliente});
                    }
                }

                JOptionPane.showMessageDialog(null, "Datos cargados del archivo " + rutaArchivo);
            }
        });
    }

    private void clearFields() {
        txtIdMascota.setText("");
        txtNombreMascota.setText("");
        txtEspecie.setText("");
        txtFechaNacimiento.setText("");
        chkEsterilizado.setSelected(false);
        txtRunCliente.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MascotaGUI().setVisible(true);
            }
        });
    }
}
