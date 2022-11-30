package ui.pantallas.listasCliente;


import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Actor;
import modelo.Peli;
import modelo.Serie;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ListasClienteController extends BasePantallaController implements Initializable {

    private ListasViewModel listasViewModel;
    @FXML
    private TableView<Serie> tablaSerie;
    @FXML
    private TableColumn<Serie,String> nombreSerieColum;
    @FXML
    private TableColumn<Serie,Integer> ratingSerieColum;
    @FXML
    private TableView<Peli> tablaPeli;
    @FXML
    private TableColumn<Peli,String> tituloPeliColum;
    @FXML
    private TableColumn<Peli,Integer> ratingPeliColum;
    @FXML
    private TableColumn<Peli, LocalDate> fechaPeliColum;
    @FXML
    private TextField txtFiltrar;


    @Inject
    public ListasClienteController(ListasViewModel listasViewModel){
        this.listasViewModel=listasViewModel;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombreSerieColum.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        ratingSerieColum.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tituloPeliColum.setCellValueFactory(new PropertyValueFactory<>("tituloPeli"));
        ratingPeliColum.setCellValueFactory(new PropertyValueFactory<>("ratingPeli"));
        fechaPeliColum.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tablaSerie.setItems(listasViewModel.getSeries());
        tablaPeli.setItems(listasViewModel.getPelis());
    }
    public void filtrarPorRating(){
        if (!txtFiltrar.getText().isBlank()) {
            if (Integer.parseInt(txtFiltrar.getText())>0 && Integer.parseInt(txtFiltrar.getText())<10) {
                listasViewModel.filtrarPorRating(Integer.parseInt(txtFiltrar.getText()));
            }
        }
    }
    public void filtrarPorActor(){
        if(!txtFiltrar.getText().isBlank()){
            Actor actor =new Actor(txtFiltrar.getText());
            listasViewModel.filtrarPorActor(actor);
        }
    }
    public void quitarFiltros(){
        listasViewModel.getListasOriginales();
    }
}
