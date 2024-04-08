package Entitys;

import java.time.LocalDate;

public class Compra {

    private Producto producto;

    private Cliente cliente;

    private int IdCliente;

    private int idProducto;

    private LocalDate fechaCompra;

    private int cantidad;

    private int idCompra;

    public Compra() {
    }

    public Compra(int idCliente, int idProducto, LocalDate fechaCompra, int cantidad, int idCompra) {
        IdCliente = idCliente;
        this.idProducto = idProducto;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.idCompra = idCompra;
    }


    public Compra(int idCliente, int idProducto, LocalDate fechaCompra, int cantidad) {
        IdCliente = idCliente;
        this.idProducto = idProducto;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public String toString() {
        String productoString = this.producto != null ?  "producto=" + producto.toString(): "";
        String clientetoString = this.cliente != null ?   ", cliente=" + cliente.toString(): "";

        return "Compra{" +
                "idCompra=" + idCompra +
                ", IdCliente=" + IdCliente +
                ", idProducto=" + idProducto +
                ", fechaCompra=" + fechaCompra +
                ", cantidad=" + cantidad +
                productoString + clientetoString +
                '}';
    }
}
