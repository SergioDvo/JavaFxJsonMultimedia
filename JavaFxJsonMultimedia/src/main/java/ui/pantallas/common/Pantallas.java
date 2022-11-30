package ui.pantallas.common;

public enum Pantallas {

    PANTALLA1 ("/fxml/pantalla1.fxml"),
    LOGIN ("/fxml/login.fxml"),
    PANTALLAADMISTRARSERIE("/fxml/adminControl.fxml"),
    PANTALLAALISTAS("/fxml/listasCliente.fxml");



    private String ruta;
    Pantallas(String ruta) {
        this.ruta=ruta;
    }
    public String getRuta(){return ruta;}


}
