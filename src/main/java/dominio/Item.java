package dominio;

public class Item {
    int precio;
    TipoItem tipo;

    public Item(int precio, TipoItem tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}
