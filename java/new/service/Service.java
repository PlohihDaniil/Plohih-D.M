package service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {

    T getById (Long id) throws SQLException;

    List<T> getAll() throws SQLException;

    void save(T obj) throws SQLException;

    void update(T obj) throws SQLException;
    void delete(T target) throws SQLException;
    List<T> getList(Long id) throws SQLException;

    List<T> listPoId(Long id) throws SQLException;
    List<T> getListFree() throws SQLException;
    List<T> getListPoId(Long id) throws SQLException;
}
