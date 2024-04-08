package Controllers;

import Entitys.Producto;
import Models.ProductoModel;

import javax.swing.*;
import java.awt.*;

public class ProductoController {

    ProductoModel respectiveModel = new ProductoModel();

    Generic<ProductoModel, Producto>  generico =  new Generic<>(respectiveModel);

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
        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField nombre = new JTextField();
        JTextField precio = new JTextField();
        JTextField tienda = new JTextField();
        JTextField stock = new JTextField();

        panel.add(new JLabel("Product Name: "));
        panel.add(nombre);
        panel.add(new JLabel("Product Price"));
        panel.add(precio);
        panel.add(new JLabel("Enter id Shop"));
        panel.add(tienda);
        panel.add(new JLabel("Enter new Stock product"));
        panel.add(stock);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Product's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String precioString = precio.getText();;
            String tiendaString = tienda.getText();
            String stockString = stock.getText();
            Producto objCreado = new Producto(nombreString, Double.parseDouble(precioString), Integer.parseInt(tiendaString), Integer.parseInt(stockString) );
            respectiveModel.insertOne(objCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }

    public void update(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Producto gettedObj = respectiveModel.getOne(id);

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField nombre = new JTextField();
        JTextField precio = new JTextField();
        JTextField tienda = new JTextField();
        JTextField stock = new JTextField();

        panel.add(new JLabel("Product Name: "));
        panel.add(nombre);
        nombre.setText(gettedObj.getNombre());
        panel.add(new JLabel("Product Price"));
        panel.add(precio);
        precio.setText( String.valueOf(gettedObj.getPrecio()));
        panel.add(new JLabel("Enter id Shop"));
        panel.add(tienda);
        tienda.setText(String.valueOf(gettedObj.getIdTienda()));
        panel.add(new JLabel("Enter new Stock product"));
        panel.add(stock);
        stock.setText(String.valueOf(gettedObj.getStock()));

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String precioString = precio.getText();;
            String tiendaString = tienda.getText();
            String stockString = stock.getText();
            Producto objCreado = new Producto( gettedObj.getIdProducto(),nombreString, Double.parseDouble(precioString), Integer.parseInt(tiendaString), Integer.parseInt(stockString) );
            respectiveModel.updateOne(objCreado);
            JOptionPane.showMessageDialog(null, "Inserted Correctly");
        }





    }

}
