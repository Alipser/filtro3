package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Conexion {


    public static Connection dbConnection;
    public static PreparedStatement pstm;

    public Conexion() {
        dbConnection = null;
    }


    /**
     * El uso de esta función sera el poder crear la conexión con la BD.
     * */
    public static void openConnection(){
        if(dbConnection ==null){
            String user = "root";
            String password = "";
            String uriLike = "jdbc:mysql://127.0.0.1:3306/filtro";

          /*  String user = "usywfmijjp3lkvgq";
            String password = "usywfmijjp3lkvgq";
            String uriLike = "jdbc:mysql://usywfmijjp3lkvgq:p2zv6RQuIGwLSKSTIVH8@b8i2qjq8xcu0haxzhccg-mysql.services.clever-cloud.com:3306/b8i2qjq8xcu0haxzhccg";*/

            try{
                dbConnection = DriverManager.getConnection(uriLike, user, password);
                System.out.println("You has been Connected");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Already Connected");
        }

    }


    /**
     * El uso de esta función sera el poder cerrar la conexion a la base de datos, se hace necesario el hacer nula la db
     * connection debido a que no se pueden hacer peticiones a la base de datos una vez cerrada la conexion.
     * */
    public static void closeConnection(){
        try{
            if (dbConnection !=null){
                dbConnection.close();
                dbConnection = null;
                System.out.println("Connection to DB has been closed");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
