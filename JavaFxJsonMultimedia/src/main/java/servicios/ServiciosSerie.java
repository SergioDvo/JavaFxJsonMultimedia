package servicios;

import dao.DaoClientes;
import dao.DaoSeries;
import jakarta.inject.Inject;
import modelo.Actor;
import modelo.Episodio;
import modelo.Peli;
import modelo.Serie;

import java.nio.channels.AcceptPendingException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ServiciosSerie {

    private final DaoClientes daoClientes;
    private final DaoSeries daoSerie;

    @Inject
    public ServiciosSerie(DaoSeries daoSeries, DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
        this.daoSerie = daoSeries;
    }
    public List<Serie> getSeries(){
        return daoSerie.listaSeries();
    }
    public boolean añadirSerie(Serie serie){
        if (daoSerie.listaSeries().contains(serie)){
            return false;
        }else{
            daoSerie.añadirSerie(serie);
            return true;
        }
    }
    public boolean añadirEpisodio(Serie serie, Episodio episodio){
        if (daoSerie.listaSeries().contains(serie)){
            daoSerie.añadirEpisodio(serie,episodio);
            return true;
        }else{
            return false;
        }
    }
    public boolean añadirActor(Episodio episodio, Actor actor){
        Episodio episodioEncontrado =daoSerie.listaSeries().stream()
                .flatMap(serie -> serie.getListaEpisodios().stream())
                .filter(episodio1 -> episodio1.equals(episodio))
                .findFirst().orElse(null);
        Serie serie = daoSerie.listaSeries().stream()
                .filter(serie1 -> serie1.getListaEpisodios().contains(episodio))
                .findFirst().orElse(null);
        if (episodioEncontrado!=null && serie !=null){
            daoSerie.añadirActor(serie,episodio,actor);
            return true;
        }else{
            return false;
        }
    }
    public List<Episodio> getEpisodios (Serie serie){
        return daoSerie.listaSeries().stream()
                .filter(serie1 -> serie1.equals(serie))
                .findFirst().orElse(null).getListaEpisodios();
    }
    public List<Actor> getActores (Episodio episodio){
        return episodio.getListaActores();
    }
    public List<Serie> filtrarPorRating(Integer rating){
        return daoSerie.listaSeries().stream()
                .sorted(Comparator.comparing(Serie::getRating))
                .filter(serie -> serie.getRating()>=rating)
                .collect(Collectors.toUnmodifiableList());

    }
//    public List<Serie> filtrarPorActor(Actor actor){
//        return daoSerie.listaSeries().stream().peek(serie -> serie.getListaEpisodios().stream().)
//    }


}
