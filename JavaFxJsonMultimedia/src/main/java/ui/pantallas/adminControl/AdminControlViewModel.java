package ui.pantallas.adminControl;

import jakarta.inject.Inject;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Actor;
import modelo.Episodio;
import modelo.Peli;
import modelo.Serie;
import servicios.ServiciosPeli;
import servicios.ServiciosSerie;

import java.util.List;

public class AdminControlViewModel {

    private final ServiciosSerie serviciosSerie;
    private final ObservableList<Serie> listaSerie;
    private final ObservableList<Episodio> listaEpisodios;
    private final ObservableList<Actor> listaActores;
    private final ObjectProperty<AdminControlState> state;

    @Inject
    public AdminControlViewModel(ServiciosSerie serviciosSerie){
        this.serviciosSerie= serviciosSerie;
        listaSerie =FXCollections.observableArrayList();
        listaSerie.addAll(serviciosSerie.getSeries());
        listaEpisodios =FXCollections.observableArrayList();
        listaActores =FXCollections.observableArrayList();
        state = new SimpleObjectProperty<>(new AdminControlState(false, null));
    }
    public ReadOnlyObjectProperty<AdminControlState> getState() {
        return state;
    }

    public ObservableList<Serie> getSeries(){
        return listaSerie;
    }
    public ObservableList<Episodio> getEpisodios(){
        return listaEpisodios;
    }
    public ObservableList<Actor> getActores(){
        return listaActores;
    }
    public void añadirSerie(Serie serie){
        if (serviciosSerie.añadirSerie(serie)){
            listaSerie.clear();
            listaSerie.addAll(serviciosSerie.getSeries());
            state.setValue(new AdminControlState(true, null));
        }else{
            state.setValue(new AdminControlState(true, "La serie no se pudo añadir"));
        }
    }
    public void añadirEpisodio(Serie serie, Episodio episodio){
        if (serviciosSerie.añadirEpisodio(serie,episodio)){
            serie.getListaEpisodios().add(episodio);
            listaEpisodios.clear();
            listaEpisodios.addAll(serviciosSerie.getEpisodios(serie));
            state.setValue(new AdminControlState(true, null));
        }else{
            state.setValue(new AdminControlState(true, "La serie no se pudo añadir"));
        }
    }
    public void añadirActor(Episodio episodio, Actor actor){
        if (serviciosSerie.añadirActor(episodio,actor)){
            state.setValue(new AdminControlState(true, null));
            episodio.getListaActores().add(actor);
            listaActores.clear();
            listaActores.addAll(serviciosSerie.getActores(episodio));
        }else{
            state.setValue(new AdminControlState(true, "La serie no se pudo añadir"));
        }
    }
    public List<Episodio> getEpisodios(Serie serie){
        listaEpisodios.clear();
         listaEpisodios.addAll(serviciosSerie.getEpisodios(serie));
         return listaEpisodios;
    }
    public List<Actor> getActor(Episodio episodio){
        listaActores.clear();
        listaActores.addAll(serviciosSerie.getActores(episodio));
        return listaActores;
    }
}
