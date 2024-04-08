package UImenu;

import Controllers.TiendaController;

import javax.swing.*;
import static UImenu.MenuClient.*;
import static UImenu.MenuCompra.showMenuCompra;
import static UImenu.MenuProduct.showMenuProduct;


public class PrincipalMenu {

    static TiendaController tienda = new TiendaController();

    static  public int tiendaForQuery;
    public static void startMenu(){

        //SE Selecciona la tienda a dministrar para reducir el numero de entradas visibles

        String selectionTienda = tienda.ElegirTiendaCompras();
        if (selectionTienda == null){
            return;
        }else {
            try {
                tiendaForQuery = Integer.parseInt(selectionTienda);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Only numbers are allowed");
                startMenu();
                //Menu recursivo en fallo
                return;
            }
        }


        //CREACION DEL PANEL
        JDialog.setDefaultLookAndFeelDecorated(true);
        //OPCIONES DEL MENU
        Object[] selectionValues = { "Product", "Client", "Boughts"};
        String initialSelection = "Product";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
        //COMPROTAMIENTO SEGUN SELECCION
        if (selection == "Product"){
            showMenuProduct();
        } else if (selection == "Client"){
            showMenuClient();
        }if (selection == "Boughts"){
            showMenuCompra();
        }
        else if (  selection == null) {
            return;
        }
    }



}
