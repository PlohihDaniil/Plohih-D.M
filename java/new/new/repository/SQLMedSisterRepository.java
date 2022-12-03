package repository;

import domain.MedSister;
import domain.Vrach;
import test.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLMedSisterRepository implements Repository<MedSister>{
    private final DBWorker connector;

    public SQLMedSisterRepository() {
        this.connector = new DBWorker();
    }


    @Override
    public MedSister find(Long id) throws SQLException {

        String show = "select ms.*, kab.name as kabinet, ot.id as id_otdel, ot.name as otdel from  med_sister as ms\n" +
                "left join kabinet as kab on ms.id_kabinet = kab.id\n" +
                "left join otdel as ot on kab.id_otdel = ot.id\n" +
                "where ms.id="+id;

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

        return new MedSister(id,otdel,zp,pol,name,age,inn,id_kab,id_otdel,kabinet);
    }

    @Override
    public void save(MedSister source) throws SQLException {
        String save ="insert into med_sister (name,pol,age,inn,zp,id_kab) values (?,?,?,?,?,?)";

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
    public void delete(MedSister target) throws SQLException {
        String delete = "delete from med_sister where id ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<MedSister> list() throws SQLException {
        List<MedSister> list = new ArrayList<>();
        String show = "select ms.*, kab.name as kabinet, ot.id as id_otdel, ot.name as otdel from  med_sister as ms\n" +
                "left join kabinet as kab on ms.id_kabinet = kab.id\n" +
                "left join otdel as ot on kab.id_otdel = ot.id";


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
            long id_kab = resultSet.getLong("id_kabinet");


            MedSister medSister = new MedSister(id,otdel,zp,pol,name,age,inn,id_kab,id_otdel,kabinet);
            list.add(medSister);

        }
        return list;
    }

    @Override
    public void update(MedSister obj) throws SQLException {
        String  update ="update med_sister set name = ?, pol = ?, age = ?, inn= ?, zp= ?, id_kab= ? where id =" + obj.getId();

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
    public List<MedSister> listPoId(Long id) {
        return null;
    }

    @Override
    public List<MedSister> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<MedSister> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<MedSister> oneList(Long id) throws SQLException {
        return null;
    }
}
