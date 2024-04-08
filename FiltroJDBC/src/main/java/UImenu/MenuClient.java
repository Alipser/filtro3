package UImenu;

import Controllers.ClienteController;

import javax.swing.*;
import static UImenu.PrincipalMenu.*;

public class MenuClient {

    //Metodo para mostrar el menu de los clientes
    public  static void showMenuClient(){

        ClienteController respectiveController = new ClienteController();
        String opcionesMenu = " 1. Show All Clientss \n 2.Delete Client By Id. \n 3. Create Client. \n 4. Update Client . \n 5.Exit";
        //Seleccion y validacion de opciones
        int select = 0;
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
            showMenuClient();
        }catch (Exception e){
            System.out.println((Integer) select);
            JOptionPane.showMessageDialog(null, "Only number characters are allowed" + e.getMessage());
            //menu recursivo en fallo
            startMenu();
        }

    }

}
