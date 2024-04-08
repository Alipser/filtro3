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

        String selectionTienda = tienda.ElegirTiendaCompras();
        if (selectionTienda == null){
            return;
        }else {
            try {
                tiendaForQuery = Integer.parseInt(selectionTienda);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Only numbers are allowed");
                startMenu();
                return;
            }
        }

        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Product", "Client", "Boughts"};
        String initialSelection = "Product";
        Object selection = JOptionPane.showInputDialog(null, "Please, Select one option to Administrate",
                "Administration System", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        System.out.println(selection);
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
