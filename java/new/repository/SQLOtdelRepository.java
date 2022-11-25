package repository;

import domain.Otdel;

import java.sql.SQLException;
import java.util.List;

public class SQLOtdelRepository implements Repository<Otdel> {
    @Override
    public Otdel find(Long id) throws SQLException {

        return null;
    }

    @Override
    public void save(Otdel source) {

    }

    @Override
    public void delete(Otdel target) {

    }

    @Override
    public List<Otdel> list() {
        return null;
    }

    @Override
    public void update(Otdel obj) {

    }
}
