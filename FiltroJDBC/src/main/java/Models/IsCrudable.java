package Models;

import java.util.List;

public interface IsCrudable<T>{

    public List<T> getall();

    public T getOne(int id);

    public  boolean delete(int id);

    public boolean insertOne(T registro);
    public boolean updateOne(T registro);



}
