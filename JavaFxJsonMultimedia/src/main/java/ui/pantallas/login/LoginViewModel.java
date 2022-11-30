package ui.pantallas.login;

import jakarta.inject.Inject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import modelo.Cliente;
import servicios.ServiciosClientes;

public class LoginViewModel {


    private final ServiciosClientes serviciosClientes;

    @Inject
    public LoginViewModel(ServiciosClientes serviciosClientes) {
        this.serviciosClientes = serviciosClientes;
        state = new SimpleObjectProperty<>(new LoginState(false,null));
    }
    private final ObjectProperty<LoginState> state;
    public ReadOnlyObjectProperty<LoginState> getState() {
        return state;
    }


    public void doRegistro(Cliente cliente) {
        if (serviciosClientes.doRegistro(cliente))
        {
            state.setValue(new LoginState(true,null));
        }
        else
        {
            state.setValue(new LoginState(false,"ese correo ya esta registrado, use otro:)"));
        }
    }
    public void doLogin(Cliente cliente) {
        if (serviciosClientes.doLogin(cliente))
        {
            state.setValue(new LoginState(true,null));
        }
        else
        {
            state.setValue(new LoginState(false,"ese correo no esta registrado, use otro:)"));
        }
    }
}
