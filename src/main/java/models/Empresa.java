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

    // Funciones
    //---------------------------------------CRUD Usuario-----------------------------//
    // Función agregar Usuario
    public boolean agregarUsuario(Usuario usuario) {
        boolean centinela = false;
        if (!idUsuarioExiste(usuario.getNumeroIdentificacion())){
            listaUsuarios.add(usuario);
            centinela = true;
            return centinela;
        }
        return centinela;
    }

    // Verificar si un ID ya existe
    private boolean idUsuarioExiste(String id) {
        boolean existe = false;
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    // Función para eliminar Usuario
    public boolean eliminarUsuario(String id) {
        boolean centinela = false;
        for(Usuario usuario : listaUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(id)) {
                listaUsuarios.remove(usuario);
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // Función para Actualizar Usuario
    public boolean actualizarUsuario(String id, Usuario actualizado){
        boolean centinela = false;
        for(Usuario usuario : listaUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(id)) {
                usuario.setNombre(actualizado.getNombre());
                usuario.setContrasena(actualizado.getContrasena());
                usuario.setCorreo(actualizado.getCorreo());
                usuario.setDireccion(actualizado.getDireccion());
                usuario.setEstado(actualizado.isEstado());
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // Función para obtener usuario
    public Usuario obtenerUsuario(String id){
        Usuario centinela = null;
        for(Usuario usuario : listaUsuarios) {
            if(usuario.getNumeroIdentificacion().equals(id)) {
                centinela = usuario;
                break;
            }
        }
        return centinela;
    }

    //-------------------CRUD Billetera--------------------------//
    // Función para validar que el Id no exista
    public boolean validarIdUnicoBilletera(String id){
        boolean centinela = false;
        for(Billetera billetera : listaBilleteras) {
            if (billetera.getIdUnico().equals(id)) {
                centinela = true;
                break;
            }
        }
        return centinela;
    }

    // Función para crear Id de 10 digitos aleatorios
    public String crearIdUnicoBilletera(){
        String idUnico = "";
        do {
            for (int i = 0; i < 10; i++) {
                int numeroAleatorio = (int) (Math.random() * 10);
                idUnico += numeroAleatorio;
            }
        } while (validarIdUnicoBilletera(idUnico));
        return idUnico;
    }

    // Función para crear una Billetera Virtual
    public boolean crearBilletera(Usuario usuario) {
        boolean centinela = false;
        Billetera billeteraNueva = new Billetera(crearIdUnicoBilletera(), 0, usuario);
        listaBilleteras.add(billeteraNueva);
        centinela = true;
        return centinela;
    }

    // Función obtener Billetera
    public String obtenerBilletera(String usuario, String contrasena){
        String consulta = "No se encontro ninguna billetera con esta información de inicio";
        for(Billetera billetera : listaBilleteras) {
            if (billetera.getUsuario().getNumeroIdentificacion().equals(usuario) && billetera.getUsuario().getContrasena().equals(contrasena)){
                consulta = "El saldo actual es de: " + billetera.getSaldo() + "\n" + "Las transacciones realizadas son: " + billetera.getListaTransacciones();
                break;
            }
        }
        return consulta;
    }
}
