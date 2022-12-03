package service;

import domain.Palat;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServicePalat implements Service<Palat>{
    private  final Repository<Palat> repository;

    public ServicePalat(Repository<Palat> repository) {
        this.repository = repository;
    }


    @Override
    public Palat getById(Long id) throws SQLException {
        return repository.find(id) ;
    }

    @Override
    public List<Palat> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Palat obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Palat obj) throws SQLException {
        repository.update(obj);
    }
    public List<Palat> oneList(Long id) throws SQLException {
        return repository.oneList(id);
    }

    @Override
    public void delete(Palat target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Palat> getList(Long id) {
        return null;
    }

    @Override
    public List<Palat> listPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Palat> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Palat> getListPoId(Long id) throws SQLException {
        return repository.getListPoId(id);
    }


}
