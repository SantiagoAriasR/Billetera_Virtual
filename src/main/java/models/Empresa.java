package models;

import java.util.LinkedList;

public class Empresa {
    // Atributos 
    private String nombre;
    private LinkedList<Usuario> listaUsuarios;
    private LinkedList<Billetera> listaBilleteras;

    // Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        listaUsuarios = new LinkedList<>();
        listaBilleteras = new LinkedList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(LinkedList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public LinkedList<Billetera> getListaBilleteras() {
        return listaBilleteras;
    }

    public void setListaBilleteras(LinkedList<Billetera> listaBilleteras) {
        this.listaBilleteras = listaBilleteras;
    }
}
