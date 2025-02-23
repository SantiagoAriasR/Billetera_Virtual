package models;

import java.time.LocalDate;
import java.time.YearMonth;
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

    // Funciones
    //--------------------CRUD Transacciones----------------------//
    // Función para mostrar Saldo
    public void consultarSaldo(){
        System.out.println(saldo);
    }

    // Función para mostrar Transacciones de la cuenta
    public void consultarTrasacciones(){
        System.out.println(listaTransacciones);
    }

    // Función para realizar transaccion
    public boolean realizarTransaccion(float cantidad,Billetera destino){
        boolean centinela = false;
        if(cantidad >= saldo-200){
            destino.setSaldo(destino.getSaldo()+cantidad);
            saldo -= cantidad + 200;
            centinela = true;
        } else{
            System.out.println("Saldo insuficiente, su saldo actual es: " + getSaldo());
        }
        return centinela;
    }

    // Función para recargar la billetera
    public boolean recargarBilletera(float monto){
        boolean centinela = false;
        if(monto > 0){
            saldo += monto;
            centinela = true;
        }
        return centinela;
    }

    //---------------------------- Funciones funcionales----------------------------//
    // Función para obtener las transacciones en un tiempo determinado (Entre dos fechas)
    public LinkedList<Transaccion> obtenerTransaccionTiempoDeterminado(LocalDate fechaInicio, LocalDate fechaFin){
        LinkedList<Transaccion> transacciones = new LinkedList<>();
        if(fechaInicio.isBefore(fechaFin)) {
            for(Transaccion transaccion : listaTransacciones){
                if(transaccion.getFecha().toLocalDate().isBefore(fechaFin) && transaccion.getFecha().toLocalDate().isAfter(fechaInicio)){
                    transacciones.add(transaccion);
                }
            }
        }else{
            System.out.println("Se ingreso una fecha de inicio mayor a la fecha de fin");
        }
        return transacciones;
    }

    // Función para obtener las transacciones de un mes
    public LinkedList<Transaccion> obtenerTransaccionesMes(YearMonth fecha){
        LinkedList<Transaccion> transacciones = new LinkedList<>();
        for(Transaccion transaccion : listaTransacciones){
            YearMonth mes = YearMonth.from(transaccion.getFecha());
            if(mes.equals(fecha)){
                transacciones.add(transaccion);
            }
        }
        return transacciones;
    }

    // Función para calcular gastos de un mes
    public float calcularGastosMes(YearMonth fecha){
        LinkedList<Transaccion> transacciones = obtenerTransaccionesMes(fecha);
        float gastos = 0;
        for(Transaccion transaccion : transacciones){
            if(transaccion.getOrigen().equals(this)){
                gastos+= transaccion.getMonto();
            }
        }
        return gastos;
    }

    // Función para calcular ingresos de un mes
    public float calcularIngresosMes(YearMonth fecha){
        LinkedList<Transaccion> transacciones = obtenerTransaccionesMes(fecha);
        float ingresos = 0;
        for(Transaccion transaccion : transacciones){
            if(transaccion.getDestino().equals(this)){
                ingresos += transaccion.getMonto();
            }
        }
        return ingresos;
    }

    // Funcion para discriminar gastos por categoría
    public float calcularGastosCategoriaMes(YearMonth fecha, Categoria categoria){
        float gastos = 0;
        LinkedList<Transaccion> transacciones = obtenerTransaccionesMes(fecha);
        for (Transaccion transaccion : transacciones) {
            if(transaccion.getCategoria().equals(categoria) && transaccion.getOrigen().equals(this)){
                gastos += transaccion.getMonto();
            }
        }
        return gastos;
    }


    // Función para calcular porcentaje Gastos de un mes en especifico(Discriminado por categorias)
    public String calcularGastosCategoriaMes(YearMonth fecha){
        float total = calcularGastosMes(fecha) + calcularIngresosMes(fecha);
        float promedioGastosMes = (calcularGastosMes(fecha) / total) * 100;
        String consulta = "El porcentaje de gastos en el mes " + fecha + " es " + promedioGastosMes + " y corresponden a:\n";
        for (Categoria categoria : Categoria.values()) {
            float gastosCategoria = calcularGastosCategoriaMes(fecha, categoria);
            float porcentajeCategoria = (gastosCategoria/total)*100;
            consulta += "Los gastos por " + categoria +  " es de  " + gastosCategoria + " corresponde al: " + porcentajeCategoria + "%\n";
        }
        return consulta;
    }
    }




