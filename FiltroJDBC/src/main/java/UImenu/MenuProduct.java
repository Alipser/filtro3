package UImenu;

import Controllers.ClienteController;
import Controllers.ProductoController;

import javax.swing.*;

import static UImenu.PrincipalMenu.startMenu;

public class MenuProduct {

//Metodo para iniciar el menu de productos
    public  static void showMenuProduct(){

        ProductoController respectiveController = new ProductoController();
        String opcionesMenu = " 1. Show All Products \n 2.Delete Products By Id. \n 3. Create Products. \n 4. Update Products . \n 5.Exit";
        int select = 0;
        //Validaciones
        try {
            while (select <1 || select >5 ){
                select = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesMenu));
                if(select <1 || select >5 ){
                    JOptionPane.showMessageDialog(null, "Please Enter a number between 1 and 5");
                }
            }
            switch (select){
                case 1:
                    respectiveController.getAll();
                    break;
                case 2:
                    respectiveController.delete();
                    break;
                case 3:
                    respectiveController.create();
                    break;
                case 4:
                    respectiveController.update();
                    break;
                case 5:
                    startMenu();
                    return;
            }
            showMenuProduct();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
           //Menu recursivo en fallo
            startMenu();
        }

    }
}
