package Entitys;

public class Tienda {

    private int idTienda;

    private String nombreTeienda;

    private String ubicaciion;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombreTeienda, String ubicaciion) {
        this.idTienda = idTienda;
        this.nombreTeienda = nombreTeienda;
        this.ubicaciion = ubicaciion;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTeienda() {
        return nombreTeienda;
    }

    public void setNombreTeienda(String nombreTeienda) {
        this.nombreTeienda = nombreTeienda;
    }

    public String getUbicaciion() {
        return ubicaciion;
    }

    public void setUbicaciion(String ubicaciion) {
        this.ubicaciion = ubicaciion;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "idTienda=" + idTienda +
                ", nombreTeienda='" + nombreTeienda + '\'' +
                ", ubicaciion='" + ubicaciion + '\'' +
                '}';
    }
}
