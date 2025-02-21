package models;

public class Billetera {
    // Atributos
    private String idUnico;
    private float saldo;

    // Constructor
    public Billetera(String idUnico, float saldo) {
        this.idUnico = idUnico;
        this.saldo = saldo;
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

    public String test(){
        String palabra = "hola";
        System.out.println(palabra);
        return palabra;
    }
}
