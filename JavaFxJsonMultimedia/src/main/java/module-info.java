module Nutflux {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires jakarta.cdi;
    requires jakarta.inject;
    requires lombok;

//    exports dao;
//    exports servicios.Impl;
    exports modelo;
    exports DI;
    exports ui.main to javafx.graphics;
    exports ui.pantallas.principal;
    exports ui.pantallas.common;
    exports config;
    exports dao;
    exports servicios;
    exports ui.pantallas.adminControl;
    exports ui.pantallas.login;
    exports ui.pantallas.pantalla1;
    exports ui.pantallas.listasCliente;

//    opens ui.pantallas.pantalla1 to javafx.fxml;
  //  opens ui.pantallas.pantallaNueva to javafx.fxml;
   // opens ui.pantallas.login to javafx.fxml;
    opens ui.pantallas.principal;
    opens ui.main;
    opens modelo to javafx.base,com.google.gson,javafx.fxml;
    opens config;
    opens ui.pantallas.login;
    opens ui.pantallas.adminControl;
    opens ui.pantallas.pantalla1;
    opens ui.pantallas.listasCliente;


    //opens css;

//    opens imagenes;
//    opens ui.pantallas.AnadirProducto to javafx.fxml;
//    opens ui.pantallas.AdministrarClientes to javafx.fxml;
//    opens ui.pantallas.Carrito to javafx.fxml;
//    opens ui.pantallas.Compras to javafx.fxml;
//    opens ui.pantallas.HistorialComprasAntiguas to javafx.fxml;
}
