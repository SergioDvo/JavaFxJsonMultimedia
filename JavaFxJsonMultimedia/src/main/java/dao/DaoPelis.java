package dao;

import jakarta.inject.Inject;
import modelo.Peli;

import java.util.List;

public class DaoPelis {

    private final DataBase bd;

    @Inject
    public DaoPelis(DataBase bd) {
        this.bd = bd;
    }

    public List<Peli> listaPeli(){
        return bd.loadPelis();
    }
}
