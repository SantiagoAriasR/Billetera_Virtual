import models.Billetera;
import models.Categoria;
import models.Transaccion;
import models.Usuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class BilleteraTest {

    Usuario usuario = new Usuario("Santiago", "Calle 21", "123456", "santiago@gmail.com", "654321", true);
    Billetera billetera = new Billetera("001", 0, usuario);
    Transaccion transaccion = new Transaccion(1000, LocalDateTime.of(2025, 2,1,12,00), Categoria.ROPA, null, null);

    @Test
    public void agregarTransaccionTest() {
        assertTrue(billetera.agregarTransaccion(transaccion));
    }

    @Test
    public void realizarTransaccionTest(){
        Billetera billetera2 = new Billetera("002", 0, usuario);
        billetera.setSaldo(1200);
        float cantidad = 1000;
        Categoria categoria = Categoria.ROPA;
        Billetera destino = billetera2;
        boolean nuevaTransaccion = billetera.realizarTransaccion(cantidad, categoria, destino);
        for (Transaccion transaccion: billetera.getListaTransacciones()){
            Categoria categoriaTransaccion = transaccion.getCategoria();
            Billetera destinoTransaccion = transaccion.getDestino();
            assertEquals(categoria, categoriaTransaccion);
            assertEquals(destino, destinoTransaccion);
        }
        assertTrue(nuevaTransaccion);
        assertEquals(0, billetera.getSaldo());
        assertEquals(1000, billetera2.getSaldo());
    }

    @Test
    public void recargarBilleteraTest(){
        float monto = -1000;
        boolean recargar = billetera.recargarBilletera(monto);
        assertFalse(recargar);
    }

    @Test
    public void obtenerTransaccionesTest(){
        Transaccion transaccion2 = new Transaccion(1000, LocalDateTime.of(2025, 1,1,12,00), Categoria.ROPA, null, null);
        billetera.agregarTransaccion(transaccion);
        billetera.agregarTransaccion(transaccion2);
        YearMonth mes = YearMonth.now();
        LinkedList<Transaccion> transaccionesMeses = billetera.obtenerTransaccionesMes(mes);
        assertEquals(1, transaccionesMeses.size());
    }
}
