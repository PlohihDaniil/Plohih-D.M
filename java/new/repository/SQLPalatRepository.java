package repository;

import domain.Palat;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLPalatRepository implements Repository<Palat>{
    private final DBWorker connector;

    public SQLPalatRepository() {
        this.connector = new DBWorker();
    }


    @Override
    public Palat find(Long id) throws SQLException {
        String show = "select * from palat_otdel as po\n" +
                "left join otdel as ot on po.id_otdel = ot.id\n" +
                "where po.id_palat="+id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        long id_otdel = resultSet.getLong("id_otdel");
        String name_otdel = resultSet.getString("name");


        return new Palat(id,id_otdel,name_otdel);
    }

    @Override
    public void save(Palat source) throws SQLException {
        String save = "insert into palat_otdel(id_otdel) values(?)";
        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setLong(1, source.getId_otdel() );

        preparedStatement.execute();
    }

    @Override
    public void delete(Palat target) throws SQLException {
        String delete1 = "delete from palat_otdel where id_palat="+target.getId();
        String delete2 = "update oborydovanie set id_palat=0 where id_palat= "+target.getId();
        String delete3 = "update bolnoi set id_palat=0 where id_palat="+target.getId();

        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete1);
        statement.execute(delete2);
        statement.execute(delete3);
     }

    @Override
    public List<Palat> list() throws SQLException {
        List<Palat> list = new ArrayList<>();
        String show = "select * from palat_otdel as po\n" +
                "left join otdel as ot on po.id_otdel = ot.id";
        Statement statement =connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id");
            long id_otdel = resultSet.getLong("id_otdel");
            String name = resultSet.getString("name");

            list.add(new Palat(id,id_otdel,name));
        }
        return list;
    }

    public List<Palat> oneList(Long id) throws SQLException {
        List<Palat> list = new ArrayList<>();
        String show = "select * from palat_otdel as po\n" +
                "left join otdel as ot on po.id_otdel = ot.id\n" +
                "where po.id_otdel="+id;

        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id_palat = resultSet.getLong("id_palat");
            String name = resultSet.getString("name");

            Palat palat = new Palat(id_palat,id,name);
            list.add(palat);
        }
        return list;
    }
    @Override
    public void update(Palat obj) throws SQLException {
        String update = "update palat_otdel set id_otdel=" + obj.getId_otdel();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(update);

    }


    @Override
    public List<Palat> listPoId(Long id) {
        return null;
    }

    @Override
    public List<Palat> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Palat> getListPoId(Long id) {
        return null;
    }
}
