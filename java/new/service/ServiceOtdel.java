package service;

import domain.Bolnoi;
import domain.Otdel;
import repository.Repository;

import java.util.List;

public class ServiceOtdel implements Service<Otdel>{
    private  final Repository <Otdel> repository;

    public ServiceOtdel(Repository<Otdel> repository) {
        this.repository = repository;
    }

    @Override
    public Otdel getById(Long id) {
        return null;
    }

    @Override
    public List<Otdel> getAll() {
        return null;
    }

    @Override
    public void save(Otdel obj) {

    }

    @Override
    public void update(Otdel obj) {

    }
}
