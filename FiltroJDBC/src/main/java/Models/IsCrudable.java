package Models;

import java.util.List;

//INTERFAZ GENERICA Recibe un paarametro Tpara evitar casteos en los controladores

public interface IsCrudable<T>{

    public List<T> getall();

    public T getOne(int id);

    public  boolean delete(int id);

    public boolean insertOne(T registro);
    public boolean updateOne(T registro);



}
