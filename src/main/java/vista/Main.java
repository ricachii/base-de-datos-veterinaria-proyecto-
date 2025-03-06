package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main() {
        setTitle("Menú Principal - Gestión de la Clínica Veterinaria");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Definir el layout principal
        setLayout(new BorderLayout());

        // Panel de logo
        JPanel logoPanel = new JPanel();
        logoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Cargar el logo desde el classpath
        try {
            ImageIcon logoIcon = new ImageIcon(getClass().getClassLoader().getResource("logo.png"));
            if (logoIcon != null) {
                Image scaledImage = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
                logoPanel.add(logoLabel);
            } else {
                JLabel logoLabel = new JLabel("Logo no encontrado");
                logoPanel.add(logoLabel);
            }
        } catch (Exception e) {
            JLabel logoLabel = new JLabel("Error al cargar logo");
            logoPanel.add(logoLabel);
            e.printStackTrace();
        }

        add(logoPanel, BorderLayout.NORTH);

        // Panel de título
        JPanel titlePanel = new JPanel();
        JLabel lblTitle = new JLabel("Sistema de Gestión - Clínica Veterinaria Zoopolis");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(34, 139, 34));
        titlePanel.add(lblTitle);
        add(titlePanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 15, 15)); // Layout de rejilla para organizar los botones
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botón Gestión de Clientes
        JButton btnClientes = new JButton("Gestión de Clientes");
        btnClientes.setFont(new Font("Arial", Font.PLAIN, 16));
        btnClientes.setBackground(new Color(135, 206, 250));
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteGUI clienteGUI = new ClienteGUI();
                clienteGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnClientes);

        // Botón Gestión de Mascotas
        JButton btnMascotas = new JButton("Gestión de Mascotas");
        btnMascotas.setFont(new Font("Arial", Font.PLAIN, 16));
        btnMascotas.setBackground(new Color(135, 206, 250));
        btnMascotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MascotaGUI mascotaGUI = new MascotaGUI();
                mascotaGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnMascotas);

        // Botón Gestión de Citas
        JButton btnCitas = new JButton("Gestión de Citas");
        btnCitas.setFont(new Font("Arial", Font.PLAIN, 16));
        btnCitas.setBackground(new Color(135, 206, 250));
        btnCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CitaGUI citaGUI = new CitaGUI();
                citaGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnCitas);

        // Botón Gestión de Servicios
        JButton btnServicios = new JButton("Gestión de Servicios");
        btnServicios.setFont(new Font("Arial", Font.PLAIN, 16));
        btnServicios.setBackground(new Color(135, 206, 250));
        btnServicios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicioGUI servicioGUI = new ServicioGUI();
                servicioGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnServicios);

        // Botón Gestión de Diagnósticos
        JButton btnDiagnosticos = new JButton("Gestión de Diagnósticos");
        btnDiagnosticos.setFont(new Font("Arial", Font.PLAIN, 16));
        btnDiagnosticos.setBackground(new Color(135, 206, 250));
        btnDiagnosticos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiagnosticoGUI diagnosticoGUI = new DiagnosticoGUI();
                diagnosticoGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnDiagnosticos);

        // Botón Gestión de Especializaciones
        JButton btnEspecializaciones = new JButton("Gestión de Especializaciones");
        btnEspecializaciones.setFont(new Font("Arial", Font.PLAIN, 16));
        btnEspecializaciones.setBackground(new Color(135, 206, 250));
        btnEspecializaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EspecializacionGUI especializacionGUI = new EspecializacionGUI();
                especializacionGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnEspecializaciones);

        // Botón Gestión de Personal
        JButton btnPersonal = new JButton("Gestión de Personal");
        btnPersonal.setFont(new Font("Arial", Font.PLAIN, 16));
        btnPersonal.setBackground(new Color(135, 206, 250));
        btnPersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonalGUI personalGUI = new PersonalGUI();
                personalGUI.setVisible(true);
            }
        });
        buttonPanel.add(btnPersonal);

        add(buttonPanel, BorderLayout.SOUTH);

        // Ajustar el espacio para los componentes para asegurarse de que todos se muestran correctamente
        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // Panel de pie de página con información
        JPanel footerPanel = new JPanel();
        JLabel lblFooter = new JLabel("Seleccione una opción para continuar");
        lblFooter.setFont(new Font("Arial", Font.ITALIC, 14));
        lblFooter.setForeground(Color.GRAY);
        footerPanel.add(lblFooter);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}
