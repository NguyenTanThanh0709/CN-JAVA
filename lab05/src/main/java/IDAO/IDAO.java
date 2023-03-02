package IDAO;

import java.util.List;

public interface IDAO <T>{
    boolean add(T t);
    T get(String id);
    List<T> getAll();
    boolean remove(String id);
    boolean remove(T t);
    boolean update(T t);

}