package ui.pantallas.listasCliente;

import jakarta.inject.Inject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Actor;
import modelo.Peli;
import modelo.Serie;
import servicios.ServiciosPeli;
import servicios.ServiciosSerie;

import java.util.List;

public class ListasViewModel {

    private final ServiciosPeli serviciosPeli;
    private final ServiciosSerie serviciosSerie;
    private final ObservableList<Peli> listaPelis;
    private final ObservableList<Serie> listaSeries;

    @Inject
    public ListasViewModel(ServiciosSerie serviciosSerie,ServiciosPeli serviciosPeli){
        this.serviciosPeli =serviciosPeli;
        this.serviciosSerie =serviciosSerie;
        listaSeries = FXCollections.observableArrayList();
        listaSeries.addAll(serviciosSerie.getSeries());
        listaPelis = FXCollections.observableArrayList();
        listaPelis.addAll(serviciosPeli.getPelis());
    }
    public void getListasOriginales(){
        listaSeries.clear();
        listaPelis.clear();
        listaSeries.addAll(serviciosSerie.getSeries());
        listaPelis.addAll(serviciosPeli.getPelis());
    }
    public ObservableList<Serie> getSeries(){
        return listaSeries;
    }
    public ObservableList<Peli> getPelis(){
        return listaPelis;
    }
    public void filtrarPorRating(Integer rating){
        listaSeries.clear();
        listaPelis.clear();
        listaSeries.addAll(serviciosSerie.filtrarPorRating(rating));
        listaPelis.addAll(serviciosPeli.filtrarPorRating(rating));
    }
    public void filtrarPorActor(Actor actor){
        listaSeries.clear();
        listaPelis.clear();
//        listaSeries.addAll(serviciosSerie.filtrarPorActor(actor));
        listaPelis.addAll(serviciosPeli.filtrarPorActor(actor));
    }


}
