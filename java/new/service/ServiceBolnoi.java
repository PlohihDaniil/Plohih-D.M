package service;

import domain.Bolnoi;
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
    public List<Bolnoi> getAll() {
        return repository.list();
    }

    public void save(Bolnoi bolnoi){
        repository.save(bolnoi);
    }
    public void update (Bolnoi bolnoi){
        repository.update(bolnoi);
    }

}
