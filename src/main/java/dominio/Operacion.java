package dominio;

import dominio.exception.OperacionCerradaException;

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

    public int valorOperacion(){
        if (this.estaAbierta()){
            precioFinal = this.calcularPrecioTotal();
        }
            return precioFinal;

    }
    private int calcularPrecioTotal() {
        return this.items.stream()
                .mapToInt(Item::getPrecio)
                .sum();
    }

    public void agregarItem(Item item) throws OperacionCerradaException {
        if (this.estaCerrada()){
            throw new OperacionCerradaException("Operacion Cerrada, no se puede agregar items.");
        }
        this.items.add(item);
    }

    private boolean estaCerrada() {
        return estado == Estado.CERRADA;
    }

    private boolean estaAbierta() {
        return estado == Estado.ABIERTA;
    }

    public void cerrarOperacion(){
        estado = Estado.CERRADA;
    }

    public void quitarItem(Item item){
        this.items.remove(item);
    }

    //Getters & Setter
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
