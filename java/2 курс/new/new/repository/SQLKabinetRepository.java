package repository;

import domain.Kabinet;
import domain.Palat;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLKabinetRepository implements Repository<Kabinet>{
    private final DBWorker connector;

    public SQLKabinetRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Kabinet find(Long id) throws SQLException {
        String show = "select * from kabinet where id=" +id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        long id_otdel = resultSet.getLong("id_otdel");

        String otdel ="select ot.name as otdel from otdel as ot where id=" + id_otdel;
        resultSet = statement.executeQuery(otdel);
        resultSet.next();
        String ot = resultSet.getString("otdel");

        return new Kabinet(id,name,id_otdel,ot);
    }

    // TODO: 28.11.2022 добавить сохранение в kabinet_oboryd
    @Override
    public void save(Kabinet source) throws SQLException {
        String save = "insert into kabinet(name,id_otdel) values(?,?) ";

        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);
        preparedStatement.setString(1, source.getName() );
        preparedStatement.setLong(2, source.getId_otdel() );

        preparedStatement.execute();
    }

    // TODO: 28.11.2022 добавить удаление одинаковый в kabinet_oboryd
    @Override
    public void delete(Kabinet target) throws SQLException {
        String delete ="delete from kabinet where id="+ target.getId();
        Statement statement =connector.getConnection().createStatement();
        statement.execute(delete);
        String delete2 ="delete from kabinet_oboryd where id_kabinet=" +target.getId();
        statement.execute(delete2);
    }

    @Override
    public List<Kabinet> list() throws SQLException {
        List<Kabinet> list=new ArrayList<>();

        String show = "select k.*, ot.name as otdel from kabinet as k\n" +
                "left join otdel as ot on ot.id=k.id_otdel\n" +
                "where k.id>0";

        Statement statement=connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long id_otdel = resultSet.getLong("id_otdel");
            String otdel = resultSet.getString("otdel");

            Kabinet kabinet = new Kabinet(id,name,id_otdel,otdel);
            list.add(kabinet);
        }
        return list;
    }

    @Override
    public void update(Kabinet obj) throws SQLException {
        String update = "update kabinet (name,id_otdel) values (?,?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1, obj.getName() );
        preparedStatement.setLong(2, obj.getId_otdel() );

        preparedStatement.execute();
    }

    @Override
    public List<Kabinet> listPoId(Long id) throws SQLException {

        List<Kabinet> list = new ArrayList<>();

        String show ="select * from kabinet where id_otdel ="+id;
        Statement statement = connector.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id_kab = resultSet.getLong("id");
            String name = resultSet.getString("name");

            Kabinet kabinet = new Kabinet(id_kab,name,0L,null);
            list.add(kabinet);
        }

        return list;
    }

    @Override
    public List<Kabinet> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Kabinet> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Kabinet> oneList(Long id) throws SQLException {
        return null;
    }
}
