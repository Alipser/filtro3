package Models;

import Entitys.Cliente;
import Entitys.Producto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static DBC.Conexion.*;


public class ClienteModel implements IsCrudable<Cliente>{

    public List<Cliente> getall() {

        openConnection();
        List<Cliente> listAll = new ArrayList<>();
        try {

            String query = "Select * from cliente";
            pstm = dbConnection.prepareStatement(query);
            ResultSet resp = pstm.executeQuery();
            while (resp.next()){
                Cliente objTemp = new Cliente();
                objTemp.setIdCliente(resp.getInt("id_cliente"));
                objTemp.setNombreCliente(resp.getString("nombre"));
                objTemp.setApellidoCliente(resp.getString("apellido"));
                objTemp.setEmail(resp.getString("email"));
                listAll.add(objTemp);
            }
            closeConnection();
            return listAll;
        }catch (Exception e){
            System.out.println("Error getting all Clients" + e.getMessage());
            return null;
        }
    }

    @Override
    public Cliente getOne(int id) {

        openConnection();
        String query = "Select * from cliente WHERE cliente.id_cliente = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            ResultSet resp = pstm.executeQuery();
            Cliente objTemp = new Cliente();
            while (resp.next()){
                objTemp.setIdCliente(resp.getInt("id_cliente"));
                objTemp.setNombreCliente(resp.getString("nombre"));
                objTemp.setApellidoCliente(resp.getString("apellido"));
                objTemp.setEmail(resp.getString("email"));
            }
            closeConnection();
            return objTemp;
        }catch (Exception e){
            System.out.println("getting one Client problem: line 70: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        openConnection();
        String query = "DELETE from cliente WHERE cliente.id_cliente = ?";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setInt(1, id);
            boolean resp = pstm.execute();
            closeConnection();
            return resp;
        }catch (Exception e){
            System.out.println("Deleting one Client problem: line 87: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean insertOne(Cliente registro) {
        openConnection();
        try{
            String query = "INSERT INTO cliente(nombre, apellido, Email) VALUES( ?, ?, ?)";
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getNombreCliente());
            pstm.setString(2 , registro.getApellidoCliente());
            pstm.setString( 3, registro.getEmail());
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
    public boolean updateOne(Cliente registro) {
        openConnection();
        String query = "UPDATE cliente SET nombre = ?, apellido = ?, email = ? WHERE cliente.id_cliente = ?;";
        try{
            pstm = dbConnection.prepareStatement(query);
            pstm.setString(1, registro.getNombreCliente());
            pstm.setString(2 , registro.getApellidoCliente());
            pstm.setString( 3, registro.getEmail());
            pstm.setInt(4, registro.getIdCliente());
            int rowAfected = pstm.executeUpdate();
            if(rowAfected>0){
                System.out.println("realizado " +  rowAfected);
                closeConnection();
                return true;
            }else{
                throw new Exception("There is no nothing in DB to update");
            }
        }catch (Exception e){
            System.out.println("Error Inserting Client : Model DB line 121" + e.getMessage());
            return false;
        }
    }



}
