package repository;

import domain.Vrach;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLVrachRepository implements Repository<Vrach>{
    private final DBWorker connector;

    public SQLVrachRepository() {
        this.connector = new DBWorker();
    }
    @Override
    public Vrach find(Long id) throws SQLException {

        String show ="select v.*, kab.name as kabinet, ot.id as id_otdel, ot.name as otdel   from  vrach as v\n" +
                "left join kabinet as kab on v.id_kab = kab.id\n" +
                "left join otdel as ot on kab.id_otdel = ot.id\n" +
                "where v.id ="+id;

        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        resultSet.next();

        String name = resultSet.getString("name");
        String pol = resultSet.getString("pol");
        int age = resultSet.getInt("age");
        int inn = resultSet.getInt("inn");
        int zp = resultSet.getInt("zp");
        String otdel = resultSet.getString("otdel");
        String kabinet = resultSet.getString("kabinet");
        long id_otdel = resultSet.getLong("id_otdel");
        long id_kab = resultSet.getLong("id_kab");


        return new Vrach(id,otdel,zp,pol,name,age,inn,id_otdel,id_kab,kabinet);
    }
    @Override
    public void save(Vrach source) throws SQLException {
        String save ="insert into vrach (name,pol,age,inn,zp,id_kab) values (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(save);

        preparedStatement.setString(1, source.getSurname() );
        preparedStatement.setString(2, source.getPol() );
        preparedStatement.setInt(3, source.getDate() );
        preparedStatement.setInt(4, source.getInn());
        preparedStatement.setInt(5, source.getZp());
        preparedStatement.setLong(6, source.getIdKab());

        preparedStatement.execute();
    }
    @Override
    public void delete(Vrach target) throws SQLException {
        String delete = "delete from vrach where id ="+target.getId();
        String delete2 ="delete from bolnoi_vrach where id_vrach ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(delete2);
    }
    @Override
    public List<Vrach> list() {
        List<Vrach> list=new ArrayList<>();

        String show = """
                select v.*, kab.name as kabinet, ot.id as id_otdel,ot.name as otdel from  vrach as v
                left join kabinet as kab on v.id_kab = kab.id
                left join otdel as ot on kab.id_otdel = ot.id""";

        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(show);

            while (resultSet.next()){

                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String pol = resultSet.getString("pol");
                int age = resultSet.getInt("age");
                int inn = resultSet.getInt("inn");
                int zp = resultSet.getInt("zp");
                String otdel = resultSet.getString("otdel");
                String kabinet = resultSet.getString("kabinet");
                long id_otdel = resultSet.getLong("id_otdel");
                long id_kab = resultSet.getLong("id_kab");


                Vrach vrach = new Vrach(id,otdel,zp,pol,name,age,inn,id_otdel,id_kab,kabinet);
                list.add(vrach);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }
    @Override
    public void update(Vrach obj) throws SQLException {
        String  update ="update vrach set name = ?, pol = ?, age = ?, inn= ?, zp= ?, id_kab= ? where id =" + obj.getId();

        PreparedStatement preparedStatement = connector.getConnection().prepareStatement(update);

        preparedStatement.setString(1, obj.getSurname() );
        preparedStatement.setString(2, obj.getPol() );
        preparedStatement.setInt(3, obj.getDate());
        preparedStatement.setInt(4, obj.getInn());
        preparedStatement.setInt(5, obj.getZp());
        preparedStatement.setLong(6,obj.getIdKab());

        preparedStatement.execute();

    }

    @Override
    public List<Vrach> listPoId(Long id) {
        return null;
    }

    @Override
    public List<Vrach> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Vrach> getListPoId(Long id) throws SQLException {
        return null;
    }
}
