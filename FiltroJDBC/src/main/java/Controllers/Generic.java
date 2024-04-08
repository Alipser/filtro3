package Controllers;

import Models.IsCrudable;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class Generic<model, entity>{


    private IsCrudable<entity> modelClass;


    public Generic(IsCrudable<entity> modelClass) {
        this.modelClass = modelClass;
    }

    public void setModelClass(IsCrudable<entity> modelClass) {
        this.modelClass = modelClass;
    }

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

    public void delete(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to Eliminate"));
        modelClass.delete(id);
        JOptionPane.showMessageDialog(null,"Eliminated Correctly");
    }

    public void getOneById(){
        this.getAll();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID to find"));
        entity finded = modelClass.getOne(id);
        JOptionPane.showMessageDialog(null, finded.toString());
    }

}
