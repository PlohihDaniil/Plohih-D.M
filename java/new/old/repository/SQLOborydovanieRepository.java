package repository;

import domain.Oborydovanie;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLOborydovanieRepository implements Repository<Oborydovanie>{
    private final DBWorker connector;

    public SQLOborydovanieRepository() {
        this.connector = new DBWorker();
    }


    @Override
    public Oborydovanie find(Long id) throws SQLException {
        String show = " select * from oborydovanie where id=" +id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        int number = resultSet.getInt("number");
        long id_kab = resultSet.getLong("id_kab");
        long id_palat = resultSet.getLong("id_palat");

        Oborydovanie oborydovanie = new Oborydovanie(id,name,number,id_kab,id_palat);
        return oborydovanie;
    }

    @Override
    public void save(Oborydovanie source) throws SQLException {
        String save ="insert into oborydovanie(name,number,id_kab,id_palat) values(?,?,?,?)";

        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getName() );
        preparedStatement.setInt(2, source.getNumber());
        preparedStatement.setLong(3, source.getId_kab());
        preparedStatement.setLong(4,source.getId_palat());

        preparedStatement.execute();
    }

    @Override
    public void delete(Oborydovanie target) throws SQLException {
        String delete ="delete from oborydovanie where id=" + target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Oborydovanie> list() throws SQLException {
        List<Oborydovanie> list=new ArrayList<>();

        String show = "select * from oborydovanie";
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            long id_kab = resultSet.getLong("id_kab");
            long id_palat = resultSet.getLong("id_palat");

            Oborydovanie oborydovanie = new Oborydovanie(id,name,number,id_kab,id_palat);
            list.add(oborydovanie);
        }
        return list;
    }

    @Override
    public void update(Oborydovanie obj) throws SQLException {
        String update="update oborydovanie set name=?,number=?,id_kab=?,id_palat=? where id="+obj.getId();
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setInt(2,obj.getNumber());
        preparedStatement.setLong(3, obj.getId_kab());
        preparedStatement.setLong(4, obj.getId_palat());

        preparedStatement.execute();
    }

    public List<Oborydovanie> getListFree() throws SQLException {
        List<Oborydovanie> list = new ArrayList<>();

        String show ="select * from oborydovanie where id_kab=0 and id_palat=0";

        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            long id_kab = resultSet.getLong("id_kab");
            long id_palat = resultSet.getLong("id_palat");

            Oborydovanie oborydovanie = new Oborydovanie(id,name,number,id_kab,id_palat);
            list.add( oborydovanie);
        }
        return list;
    }

    @Override
    public List<Oborydovanie> getListPoId(Long id) throws SQLException {
        List<Oborydovanie> list = new ArrayList<>();
        String show ="select * from oborydovanie where id_palat=" + id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id_oboryd = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            long id_kab = resultSet.getLong("id_kab");
            long id_palat = resultSet.getLong("id_palat");

            list.add( new Oborydovanie(id_oboryd,name,number,id_kab,id_palat));
        }


        return list;
    }

    @Override
    public List<Oborydovanie> listPoId(Long id) throws SQLException {
        List<Oborydovanie> list = new ArrayList<>();
        String show ="select * from oborydovanie where id_kab=" + id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id_oboryd = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            long id_kab = resultSet.getLong("id_kab");
            long id_palat = resultSet.getLong("id_palat");

            list.add( new Oborydovanie(id_oboryd,name,number,id_kab,id_palat));
        }


        return list;
    }
}
