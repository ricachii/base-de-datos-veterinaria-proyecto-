package controlador;

import dao.ClienteDAO;
import modelo.Cliente;

import java.util.List;

public class ClienteControlador {
    private ClienteDAO clienteDAO;

    public ClienteControlador() {
        this.clienteDAO = new ClienteDAO();
    }

    // Métodos CRUD para interactuar con la vista
    public void agregarCliente(String run, String nombre, String telefono, String correo, String direccion) {
        Cliente nuevoCliente = new Cliente(run, nombre, telefono, correo, direccion);
        clienteDAO.agregarCliente(nuevoCliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    public Cliente buscarClientePorRun(String run) {
        return clienteDAO.buscarClientePorRun(run);
    }

    public void actualizarCliente(String run, String nombre, String telefono, String correo, String direccion) {
        Cliente clienteActualizado = new Cliente(run, nombre, telefono, correo, direccion);
        clienteDAO.actualizarCliente(clienteActualizado);
    }

    public void eliminarCliente(String run) {
        clienteDAO.eliminarCliente(run);
    }
}
