package Controllers;

import Entitys.Tienda;
import Models.TiendaModel;

import javax.swing.*;
import java.util.List;

public class TiendaController {

    public  static int selectedTienda = 0;
    TiendaModel tiendaModel = new TiendaModel();

    public  String ElegirTiendaCompras(){
        StringBuilder stringShow = new StringBuilder();

        List<Tienda> listFetch = tiendaModel.getAll();
        if (listFetch != null && !listFetch.isEmpty()){
            stringShow = new StringBuilder( tiendaModel.getClass() + " List:  \n");
            for (Tienda temp: listFetch){
                stringShow.append(temp.toString()).append("\n");
            }
            String selection =  JOptionPane.showInputDialog(null,stringShow);
            System.out.println(selection);
            return selection;
        }else {
            stringShow.append("There are no").append(tiendaModel.getClass()).append("to show");
            JOptionPane.showMessageDialog(null,stringShow);
            return null;
        }
    };

}
