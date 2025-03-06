package vista;

import controlador.CitaControlador;
import modelo.Cita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CitaGUI extends JFrame {
    private CitaControlador citaControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtIdCita, txtFecha, txtHora, txtRunCliente, txtIdMascota;

    public CitaGUI() {
        citaControlador = new CitaControlador();
        setTitle("Gestión de Citas");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID Cita:"));
        txtIdCita = new JTextField();
        inputPanel.add(txtIdCita);

        inputPanel.add(new JLabel("Fecha (yyyy-MM-dd):"));
        txtFecha = new JTextField();
        inputPanel.add(txtFecha);

        inputPanel.add(new JLabel("Hora (HH:mm):"));
        txtHora = new JTextField();
        inputPanel.add(txtHora);

        inputPanel.add(new JLabel("RUN Cliente:"));
        txtRunCliente = new JTextField();
        inputPanel.add(txtRunCliente);

        inputPanel.add(new JLabel("ID Mascota:"));
        txtIdMascota = new JTextField();
        inputPanel.add(txtIdMascota);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar las citas
        tableModel = new DefaultTableModel(new String[]{"ID Cita", "Fecha", "Hora", "RUN Cliente", "ID Mascota"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnSearch = new JButton("Buscar");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);

        add(buttonPanel, BorderLayout.SOUTH);

        // Acción para agregar cita
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCita = txtIdCita.getText();
                String fecha = txtFecha.getText();
                String hora = txtHora.getText();
                String runCliente = txtRunCliente.getText();
                String idMascota = txtIdMascota.getText();

                citaControlador.agregarCita(idCita, fecha, hora, runCliente, idMascota);
                tableModel.addRow(new Object[]{idCita, fecha, hora, runCliente, idMascota});
                clearFields();
            }
        });

        // Acción para actualizar cita
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idCita = txtIdCita.getText();
                    String fecha = txtFecha.getText();
                    String hora = txtHora.getText();
                    String runCliente = txtRunCliente.getText();
                    String idMascota = txtIdMascota.getText();

                    citaControlador.actualizarCita(idCita, fecha, hora, runCliente, idMascota);

                    tableModel.setValueAt(idCita, selectedRow, 0);
                    tableModel.setValueAt(fecha, selectedRow, 1);
                    tableModel.setValueAt(hora, selectedRow, 2);
                    tableModel.setValueAt(runCliente, selectedRow, 3);
                    tableModel.setValueAt(idMascota, selectedRow, 4);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una cita para actualizar.");
                }
            }
        });

        // Acción para eliminar cita
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idCita = (String) tableModel.getValueAt(selectedRow, 0);
                    citaControlador.eliminarCita(idCita);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una cita para eliminar.");
                }
            }
        });

        // Acción para buscar cita
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idCita = txtIdCita.getText();
                Cita cita = citaControlador.buscarCitaPorId(idCita);
                if (cita != null) {
                    txtFecha.setText(cita.getFecha());
                    txtHora.setText(cita.getHora());
                    txtRunCliente.setText(cita.getRunCliente());
                    txtIdMascota.setText(cita.getIdMascota());
                } else {
                    JOptionPane.showMessageDialog(null, "Cita no encontrada.");
                }
            }
        });
    }

    private void clearFields() {
        txtIdCita.setText("");
        txtFecha.setText("");
        txtHora.setText("");
        txtRunCliente.setText("");
        txtIdMascota.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CitaGUI().setVisible(true);
            }
        });
    }
}
