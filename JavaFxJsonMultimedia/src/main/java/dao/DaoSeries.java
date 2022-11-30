package dao;

import jakarta.inject.Inject;
import modelo.Actor;
import modelo.Episodio;
import modelo.Peli;
import modelo.Serie;

import java.util.List;

public class DaoSeries {

    private final DataBase bd;

    @Inject
    public DaoSeries(DataBase bd) {
        this.bd = bd;
    }

    public List<Serie> listaSeries(){
        return bd.loadSeries();
    }
    public void añadirSerie (Serie serie){
        List<Serie> serieList = bd.loadSeries();
        serieList.add(serie);
        bd.saveSeries(serieList);
    }
    public void añadirEpisodio(Serie serie, Episodio episodio){
        List<Serie> serieList = bd.loadSeries();
        serieList.stream().filter(serie1 -> serie1.equals(serie)).findFirst().orElse(null)
                .getListaEpisodios().add(episodio);
        bd.saveSeries(serieList);
    }
    public void añadirActor(Serie serie, Episodio episodio, Actor actor){
        List<Serie> serieList = bd.loadSeries();
        serieList.stream().filter(serie1 -> serie1.equals(serie)).findFirst().orElse(null)
                .getListaEpisodios().stream().filter(episodio1 -> episodio.equals(episodio1)).findFirst().orElse(null)
                .getListaActores().add(actor);
        bd.saveSeries(serieList);
    }

}
