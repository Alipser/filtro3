package Entitys;

public class Producto {

    private String nombre;
    private double precio;
    private int idTienda;

    private int idProducto;

    private Tienda tienda;

    private int Stock;



    public Producto() {
    }


    public Producto( int idProducto, String nombre, double precio, int idTienda,  int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.idTienda = idTienda;
        this.idProducto = idProducto;
        Stock = stock;
    }


    public Producto(String nombre, double precio, int idTienda, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.idTienda = idTienda;
        Stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    @Override
    public String toString() {
        String tiendaString = this.tienda != null ?  ", tienda=" + tienda.toString(): "";


        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", idTienda=" + idTienda +
                ", idProducto=" + idProducto +
                ", Stock=" + Stock +
                tiendaString +
                '}';
    }
}
