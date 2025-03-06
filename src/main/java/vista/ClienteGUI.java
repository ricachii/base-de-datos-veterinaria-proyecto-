package vista;

import controlador.ClienteControlador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteGUI extends JFrame {
    private ClienteControlador clienteControlador;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtRun, txtNombre, txtTelefono, txtCorreo, txtDireccion;

    public ClienteGUI() {
        clienteControlador = new ClienteControlador();
        setTitle("Gestión de Clientes");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // Panel de entrada de datos
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("RUN:"));
        txtRun = new JTextField();
        inputPanel.add(txtRun);

        inputPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        inputPanel.add(txtNombre);

        inputPanel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        inputPanel.add(txtTelefono);

        inputPanel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        inputPanel.add(txtCorreo);

        inputPanel.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        inputPanel.add(txtDireccion);

        add(inputPanel, BorderLayout.NORTH);

        // Tabla para mostrar los clientes
        tableModel = new DefaultTableModel(new String[]{"RUN", "Nombre", "Teléfono", "Correo", "Dirección"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnSearch = new JButton("Buscar");
        JButton btnBack = new JButton("Volver Atrás");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnBack);

        add(buttonPanel, BorderLayout.SOUTH);

        // Acción para el botón "Volver Atrás"
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana actual y vuelve al menú principal
                dispose();
                new Main().setVisible(true);
            }
        });

        // Acción para agregar cliente
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String run = txtRun.getText();
                String nombre = txtNombre.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String direccion = txtDireccion.getText();

                clienteControlador.agregarCliente(run, nombre, telefono, correo, direccion);
                tableModel.addRow(new Object[]{run, nombre, telefono, correo, direccion});
                clearFields();
            }
        });

        // Resto de acciones para actualizar, eliminar y buscar...
        // (Mantén el resto del código igual para actualizar, eliminar y buscar clientes)
    }

    private void clearFields() {
        txtRun.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteGUI().setVisible(true);
            }
        });
    }
}
