package service;

import domain.Bolnoi;
import domain.Vrach;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceBolnoi implements Service<Bolnoi> {

    private  final Repository <Bolnoi> repository;

    public ServiceBolnoi(Repository<Bolnoi> repository) {
        this.repository = repository;
    }


    @Override
    public Bolnoi getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<Bolnoi> getAll() throws SQLException {
        return repository.list();
    }

    public void save(Bolnoi bolnoi) throws SQLException {
        repository.save(bolnoi);
    }
    public void update (Bolnoi bolnoi) throws SQLException {
        repository.update(bolnoi);
    }

    @Override
    public void delete(Bolnoi target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Bolnoi> getList(Long id) {
        return null;
    }

    @Override
    public List<Bolnoi> listPoId(Long id) throws SQLException {
        return repository.listPoId(id);
    }

    @Override
    public List<Bolnoi> getListFree() throws SQLException {
        return repository.getListFree();
    }

    @Override
    public List<Bolnoi> getListPoId(Long id) {
        return null;
    }

    @Override
    public List<Bolnoi> oneList(Long id) throws SQLException {
        return null;
    }

}
