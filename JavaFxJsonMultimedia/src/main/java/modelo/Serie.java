package modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Serie {

    private List<Episodio> listaEpisodios;
    private String titulo;
    private boolean visto;
    private int rating;

    public Serie(String titulo, int rating) {
        this.titulo = titulo;
        this.rating = rating;
        listaEpisodios =new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(titulo, serie.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

}
