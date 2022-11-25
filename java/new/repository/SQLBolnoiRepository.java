package repository;

import domain.Bolnoi;
import domain.Vrach;
import test.DBWorker;

import javax.xml.namespace.QName;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLBolnoiRepository implements Repository<Bolnoi>{

    private final DBWorker connector;

    public SQLBolnoiRepository() {
        this.connector = new DBWorker();
    }



    @Override
    public Bolnoi find(Long id) throws SQLException {
        String query = "select b.id, b.name, b.pol, b.age,b.inn, ot.name as otdel,v.name as vrach from bolnoi as b\n" +
                "join otdel as ot on b.id_otdel = ot.id\n" +
                "left join  bolnoi_vrach as bv on b.id = bv.id_bolnoi\n" +
                "left join vrach as v on v.id=bv.id_vrach\n" +
                "where b.id =" + id;
        Statement statement = connector.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        Bolnoi bolnoi = null;
        int f=0;

        while (resultSet.next()){

            String vrach = resultSet.getString("vrach");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String pol = resultSet.getString("pol");
            int inn = resultSet.getInt("INN");
            String ot = resultSet.getString("otdel");

            if (f==0){
                bolnoi = new Bolnoi(id, ot, pol, name, age, inn);
                bolnoi.addVrach(vrach);
            }
            else{
                bolnoi.addVrach(vrach);
            }


        }





        return bolnoi;
    }


    //@Override
    public void save(Bolnoi source) {

        final String INSERT_Bolnoi = "insert into bolnoi(name,pol,date,inn,id_vrach,id_otdel) values (?, ?, ?, ?, ?,?)";

        PreparedStatement preStatBolnoi;

        try {

            preStatBolnoi = connector.getConnection().prepareStatement(INSERT_Bolnoi);

            preStatBolnoi.setString(1, source.getSurname());
            preStatBolnoi.setString(2,source.getPol());
            preStatBolnoi.setInt(3,source.getDate());
            preStatBolnoi.setInt(4,source.getInn());
            //preStatBolnoi.setInt(5,);

            preStatBolnoi.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update (Bolnoi obj){

        final String select = "update bolnoi set name=?, age=?, pol=?, INN= ? where id="+ obj.getId();

        try {
            PreparedStatement statement = connector.getConnection().prepareStatement(select);

            statement.setString(1,obj.getSurname());
            statement.setInt(2,obj.getDate());
            statement.setString(3,obj.getPol());
            statement.setInt(4,obj.getInn());

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Bolnoi target) {

    }

    @Override
    public List<Bolnoi> list() {

        List<Bolnoi> list= new ArrayList<>();
        final String show =
                "select b.id, b.name, b.pol, b.age,b.inn, ot.name as otdel,v.name as vrach from bolnoi as b\n" +
                "join otdel as ot on b.id_otdel = ot.id\n" +
                "left join  bolnoi_vrach as bv on b.id = bv.id_bolnoi\n" +
                "left join vrach as v on v.id=bv.id_vrach";


        try (
                Statement statement = connector.getConnection().createStatement();

                ){

            ResultSet resultSet = statement.executeQuery(show);

int f=0;
            while (resultSet.next()){

                long id = resultSet.getLong("id");
                String vrach = resultSet.getString("vrach");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String pol = resultSet.getString("pol");
                int inn = resultSet.getInt("INN");
                String ot = resultSet.getString("otdel");

                if(f==0){
                    Bolnoi o = new Bolnoi(id, ot, pol, name, age, inn);
                    o.addVrach(vrach);
                    list.add(o);
                    f+=1;
                }
                else {
                for(int i=0; i< f;i++) {
                    if(list.get(i).getId() == id){
                        list.get(i).addVrach(vrach);
                    }
                    else {
                        Bolnoi o = new Bolnoi(id, ot, pol, name, age, inn);
                        o.addVrach(vrach);
                        list.add(o);
                    }
                }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
