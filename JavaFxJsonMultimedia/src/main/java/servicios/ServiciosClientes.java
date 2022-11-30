package servicios;

import dao.DaoClientes;
import jakarta.inject.Inject;
import modelo.Cliente;


public class ServiciosClientes {

    private final DaoClientes daoClientes;

    @Inject
    public ServiciosClientes(DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
    }

    public boolean doRegistro(Cliente cliente) {
        if (!daoClientes.getClientes().containsKey(cliente.getEmail())) {
            daoClientes.addCliente(cliente);
            return true;
        } else
            return false;
    }

    public boolean doLogin(Cliente cliente) {
        return daoClientes.getClientes().containsKey(cliente.getEmail());
    }


}
