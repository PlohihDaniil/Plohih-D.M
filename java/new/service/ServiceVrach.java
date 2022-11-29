package service;

import domain.Vrach;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceVrach implements Service<Vrach>{
    private  final Repository <Vrach> repository;

    public ServiceVrach(Repository<Vrach> repository) {
        this.repository = repository;
    }


    @Override
    public Vrach getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Vrach> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Vrach obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Vrach obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Vrach target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Vrach> getList(Long id) {
        return null;
    }

    @Override
    public List<Vrach> listPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Vrach> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Vrach> getListPoId(Long id) {
        return null;
    }
}
