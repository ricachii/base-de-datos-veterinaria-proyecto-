package dao;

import modelo.Cliente;
import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static final String RUTA_ARCHIVO = "clientes.txt";

    // Create
    public void agregarCliente(Cliente cliente) {
        String linea = cliente.getRun() + "," + cliente.getNombre() + "," + cliente.getTelefono() + "," +
                cliente.getCorreo() + "," + cliente.getDireccion();
        FileUtil.escribirLinea(RUTA_ARCHIVO, linea);
    }

    // Read
    public List<Cliente> obtenerClientes() {
        List<String> lineas = FileUtil.leerArchivo(RUTA_ARCHIVO);
        List<Cliente> clientes = new ArrayList<>();

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes.length == 5) {
                String run = partes[0];
                String nombre = partes[1];
                String telefono = partes[2];
                String correo = partes[3];
                String direccion = partes[4];
                clientes.add(new Cliente(run, nombre, telefono, correo, direccion));
            }
        }
        return clientes;
    }

    // Update
    public void actualizarCliente(Cliente clienteActualizado) {
        List<String> lineas = FileUtil.leerArchivo(RUTA_ARCHIVO);
        List<String> nuevasLineas = new ArrayList<>();

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes[0].equals(clienteActualizado.getRun())) {
                String nuevaLinea = clienteActualizado.getRun() + "," + clienteActualizado.getNombre() + "," +
                        clienteActualizado.getTelefono() + "," + clienteActualizado.getCorreo() + "," +
                        clienteActualizado.getDireccion();
                nuevasLineas.add(nuevaLinea);
            } else {
                nuevasLineas.add(linea);
            }
        }

        FileUtil.reescribirArchivo(RUTA_ARCHIVO, nuevasLineas);
    }

    // Delete
    public void eliminarCliente(String run) {
        List<String> lineas = FileUtil.leerArchivo(RUTA_ARCHIVO);
        List<String> nuevasLineas = new ArrayList<>();

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (!partes[0].equals(run)) {
                nuevasLineas.add(linea);
            }
        }

        FileUtil.reescribirArchivo(RUTA_ARCHIVO, nuevasLineas);
    }

    // Buscar Cliente por RUN
    public Cliente buscarClientePorRun(String run) {
        List<String> lineas = FileUtil.leerArchivo(RUTA_ARCHIVO);

        for (String linea : lineas) {
            String[] partes = linea.split(",");
            if (partes[0].equals(run)) {
                String nombre = partes[1];
                String telefono = partes[2];
                String correo = partes[3];
                String direccion = partes[4];
                return new Cliente(run, nombre, telefono, correo, direccion);
            }
        }
        return null;
    }
}
