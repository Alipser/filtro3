package Models;
import Entitys.Tienda;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static  DBC.Conexion.*;

public class TiendaModel {


    public  List<Tienda> getAll(){
        openConnection();
        List<Tienda> listTienda = new ArrayList<Tienda>();
        try {
            String query = "Select * from tienda";
            pstm = dbConnection.prepareStatement(query);
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                Tienda tiendaTemp = new Tienda();
                tiendaTemp.setIdTienda(resp.getInt("id_tienda"));
                tiendaTemp.setUbicaciion(resp.getString("ubicacion"));
                tiendaTemp.setNombreTeienda(resp.getString("nombre_tienda"));
                listTienda.add(tiendaTemp);
            }
            closeConnection();
            return listTienda;
        }catch (Exception e){
            System.out.println("Error getting tiendas" + e.getMessage());
            return null;
        }
    }


    public  Tienda getone(int id){
        openConnection();
        Tienda tiendilla = new Tienda();
        try {
            String query = "Select * from tienda where tienda.id_tienda = ?";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1,id );
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                tiendilla.setIdTienda(resp.getInt("id_tienda"));
                tiendilla.setUbicaciion(resp.getString("ubicacion"));
                tiendilla.setNombreTeienda(resp.getString("nombre_tienda"));
            }
            closeConnection();
            return tiendilla;
        }catch (Exception e){
            System.out.println("Error getting tiendas" + e.getMessage());
            return null;
        }
    }

}
