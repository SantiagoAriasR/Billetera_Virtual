package models;

import java.time.LocalDate;
import java.util.UUID;
import App.App;

public class Transaccion {

    // Necesitamos usar el app para comunicarnos con la empresa desde el modelo
    Empresa empresa;

    // Atributos
    private String idTransaccion;
    private float monto;
    private LocalDate fecha;
    private Categoria categoria;

    // Contructor
    public Transaccion(float monto, LocalDate fecha, Categoria categoria) {
        this.empresa = App.getEmpresa();
        this.idTransaccion = generarIdUnico();
        this.monto = monto;
        this.fecha = fecha;
        this.categoria = categoria;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Funciones

    // Función para generar IdUnico Transaccion
    private String generarIdUnico() {
        String nuevoId;
        do {
            nuevoId = "PED-" + UUID.randomUUID();
        } while (idTransaccionExiste(nuevoId)); // Verificar que no exista
        return nuevoId;
    }

    // Función para verificar si el IdTransaccion existe
    private boolean idTransaccionExiste(String id) {
        boolean existe = false;
        for(Transaccion transaccion : empresa.getListaTransacciones()) {
            if (transaccion.getIdTransaccion().equals(id)) {
                return true;
            }
        }
        return existe;
    }
}
