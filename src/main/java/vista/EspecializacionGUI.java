package vista;

import controlador.EspecializacionControlador;
import modelo.Especializacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspecializacionGUI extends JFrame {
    private EspecializacionControlador especializacionControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtIdEspecializacion, txtNombreEspecializacion;

    public EspecializacionGUI() {
        especializacionControlador = new EspecializacionControlador();
        setTitle("Gestión de Especializaciones");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("ID Especialización:"));
        txtIdEspecializacion = new JTextField();
        inputPanel.add(txtIdEspecializacion);

        inputPanel.add(new JLabel("Nombre Especialización:"));
        txtNombreEspecializacion = new JTextField();
        inputPanel.add(txtNombreEspecializacion);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar las especializaciones
        tableModel = new DefaultTableModel(new String[]{"ID Especialización", "Nombre Especialización"}, 0);
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

        // Acción para agregar especialización
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idEspecializacion = txtIdEspecializacion.getText();
                String nombreEspecializacion = txtNombreEspecializacion.getText();

                especializacionControlador.agregarEspecializacion(idEspecializacion, nombreEspecializacion);
                tableModel.addRow(new Object[]{idEspecializacion, nombreEspecializacion});
                clearFields();
            }
        });

        // Acción para actualizar especialización
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idEspecializacion = txtIdEspecializacion.getText();
                    String nombreEspecializacion = txtNombreEspecializacion.getText();

                    especializacionControlador.actualizarEspecializacion(idEspecializacion, nombreEspecializacion);

                    tableModel.setValueAt(idEspecializacion, selectedRow, 0);
                    tableModel.setValueAt(nombreEspecializacion, selectedRow, 1);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una especialización para actualizar.");
                }
            }
        });

        // Acción para eliminar especialización
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String idEspecializacion = (String) tableModel.getValueAt(selectedRow, 0);
                    especializacionControlador.eliminarEspecializacion(idEspecializacion);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una especialización para eliminar.");
                }
            }
        });

        // Acción para buscar especialización
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idEspecializacion = txtIdEspecializacion.getText();
                Especializacion especializacion = especializacionControlador.buscarEspecializacionPorId(idEspecializacion);
                if (especializacion != null) {
                    txtNombreEspecializacion.setText(especializacion.getNombreEspecializacion());
                } else {
                    JOptionPane.showMessageDialog(null, "Especialización no encontrada.");
                }
            }
        });
    }

    private void clearFields() {
        txtIdEspecializacion.setText("");
        txtNombreEspecializacion.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EspecializacionGUI().setVisible(true);
            }
        });
    }
}
