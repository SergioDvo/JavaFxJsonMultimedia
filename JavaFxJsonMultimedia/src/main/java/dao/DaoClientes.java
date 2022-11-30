package dao;

import jakarta.inject.Inject;
import modelo.Cliente;
import java.util.Map;

public class DaoClientes {
    private final DataBase bd;

    @Inject
    public DaoClientes(DataBase bd) {
        this.bd = bd;
    }

    public Map<String,Cliente> getClientes() {
        return bd.loadClientes();
    }

    public void addCliente(Cliente cliente) {
        Map<String,Cliente> clientes = bd.loadClientes();
        clientes.put(cliente.getEmail(), cliente);
        bd.saveClientes(clientes);
    }




}
