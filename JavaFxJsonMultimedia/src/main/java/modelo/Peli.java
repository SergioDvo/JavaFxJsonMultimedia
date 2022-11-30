package modelo;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Peli {

    private List<Actor> listaActores;
    private LocalDate fecha;
    private String tituloPeli;
    private int ratingPeli;

}
