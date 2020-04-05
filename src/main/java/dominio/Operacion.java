package dominio;

import java.util.ArrayList;
import java.util.List;

public class Operacion {
    private int precioFinal;
    private List<Item> items;
    private Estado estado = Estado.ABIERTO;

    public Operacion(int precioFinal, List<Item> items, Estado estado) {
        this.precioFinal = precioFinal;
        this.items = items;
        this.estado = estado;
    }

    //public void valor(  );

}
