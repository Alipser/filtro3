package Controllers;

import Entitys.Cliente;
import Entitys.Producto;
import Models.ClienteModel;

import javax.swing.*;
import java.awt.*;


public class ClienteController {

    ClienteModel respectiveModel = new ClienteModel();

    Generic<ClienteModel, Cliente>  generico =  new Generic<>(respectiveModel);

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
        JTextField apellido = new JTextField();
        JTextField email = new JTextField();


        panel.add(new JLabel("Name: "));
        panel.add(nombre);
        panel.add(new JLabel("Lastname"));
        panel.add(apellido);
        panel.add(new JLabel("Email"));
        panel.add(email);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Client's Data", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String apellidoString = apellido.getText();;
            String emailString = email.getText();
            Cliente objCreado = new Cliente(nombreString, apellidoString , emailString );
            respectiveModel.insertOne(objCreado);
            JOptionPane.showMessageDialog(null, "Created Correctly");
        }

    }

    public void update(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        Cliente gettedObj = respectiveModel.getOne(id);

        JPanel panel = new JPanel(new GridLayout(5, 1)); // 5 filas y 1 columna
        JTextField nombre = new JTextField();
        JTextField apellido = new JTextField();
        JTextField email = new JTextField();


        panel.add(new JLabel("Name: "));
        panel.add(nombre);
        nombre.setText(gettedObj.getNombreCliente());
        panel.add(new JLabel("Lastname"));
        panel.add(apellido);
        apellido.setText(gettedObj.getApellidoCliente());
        panel.add(new JLabel("Email"));
        panel.add(email);
        email.setText(gettedObj.getEmail());

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter Airplane's Data", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String nombreString = nombre.getText();
            String apellidoString = apellido.getText();;
            String emailString = email.getText();
            Cliente objCreado = new Cliente( gettedObj.getIdCliente(), nombreString, apellidoString , emailString );
            respectiveModel.updateOne(objCreado);
            JOptionPane.showMessageDialog(null, "Inserted Correctly");
        }





    }


}
