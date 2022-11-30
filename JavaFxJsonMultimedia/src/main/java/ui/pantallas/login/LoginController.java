package ui.pantallas.login;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import lombok.extern.log4j.Log4j2;
import modelo.Cliente;
import ui.pantallas.common.BasePantallaController;

@Log4j2
public class LoginController extends BasePantallaController {

    private LoginViewModel loginViewModel;

    @FXML
    private MFXTextField nombre;
    @FXML
    private MFXTextField correo;


    @Inject
    public LoginController(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    public void initialize() {
        loginViewModel.getState().addListener((observableValue, oldState, newState) -> {
            if (newState.getError() != null) {
                this.getPrincipalController().sacarAlertError(newState.getError());
            }
            if (newState.isLoginOK()) {
                this.getPrincipalController().onLoginHecho(new Cliente(nombre.getText(), correo.getText()));
            }
        });
    }
    @FXML
    private void doRegistro() {
        Cliente cliente = new Cliente(nombre.getText(), correo.getText());
        loginViewModel.doRegistro(cliente);
    }
    @FXML
    private void doLogin() {
        Cliente cliente = new Cliente(nombre.getText(), correo.getText());
        loginViewModel.doLogin(cliente);
    }




}
