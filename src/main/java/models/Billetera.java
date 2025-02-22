package models;

import java.util.LinkedList;

public class Billetera {
    // Atributos
    private String idUnico;
    private float saldo;
    private LinkedList<Transaccion> listaTransacciones;
    private Usuario usuario;

    // Constructor
    public Billetera(String idUnico, float saldo, Usuario usuario) {
        this.idUnico = idUnico;
        this.saldo = saldo;
        this.usuario = usuario;
        listaTransacciones = new LinkedList<>();
    }

    // Getters y Setters
    public String getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
