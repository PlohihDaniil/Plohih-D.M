package service;

import domain.Kabinet;
import repository.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceKabinet implements Service<Kabinet>{
    private  final Repository<Kabinet> repository;
    public ServiceKabinet(Repository<Kabinet> repository) {

        this.repository = repository;
    }

    @Override
    public Kabinet getById(Long id) throws SQLException {
        return repository.find(id);
    }
    @Override
    public List<Kabinet> getAll() throws SQLException {
        return repository.list();
    }

    @Override
    public void save(Kabinet obj) throws SQLException {
        repository.save(obj);
    }

    @Override
    public void update(Kabinet obj) throws SQLException {
        repository.update(obj);
    }

    @Override
    public void delete(Kabinet target) throws SQLException {
        repository.delete(target);
    }

    @Override
    public List<Kabinet> getList(Long id) throws SQLException {
        return repository.listPoId(id);
    }

    @Override
    public List<Kabinet> listPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Kabinet> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Kabinet> getListPoId(Long id) {
        return null;
    }
}
