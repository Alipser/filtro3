package Models;

import Entitys.Producto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import  static UImenu.PrincipalMenu.*;

import static DBC.Conexion.*;

public class ProductoModel implements IsCrudable<Producto>{
    @Override
    public List<Producto> getall() {

        openConnection();
        List<Producto> listAll = new ArrayList<Producto>();
        try {
            String query = "Select * from producto where id_tienda = ?";
            String query2 = "Select * from producto";
            if (tiendaForQuery == 0){
                pstm = dbConnection.prepareStatement(query2);
            }else {
                pstm = dbConnection.prepareStatement(query);
                pstm.setInt(1, tiendaForQuery);
            }
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                Producto objTemp = new Producto();
                objTemp.setIdTienda(resp.getInt("id_tienda"));
                objTemp.setIdProducto(resp.getInt("id_producto"));
                objTemp.setNombre(resp.getString("nombre_producto"));
                objTemp.setPrecio(resp.getDouble("precio"));
                objTemp.setStock(resp.getInt("stock"));
                listAll.add(objTemp);
            }
            closeConnection();
            return listAll;
        }catch (Exception e){
            System.out.println("Error getting all products" + e.getMessage());
            return null;
        }
    }

    @Override
    public Producto getOne(int id) {

        openConnection();
        String query = "Select * from producto WHERE producto.id_producto = ?";


        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet resp = pstm.executeQuery();
            Producto objTemp = new Producto();
            while (resp.next()){
                objTemp.setIdTienda(resp.getInt("id_tienda"));
                objTemp.setIdProducto(resp.getInt("id_producto"));
                objTemp.setNombre(resp.getString("nombre_producto"));
                objTemp.setPrecio(resp.getDouble("precio"));
                objTemp.setStock(resp.getInt("stock"));
            }
            closeConnection();
            return objTemp;
        }catch (Exception e){
            System.out.println("getting one Product problem: line 70: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE from producto WHERE producto.id_producto = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean resp = pstm.execute();
            closeConnection();
            return resp;
        }catch (Exception e){
            System.out.println("Deleting one Product problem: line 87: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Producto registro) {
        openConnection();
        try{
        String query = "INSERT INTO producto(nombre_producto, precio, id_tienda, stock) VALUES( ?, ?, ?, ?)";
        pstm = dbConnection.prepareStatement(query);
        pstm.setString(1, registro.getNombre());
        pstm.setDouble(2 , registro.getPrecio());
        pstm.setInt( 3, registro.getIdTienda());
        pstm.setInt(4, registro.getStock());
        int rowAfected = pstm.executeUpdate();
        if(rowAfected>0){
            System.out.println("realizado " +  rowAfected);
            closeConnection();
            return true;
        }else {
            return false;
        }
        }catch (Exception e){
            System.out.println("Error Inserting Product : Model DB line 113" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateOne(Producto registro) {
        openConnection();
        String query = "UPDATE producto SET  nombre_producto = ?, precio = ?, id_tienda = ?, stock =? WHERE id_producto = ?;";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getNombre());
            pstm.setDouble(2 , registro.getPrecio());
            pstm.setInt( 3, registro.getIdTienda());
            pstm.setInt(4, registro.getStock());
            pstm.setInt(5, registro.getIdProducto());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Inserting Product : Model DB line 133" + e.getMessage());
            return false;
        }
    }
}
