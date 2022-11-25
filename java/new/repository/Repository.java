package repository;

import domain.Bolnoi;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    T find (Long id) throws SQLException;

    void save(T source);

    void delete(T target);

    List<T> list();
    void update (T obj);


}
