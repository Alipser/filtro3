package Controllers;

import Entitys.Cliente;
import Entitys.Compra;
import Entitys.Producto;
import Entitys.Tienda;
import Models.ClienteModel;
import Models.CompraModel;
import Models.ProductoModel;
import Models.TiendaModel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import static UImenu.PrincipalMenu.tiendaForQuery;
public class CompraController{

    TiendaModel tiendaModel = new TiendaModel();
    ClienteController clienteController = new ClienteController();

    ClienteModel clienteModel = new ClienteModel();
    ProductoController productoController = new ProductoController();
    ProductoModel productoModel = new ProductoModel();
    CompraModel respectiveModel = new CompraModel();

    Generic<CompraModel, Compra>  generico =  new Generic<>(respectiveModel);

    public void getAll(){
        generico.getAll();
    }

    public void delete(){
        generico.delete();
    }

    public  void getOneById(){
        generico.getOneById();
    }

    public void create(){

        //Recibir un id de producto

        productoController.getAll();
        int idProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter  Product Id "));
        Producto gettedProduct =  productoModel.getOne(idProducto);




        //Recibir un id de cliente
        clienteController.getAll();
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Cliente Id"));
        Cliente gettedClient = clienteModel.getOne(idCliente);



        JPanel panel = new JPanel(new GridLayout(5, 2)); // 5 filas y 1 columna
        JTextField cliente = new JTextField();
        JTextField producto = new JTextField();
        JTextField tienda = new JTextField();
        JTextField cantidad = new JTextField();

        panel.add(new JLabel("Cliente: "+ gettedClient.getNombreCliente() + gettedClient.getApellidoCliente() + "ID = "));
        panel.add(cliente);
        cliente.setText(String.valueOf(gettedClient.getIdCliente()));
        cliente.setEditable(false);
        panel.add(new JLabel("Product: " + gettedProduct.getNombre() + "ID: "));
        panel.add(producto);
        producto.setText(String.valueOf(gettedProduct.getIdProducto()));
        producto.setEditable(false);
        panel.add(new JLabel("Product id Shop"));
        panel.add(tienda);
        tienda.setText(String.valueOf(tiendaForQuery));
        tienda.setEditable(false);
        panel.add(new JLabel("Enter quantity to buy"));
        panel.add(cantidad);
        cantidad.setText(String.valueOf( gettedProduct.getStock()));

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Product's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String clienteString = cliente.getText();
            String productoString = producto.getText();;
            String tiendaString = tienda.getText();
            String cantidadString = cantidad.getText();
            Compra objCreado = new Compra(Integer.parseInt(clienteString), Integer.parseInt(productoString) , LocalDate.now(), Integer.parseInt(cantidadString));
            if(gettedProduct.getStock()>0 && Integer.parseInt(cantidadString) <= gettedProduct.getStock()){
                respectiveModel.insertOne(objCreado);
                JOptionPane.showMessageDialog(null, "Created Correctly");
                gettedProduct.setStock((gettedProduct.getStock() - Integer.parseInt(cantidadString)));
                productoModel.updateOne(gettedProduct);
                this.generarFactura(gettedProduct, gettedClient);
            }else if (gettedProduct.getStock() == 0){
                JOptionPane.showMessageDialog(null, "Tere is no prduct stock");

            }else{
                JOptionPane.showMessageDialog(null, "Only Quanitity less or equals to product stock allowed");
            }

        }

    }

    public void update(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Compra gettedObj = respectiveModel.getOne(id);


        clienteController.getAll();
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Cliente Id"));
        Cliente gettedClient = clienteModel.getOne(idCliente);

        Producto gettedProduct =  productoModel.getOne(gettedObj.getIdProducto());


        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField cliente = new JTextField();
        JTextField producto = new JTextField();
        JTextField tienda = new JTextField();
        JTextField cantidad = new JTextField();
        JTextField fecha =  new JTextField();

        panel.add(new JLabel("Cliente: "+ gettedClient.getNombreCliente() + gettedClient.getApellidoCliente() + "ID = "));
        panel.add(cliente);
        cliente.setText(String.valueOf(gettedClient.getIdCliente()));
        cliente.setEditable(false);
        panel.add(new JLabel("Product: " + gettedProduct.getNombre() + "ID: "));
        panel.add(producto);
        producto.setEditable(false);
        producto.setText(String.valueOf(gettedClient.getIdCliente()));
        producto.setEditable(false);
        panel.add(new JLabel("Product id Shop"));
        panel.add(tienda);
        tienda.setText(String.valueOf(tiendaForQuery));
        tienda.setEditable(false);
        panel.add(new JLabel("Enter quantity to modify"));
        panel.add(cantidad);
        cantidad.setText(String.valueOf( gettedProduct.getStock()));
        panel.add(new JLabel("Date yyyy-mm-dd"));
        panel.add(fecha);
        gettedObj.getFechaCompra().toString();
        fecha.setText(gettedObj.getFechaCompra().toString());

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String clienteString = cliente.getText();
            String productoString = producto.getText();;
            String tiendaString = tienda.getText();
            String cantidadString = cantidad.getText();
            String fechaString = fecha.getText();
            Compra objCreado = new Compra( Integer.parseInt(clienteString), Integer.parseInt(productoString) , LocalDate.parse(fechaString), Integer.parseInt(cantidadString), gettedObj.getIdCompra());
            respectiveModel.updateOne(objCreado);
            JOptionPane.showMessageDialog(null, "Inserted Correctly");
        }





    }

    public void generarFactura(Producto productillo, Cliente clientillo){

        Tienda tiendilla = tiendaModel.getone(tiendaForQuery);

        JPanel panel = new JPanel(new GridLayout(10, 2)); // 5 filas y 1 columna
        JTextField clienteNombre = new JTextField();
        JTextField clienteApellido = new JTextField();
        JTextField clienteEmail = new JTextField();
        JTextField productoNombre = new JTextField();
        JTextField productoPrecio = new JTextField();
        JTextField tiendaNombre= new JTextField();
        JTextField tiendaUbicacion = new JTextField();

        panel.add(new JLabel("Client Name: "));
        panel.add(clienteNombre);
        clienteNombre.setText(clientillo.getNombreCliente());
        clienteNombre.setEditable(false);
        panel.add(new JLabel("Client LastName: "));
        panel.add(clienteApellido);
        clienteApellido.setText(clientillo.getApellidoCliente());
        clienteApellido.setEditable(false);
        panel.add(new JLabel("Client Email: "));
        panel.add(clienteEmail);
        clienteEmail.setText(clientillo.getEmail());
        clienteEmail.setEditable(false);
        panel.add(new JLabel("Product : "));
        panel.add(productoNombre);
        productoNombre.setText(String.valueOf(productillo.getNombre()));
        productoNombre.setEditable(false);
        panel.add(new JLabel("Price"));
        panel.add(productoPrecio);
        productoPrecio.setText(String.valueOf(productillo.getPrecio() * 1.19));
        panel.add(new JLabel("Shop Name"));
        panel.add(tiendaNombre);
        tiendaNombre.setText(tiendilla.getNombreTeienda());
        tiendaNombre.setEditable(false);
        panel.add(new JLabel("Location"));
        panel.add(tiendaUbicacion);
        tiendaUbicacion.setText(tiendilla.getUbicaciion());

        JOptionPane.showConfirmDialog(null, panel, "Do you want to print Your Bill", JOptionPane.OK_CANCEL_OPTION);

    }



}
