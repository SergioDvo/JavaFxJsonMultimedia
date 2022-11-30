package modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Episodio {

    private String nombreEpisodio;
    private List<Actor> listaActores;

    public Episodio(String nombreEpisodio) {
        this.nombreEpisodio = nombreEpisodio;
        listaActores =new ArrayList<>();
    }
}
