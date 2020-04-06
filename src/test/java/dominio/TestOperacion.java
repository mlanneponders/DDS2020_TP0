package dominio;

import dominio.exception.*;
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
    @Test
    public void testValorOperacion() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.agregarItem(luz);

        Assert.assertEquals(1200+90+700,operacionDeEgreso.valorOperacion(),0.1);
    }
    @Test
    public void testValorOperacion2() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.quitarItem(impresora);

        Assert.assertEquals(0,operacionDeEgreso.valorOperacion(),0.1);
    }
    @Test
    public void testOperacionCerrada() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.cerrarOperacion();
        Assert.assertEquals(operacionDeEgreso.getEstado(),Estado.CERRADA);

    }
    @Test (expected = OperacionCerradaException.class)
    public void testAgregarItemOperacionCerrada() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.cerrarOperacion();
        operacionDeEgreso.agregarItem(luz);

    }
    @Test
    public void testCambiaPrecioDeArticulo()throws Exception{
        operacionDeEgreso.agregarItem(impresora);
        Assert.assertEquals(1200,operacionDeEgreso.valorOperacion(),0.1);
        impresora.setPrecio(2000);
        Assert.assertEquals(2000,operacionDeEgreso.valorOperacion(),0.1);
    }
    @Test
    public void testCambiaPrecioDeArticuloOperacionCerrada()throws Exception{
        operacionDeEgreso.agregarItem(cuaderno);
        operacionDeEgreso.cerrarOperacion();
        Assert.assertEquals(90,operacionDeEgreso.valorOperacion(),0.1);
        cuaderno.setPrecio(120);
        Assert.assertEquals(90,operacionDeEgreso.valorOperacion(),0.1);
    }
    @Test
    public void testOperacionDeCompra() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(cuaderno);
        Assert.assertEquals(Documento.REMITO,operacionDeEgreso.compra());
    }
    @Test (expected = OperacionDeCompraNoGeneraRemito.class)
    public void testOperacionDeCompraNoGeneraRemito() throws Exception {
        operacionDeEgreso.agregarItem(impresora);
        operacionDeEgreso.agregarItem(luz);
        operacionDeEgreso.compra();
    }

}
