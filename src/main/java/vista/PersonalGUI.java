package vista;

import controlador.PersonalControlador;
import modelo.Personal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalGUI extends JFrame {
    private PersonalControlador personalControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtRunPersonal, txtNombrePersonal, txtCargo;

    public PersonalGUI() {
        personalControlador = new PersonalControlador();
        setTitle("Gestión de Personal");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("RUN Personal:"));
        txtRunPersonal = new JTextField();
        inputPanel.add(txtRunPersonal);

        inputPanel.add(new JLabel("Nombre Personal:"));
        txtNombrePersonal = new JTextField();
        inputPanel.add(txtNombrePersonal);

        inputPanel.add(new JLabel("Cargo: (Médico Veterinario / Auxiliar Veterinario)"));
        txtCargo = new JTextField();
        inputPanel.add(txtCargo);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar al personal
        tableModel = new DefaultTableModel(new String[]{"RUN Personal", "Nombre Personal", "Cargo"}, 0);
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

        // Acción para agregar personal
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String runPersonal = txtRunPersonal.getText();
                String nombrePersonal = txtNombrePersonal.getText();
                String cargo = txtCargo.getText();

                personalControlador.agregarPersonal(runPersonal, nombrePersonal, cargo);
                tableModel.addRow(new Object[]{runPersonal, nombrePersonal, cargo});
                clearFields();
            }
        });

        // Acción para actualizar personal
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String runPersonal = txtRunPersonal.getText();
                    String nombrePersonal = txtNombrePersonal.getText();
                    String cargo = txtCargo.getText();

                    personalControlador.actualizarPersonal(runPersonal, nombrePersonal, cargo);

                    tableModel.setValueAt(runPersonal, selectedRow, 0);
                    tableModel.setValueAt(nombrePersonal, selectedRow, 1);
                    tableModel.setValueAt(cargo, selectedRow, 2);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un miembro del personal para actualizar.");
                }
            }
        });

        // Acción para eliminar personal
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    String runPersonal = (String) tableModel.getValueAt(selectedRow, 0);
                    personalControlador.eliminarPersonal(runPersonal);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un miembro del personal para eliminar.");
                }
            }
        });

        // Acción para buscar personal
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String runPersonal = txtRunPersonal.getText();
                Personal personal = personalControlador.buscarPersonalPorRun(runPersonal);
                if (personal != null) {
                    txtNombrePersonal.setText(personal.getNombrePersonal());
                    txtCargo.setText(personal.getCargo());
                } else {
                    JOptionPane.showMessageDialog(null, "Personal no encontrado.");
                }
            }
        });
    }

    private void clearFields() {
        txtRunPersonal.setText("");
        txtNombrePersonal.setText("");
        txtCargo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonalGUI().setVisible(true);
            }
        });
    }
}
