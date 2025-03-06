package vista;

import controlador.ServicioControlador;
import modelo.Servicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicioGUI extends JFrame {
    private ServicioControlador servicioControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtIdServicio, txtNombreServicio, txtValorServicio;

    public ServicioGUI() {
        servicioControlador = new ServicioControlador();
        setTitle("Gestión de Servicios");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("ID Servicio:"));
        txtIdServicio = new JTextField();
        inputPanel.add(txtIdServicio);

        inputPanel.add(new JLabel("Nombre Servicio:"));
        txtNombreServicio = new JTextField();
        inputPanel.add(txtNombreServicio);

        inputPanel.add(new JLabel("Valor Servicio:"));
        txtValorServicio = new JTextField();
        inputPanel.add(txtValorServicio);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar los servicios
        tableModel = new DefaultTableModel(new String[]{"ID Servicio", "Nombre Servicio", "Valor Servicio"}, 0);
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

        // Acción para agregar servicio
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idServicio = txtIdServicio.getText();
                String nombreServicio = txtNombreServicio.getText();
                double valorServicio = Double.parseDouble(txtValorServicio.getText());

                servicioControlador.agregarServicio(idServicio, nombreServicio, valorServicio);
                tableModel.addRow(new Object[]{idServicio, nombreServicio, valorServicio});
                clearFields();
            }
        });

        // Acción para actualizar servicio
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idServicio = txtIdServicio.getText();
                    String nombreServicio = txtNombreServicio.getText();
                    double valorServicio = Double.parseDouble(txtValorServicio.getText());

                    servicioControlador.actualizarServicio(idServicio, nombreServicio, valorServicio);

                    tableModel.setValueAt(idServicio, selectedRow, 0);
                    tableModel.setValueAt(nombreServicio, selectedRow, 1);
                    tableModel.setValueAt(valorServicio, selectedRow, 2);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un servicio para actualizar.");
                }
            }
        });

        // Acción para eliminar servicio
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idServicio = (String) tableModel.getValueAt(selectedRow, 0);
                    servicioControlador.eliminarServicio(idServicio);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un servicio para eliminar.");
                }
            }
        });

        // Acción para buscar servicio
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idServicio = txtIdServicio.getText();
                Servicio servicio = servicioControlador.buscarServicioPorId(idServicio);
                if (servicio != null) {
                    txtNombreServicio.setText(servicio.getNombreServicio());
                    txtValorServicio.setText(String.valueOf(servicio.getValorServicio()));
                } else {
                    JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
                }
            }
        });
    }

    private void clearFields() {
        txtIdServicio.setText("");
        txtNombreServicio.setText("");
        txtValorServicio.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServicioGUI().setVisible(true);
            }
        });
    }
}
