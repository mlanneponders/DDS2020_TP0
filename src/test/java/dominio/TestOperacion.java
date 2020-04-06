package dominio;

import dominio.exception.OperacionCerradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestOperacion {
    Item impresora;
    Item cuaderno;
    Item luz;
    Operacion operacionDeEgreso;
    List<Item> items;

    @Before
    public void init() {
        items = new ArrayList<>();
        impresora = new Item(1200, TipoItem.ARTICULO);
        cuaderno = new Item(90, TipoItem.ARTICULO);
        luz = new Item(700,TipoItem.SERVICIO);
        operacionDeEgreso = new Operacion(0,items,Estado.ABIERTA);

    }
    @Test (expected = OperacionCerradaException.class)
    public void testAgregarItemOperacionCerrada() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.cerrarOperacion();
    }

    @Test
    public void testValorOperacion() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.agregarItem(luz);

        Assert.assertEquals(1200+90+700,operacionDeEgreso.valorOperacion());
    }
}
