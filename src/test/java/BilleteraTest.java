import models.Billetera;
import models.Categoria;
import models.Transaccion;
import models.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BilleteraTest {

    Usuario usuario = new Usuario("Santiago", "Calle 21", "123456", "santiago@gmail.com", "654321", true);
    Billetera billetera = new Billetera("001", 0, usuario);
    Transaccion transaccion = new Transaccion(1000, null, Categoria.ROPA, null, null);

    @Test
    public void agregarTransaccionTest() {
        assertTrue(billetera.agregarTransaccion(transaccion));
    }

    @Test
    public void realizarTransaccionTest(){
        float cantidad = 1000;
        Categoria categoria = Categoria.ROPA;
        Billetera destino = billetera;
        boolean transaccion = billetera.realizarTransaccion(cantidad, categoria, destino);
        assertTrue(transaccion);
    }

    @Test
    public void recargarBilleteraTest(){
        float monto = 1000;
        boolean recargar = billetera.recargarBilletera(monto);
        assertTrue(recargar);
    }
}
