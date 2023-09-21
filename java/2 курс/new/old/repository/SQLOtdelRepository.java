package repository;

import domain.Otdel;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLOtdelRepository implements Repository<Otdel> {

    private final DBWorker connector;

    public SQLOtdelRepository() {
        this.connector = new DBWorker();
    }


    @Override
    public Otdel find(Long id) throws SQLException {

        String find = "select * from otdel where id="+id;

        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(find);
        resultSet.next();

        long id_otdel = resultSet.getLong("id");
        String name = resultSet.getString("name");

        Otdel otdel = new Otdel(id_otdel,name);


        return otdel;
    }

    @Override
    public void save(Otdel source) {
        String save = "insert into otdel (name) values (?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement =connector.getConnection().prepareStatement(save);

            preparedStatement.setString(1, source.getName());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Otdel target) {
        String delete = "delete from otdel where id="+target.getId();
        String update = " update bolnoi set id_otdel=0 where id_otdel="+target.getId();

        try {
            PreparedStatement preparedStatement = connector.getConnection().prepareStatement(delete);
            preparedStatement.execute();
            preparedStatement=connector.getConnection().prepareStatement(update);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Otdel> list() {

        List<Otdel> list = new ArrayList<>();

        String show = "select * from otdel";
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(show);

            while (resultSet.next()){

                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                Otdel otdel = new Otdel(id, name);
                list.add(otdel);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void update(Otdel obj) {
        String update ="update otdel set name=? where id="+obj.getId();
        PreparedStatement preparedStatement;
        try {
            preparedStatement =connector.getConnection().prepareStatement(update);

            preparedStatement.setString(1, obj.getName());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Otdel> listPoId(Long id) {
        return null;
    }

    @Override
    public List<Otdel> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Otdel> getListPoId(Long id) throws SQLException {
        return null;
    }
}
