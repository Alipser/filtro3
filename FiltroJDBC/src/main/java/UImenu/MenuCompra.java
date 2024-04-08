package UImenu;


import Controllers.CompraController;

import javax.swing.*;

import static UImenu.PrincipalMenu.startMenu;



public class MenuCompra {

    //Menu para mostrar compras
    public  static void showMenuCompra(){

        CompraController respectiveController = new CompraController();
        String opcionesMenu = " 1. Show All Boughts \n 2.Delete Bought By Id. \n 3. Register Bought. \n 4. Update Bought . \n 5.Exit";
        int select = 0;

        //validacion de tipo y valor
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
            showMenuCompra();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
           //Menu recursivo en caso de fallo
            startMenu();
        }

    }
}
