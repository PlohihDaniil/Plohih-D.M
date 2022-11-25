package service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {

    T getById (Long id) throws SQLException;

    List<T> getAll();

    void save(T obj);

    void update(T obj);
}
