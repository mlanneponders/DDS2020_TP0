package dominio;

public class Item {
    int precio;
    tipoItem tipo;

    public Item(int precio, tipoItem tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public tipoItem getTipo() {
        return tipo;
    }

    public void setTipo(tipoItem tipo) {
        this.tipo = tipo;
    }
}
