package service;

import domain.MedSister;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;

public class ServiceMedSister implements Service<MedSister>{
    private  final Repository<MedSister> repository;

    public ServiceMedSister(Repository<MedSister> repository) {
        this.repository = repository;
    }

    @Override
    public MedSister getById(Long id) throws SQLException {
        return repository.find(id);
    }

    @Override
    public List<MedSister> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(MedSister obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(MedSister obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(MedSister target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<MedSister> getList(Long id) {
        return null;
    }

    @Override
    public List<MedSister> listPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<MedSister> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<MedSister> getListPoId(Long id) {
        return null;
    }
}
