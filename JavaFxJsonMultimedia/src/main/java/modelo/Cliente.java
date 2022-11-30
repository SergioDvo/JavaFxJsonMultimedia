package modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private String nombre;
    private String email;
    private List<Serie> listaSerie;
    private List<Peli> listaPeli;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        listaPeli =new ArrayList<>();
        listaSerie =new ArrayList<>();
    }
}
