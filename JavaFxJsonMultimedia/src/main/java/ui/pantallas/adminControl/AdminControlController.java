package ui.pantallas.adminControl;

import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Actor;
import modelo.Episodio;
import modelo.Peli;
import modelo.Serie;
import ui.pantallas.common.BasePantallaController;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminControlController extends BasePantallaController implements Initializable {


    AdminControlViewModel adminControlViewModel;
    @FXML
    private MFXTextField txtnombreSerie;
    @FXML
    private MFXTextField txtratingSerie;
    @FXML
    private MFXTextField txtNombreEpisodio;
    @FXML
    private MFXTextField txtnombreActor;
    @FXML
    private TableView<Serie> tablaSerie;
    @FXML
    private TableColumn<Serie,String> nombreSerieColum;
    @FXML
    private TableColumn<Serie,Integer> ratingSerieColum;
    @FXML
    private TableView<Episodio> tablaEpisodio;
    @FXML
    private TableColumn<Serie,String> nombreEpisodioColum;
    @FXML
    private TableView<Actor> tablaActor;
    @FXML
    private TableColumn<Actor,String> nombreActorColum;

    @Inject
    public AdminControlController(AdminControlViewModel adminControlViewModel) {
        this.adminControlViewModel = adminControlViewModel;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombreSerieColum.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        ratingSerieColum.setCellValueFactory(new PropertyValueFactory<>("rating"));
        nombreActorColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreEpisodioColum.setCellValueFactory(new PropertyValueFactory<>("nombreEpisodio"));
        tablaSerie.setItems(adminControlViewModel.getSeries());
        tablaEpisodio.setItems(adminControlViewModel.getEpisodios());
        tablaActor.setItems(adminControlViewModel.getActores());
        adminControlViewModel.getState().addListener((observableValue, oldState, newState) -> {
            if (newState.getError() != null) {
                this.getPrincipalController().sacarAlertError(newState.getError());
            }
            if (newState.isSeleccionOK()) {
                this.getPrincipalController().sacarAlertOkay("Se realizo con exitooo");
            }
        });
    }
    public void añadirSerie(){
        if (!txtnombreSerie.getText().isBlank() && !txtratingSerie.getText().isBlank()){
            Serie serie = new Serie(txtnombreSerie.getText(), ((Integer.parseInt(txtratingSerie.getText()))));
            adminControlViewModel.añadirSerie(serie);
            tablaSerie.getItems().addAll(adminControlViewModel.getSeries());
        }else
            this.getPrincipalController().sacarAlertError("No añadido");
    }
    public void añadirEpisodio(){
        Serie serie = tablaSerie.getSelectionModel().getSelectedItem();
        if (serie!=null && !txtNombreEpisodio.getText().isBlank()){
            Episodio episodio = new Episodio(txtNombreEpisodio.getText());
            adminControlViewModel.añadirEpisodio(serie,episodio);
        }else
            this.getPrincipalController().sacarAlertError("No añadido");

    }
    public void añadirActor(){
        Episodio episodio = tablaEpisodio.getSelectionModel().getSelectedItem();
        if (episodio!=null && !txtnombreActor.getText().isBlank()){
            Actor actor = new Actor(txtnombreActor.getText());
            adminControlViewModel.añadirActor(episodio,actor);
        }else
            this.getPrincipalController().sacarAlertError("No añadido");

    }
    public void getListaEpisodios(){
        Serie serie =tablaSerie.getSelectionModel().getSelectedItem();
        adminControlViewModel.getEpisodios(serie);
    }
    public void getListaActores(){
        Episodio episodio =tablaEpisodio.getSelectionModel().getSelectedItem();
        adminControlViewModel.getActor(episodio);
    }


}
