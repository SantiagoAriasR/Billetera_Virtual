package models;

public class Usuario {
    // Atributos
    private String nombre;
    private String direccion;
    private String numeroIdentificacion;
    private String correo;
    private String contrasena;
    
    // Contructor
    public Usuario(String nombre, String direccion, String numeroIdentificacion, String correo, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}
