package Controllers;

import Models.IsCrudable;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;




/**
 * Essta clase generica funciona como un BoilerPlate para la creación de controladores Recibe como parametros de tipo una entidad y una clase modelo
 * */
public class Generic<model, entity>{


    private IsCrudable<entity> modelClass;

    /**
     * En su construción recibe una clase de tipo modelo, Tenga en cuenta que el Type param model es solo para generar claridad en el codigo
     *  */
    public Generic(IsCrudable<entity> modelClass) {
        this.modelClass = modelClass;
    }

    public void setModelClass(IsCrudable<entity> modelClass) {
        this.modelClass = modelClass;
    }

    /**
     * Metodo get generico de controladores recorre una lista de objetos Entity genera un array y lo muestra en un joption
     * */
    public void getAll(){


        StringBuilder stringShow = new StringBuilder();

        List<entity> listFetch =  modelClass.getall();
        if (listFetch != null && !listFetch.isEmpty()){
            stringShow = new StringBuilder( modelClass.getClass() + " List:  \n");
            for (entity temp: listFetch){

                stringShow.append(temp.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null,stringShow);
        }else {
            stringShow.append("There are no").append(modelClass.getClass()).append("to show");
            JOptionPane.showMessageDialog(null,stringShow);
        }

    }


    /**
     * Metodo delete genrico de los controladores toma un Id y borra en base de datos
     * */
    public void delete(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to Eliminate"));
        modelClass.delete(id);
        JOptionPane.showMessageDialog(null,"Eliminated Correctly");
    }


    /**
     * Metodo get por id genrico de los controladores toma un Id y obtiene un dato del tipo Entity
     * */
    public void getOneById(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        entity finded = modelClass.getOne(id);
        JOptionPane.showMessageDialog(null, finded.toString());
    }

}
