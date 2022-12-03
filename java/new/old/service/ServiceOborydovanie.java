package service;

import domain.Oborydovanie;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceOborydovanie implements Service<Oborydovanie>{
    private  final Repository<Oborydovanie> repository;

    public ServiceOborydovanie(Repository<Oborydovanie> repository) {
        this.repository = repository;
    }


    @Override
    public Oborydovanie getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Oborydovanie> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Oborydovanie obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Oborydovanie obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Oborydovanie target) throws SQLException {
        repository.delete(target);
    }

    public List<Oborydovanie> getListFree() throws SQLException {
        return repository.getListFree();
    }

    @Override
    public List<Oborydovanie> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }

    @Override
    public List<Oborydovanie> oneList(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Oborydovanie> getList(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Oborydovanie> listPoId(Long id) throws SQLException {
        return repository.listPoId(id);
    }
}
