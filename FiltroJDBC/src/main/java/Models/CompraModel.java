package Models;


import Entitys.Compra;
import Entitys.Producto;

import  static UImenu.PrincipalMenu.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static DBC.Conexion.*;

public class CompraModel implements IsCrudable<Compra>{




    @Override
    public List<Compra> getall() {
        openConnection();
        List<Compra> listAll = new ArrayList<>();
        try {
            String query = "SELECT *, compra.id_producto as idProducto  FROM compra INNER JOIN producto on compra.id_producto = producto.id_producto where producto.id_tienda = ?;";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, tiendaForQuery);
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                Producto tempProducto = new Producto();
                Compra objTemp = new Compra();
                objTemp.setIdCompra(resp.getInt("id_compra"));
                objTemp.setIdCliente(resp.getInt("id_cliente"));
                objTemp.setIdProducto(resp.getInt("idProducto"));
                objTemp.setCantidad(resp.getInt("cantidad"));
                objTemp.setFechaCompra(LocalDate.parse(resp.getString("fecha_compra")));

                tempProducto.setNombre(resp.getString("nombre_producto"));
                tempProducto.setIdTienda(resp.getInt("id_tienda"));
                tempProducto.setIdProducto(resp.getInt("idProducto"));
                tempProducto.setPrecio(resp.getDouble("precio"));
                tempProducto.setStock(resp.getInt("stock"));

                objTemp.setProducto(tempProducto);

                listAll.add(objTemp);
            }
            closeConnection();
            return listAll;
        }catch (Exception e){
            System.out.println("Error getting all Boughts" + e.getMessage());
            return null;
        }
    }

    @Override
    public Compra getOne(int id) {
        openConnection();
        Compra listAll = new Compra();
        try {
            String query = "SELECT *, compra.id_producto as idProducto FROM compra INNER JOIN producto on compra.id_producto = producto.id_producto where compra.id_compra = ?;";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                Producto tempProducto = new Producto();

                listAll.setIdCompra(resp.getInt("id_compra"));
                listAll.setIdCliente(resp.getInt("id_cliente"));
                listAll.setIdProducto(resp.getInt("idProducto"));
                listAll.setCantidad(resp.getInt("cantidad"));
                listAll.setFechaCompra(LocalDate.parse(resp.getString("fecha_compra")));

                tempProducto.setNombre(resp.getString("nombre_producto"));
                tempProducto.setIdTienda(resp.getInt("id_tienda"));
                tempProducto.setIdProducto(resp.getInt("idProducto"));
                tempProducto.setPrecio(resp.getDouble("precio"));
                tempProducto.setStock(resp.getInt("stock"));

                listAll.setProducto(tempProducto);
                ;
            }
            closeConnection();
            return listAll;
        }catch (Exception e){
            System.out.println("Error getting all Boughts" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE from compra WHERE compra.id_compra = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            boolean resp = pstm.execute();
            closeConnection();
            return resp;
        }catch (Exception e){
            System.out.println("Deleting one Client problem: line 87: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Compra registro) {
        /*INSERT INTO compra (id_cliente,id_producto,fecha_compra,cantidad)VALUES( ?, ?, ?, ?)*/
        openConnection();
        try{
            String query = "INSERT INTO compra (id_cliente,id_producto,fecha_compra,cantidad)VALUES( ?, ?, ?, ?)";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getIdCliente());
            pstm.setInt(2 , registro.getIdProducto());
            pstm.setString( 3, registro.getFechaCompra().toString());
            pstm.setInt(4, registro.getCantidad());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Error Inserting Bought : Model DB line 128" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateOne(Compra registro) {
        openConnection();
        try{
            String query = "UPDATE compra SET  id_cliente = ?, id_producto = ?, fecha_compra = ? , cantidad = ? WHERE id_compra = ?";
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, registro.getIdCliente());
            pstm.setInt(2 , registro.getIdProducto());
            pstm.setString( 3, registro.getFechaCompra().toString());
            pstm.setInt(4, registro.getCantidad());
            pstm.setInt(5, registro.getIdCompra());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println("Error Updating Bought : Model DB line 128" + e.getMessage());
            return false;
        }
    }
}
