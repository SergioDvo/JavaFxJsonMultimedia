package servicios;

import dao.DaoClientes;
import dao.DaoPelis;
import jakarta.inject.Inject;
import modelo.Actor;
import modelo.Peli;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiciosPeli {

    private final DaoClientes daoClientes;
    private final DaoPelis daoPelis;

    @Inject
    public ServiciosPeli(DaoPelis daoPelis,DaoClientes daoClientes) {
        this.daoClientes = daoClientes;
        this.daoPelis = daoPelis;
    }
    public List<Peli> getPelis(){
        return daoPelis.listaPeli();
    }
    public List<Peli> filtrarPorRating(Integer rating){
        return daoPelis.listaPeli().stream()
                .sorted(Comparator.comparing(Peli::getRatingPeli))
                .filter(peli -> peli.getRatingPeli()>=rating)
                .collect(Collectors.toUnmodifiableList());

    }
    public List<Peli> filtrarPorActor(Actor actor){
        return daoPelis.listaPeli().stream()
                .filter(peli -> peli.getListaActores().contains(actor))
                .collect(Collectors.toUnmodifiableList());

    }
}
