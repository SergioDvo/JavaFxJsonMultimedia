package modelo;

import lombok.Data;

@Data
public class Actor {

    private String nombre;

    public Actor(String nombre) {
        this.nombre = nombre;
    }
}
