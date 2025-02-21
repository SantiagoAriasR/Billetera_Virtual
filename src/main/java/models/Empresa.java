package models;

import java.util.LinkedList;

public class Empresa {
    // Atributos 
    private String nombre;
    private LinkedList<Transaccion> listaTransacciones;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        listaTransacciones = new LinkedList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
}
