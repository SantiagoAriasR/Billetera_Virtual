import models.Billetera;
import models.Empresa;
import models.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {

    Empresa empresa = new Empresa("Banco");
    Usuario usuario = new Usuario("Santiago", "Calle 21", "123456", "santiago@gmail.com", "654321", true);

    @Test
    public void agregarUsuarioTest(){
        boolean registroUsuario = empresa.agregarUsuario(usuario);
        assertTrue(registroUsuario);
    }

    @Test
    public void actualizarUsuarioTest(){
        empresa.agregarUsuario(usuario);
        String idUsuario = "123456";
        Usuario usuarioActualizado = new Usuario("Santiago", "Calle 21", "7890", "santiago@hotmail.com", "654321", true);
        boolean ingresoDatos = empresa.actualizarUsuario(idUsuario, usuarioActualizado);
        assertTrue(ingresoDatos);
    }

    @Test
    public void eliminarUsuarioTest(){
        empresa.agregarUsuario(usuario);
        String idUsuario = "123456";
        boolean eliminacionDatos = empresa.eliminarUsuario(idUsuario);
        assertTrue(eliminacionDatos);
    }

    @Test
    public void validacionDeNoReusoCodigoBilletera(){

        //Se genera un codigo aleatorio
        boolean creacionCodigo = empresa.crearBilletera(usuario);
        //Se busca el codigo recien creado
        for (Billetera billetera : empresa.getListaBilleteras()){
            String mismoCodigo = billetera.getIdUnico();
            //Se compara el codigo recien generado con el mismo, esperando un true indicando que encontro similitud exacta
            boolean validacion1 = empresa.validarIdUnicoBilletera(mismoCodigo);
            assertTrue(validacion1);
        }
        //Se verifica que cuando dos codigos no son iguales, se espera un false
        String nuevoCodigo = empresa.crearIdUnicoBilletera();
        boolean validacion2 = empresa.validarIdUnicoBilletera(nuevoCodigo);
        assertFalse(validacion2);
    }
}
