package dominio;

import java.util.ArrayList;
import java.util.List;

public class Operacion {
    private int precioFinal;
    private List<Item> items;
    private Estado estado ;

    public Operacion(int precioFinal, List<Item> items, Estado estado) {
        this.precioFinal = precioFinal;
        this.items = items;
        this.estado = estado;
    }

    public int valor(){
        int total =  this.calcularPrecioTotal();
        this.precioFinal = total;
        return total;
    }
    private int calcularPrecioTotal() {
        return this.items.stream()
                .mapToInt(Item::getPrecio)
                .sum();
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



}
