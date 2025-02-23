package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import App.App;

public class Transaccion {
    // Atributos
    private String idTransaccion;
    private float monto;
    private LocalDateTime fecha;
    private Categoria categoria;
    private Billetera origen;
    private Billetera destino;

    // Contructor
    public Transaccion(float monto, LocalDateTime fecha, Categoria categoria, Billetera origen, Billetera destino) {
        this.idTransaccion = generarIdUnico();
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
        this.origen = origen;
        this.destino = destino;
    }

    // Getters y Setters
    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Billetera getOrigen() {
        return origen;
    }

    public void setOrigen(Billetera origen) {
        this.origen = origen;
    }

    public Billetera getDestino() {
        return destino;
    }

    public void setDestino(Billetera destino) {
        this.destino = destino;
    }

    // Funciones

    // Función para generar IdUnico Transaccion
    private String generarIdUnico() {
        String nuevoId;
        nuevoId = "TRA-" + UUID.randomUUID();
        return nuevoId;
    }
}
