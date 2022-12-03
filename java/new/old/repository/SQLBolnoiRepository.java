package repository;

import domain.Bolnoi;
import domain.Vrach;
import test.DBWorker;

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
    //complete
    public Bolnoi find(Long id) throws SQLException {
        String query = "select b.id, b.name, b.pol, b.age,b.inn,b.id_palat as number_palat, ot.id as id_otdel, ot.name as otdel,v.name as vrach from bolnoi as b\n" +
                "                        left join palat_otdel as p on b.id_palat = p.id_palat\n" +
                "                        left join otdel as ot on ot.id = p.id_otdel\n" +
                "                        left join bolnoi_vrach as bv on bv.id_bolnoi = b.id\n" +
                "                        left join vrach as v on v.id = bv.id_vrach\n" +
                "                        where b.id =" + id;
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
            Long id_palat = resultSet.getLong("number_palat");
            Long id_otdel = resultSet.getLong("id_otdel");
            if (f==0){
                bolnoi = new Bolnoi(id, ot, pol, name, age, inn,id_palat,id_otdel);
                bolnoi.addVrach(vrach);
            }
            else{
                bolnoi.addVrach(vrach);
            }
        }
        return bolnoi;
    }

    // TODO: 26.11.2022 добавить в save добавление в список bolnoi_vrach врача нового больного
    @Override
    public void save(Bolnoi source) {

        final String INSERT_Bolnoi = "insert into bolnoi(name,pol,age,inn,id_palat) values (?, ?, ?, ?, ?)";
        final String insert_varch = "insert into bolnoi_vrach(id_vrach,id_bolnoi) values (?,?)";

        PreparedStatement preStatBolnoi;
        PreparedStatement preStatBolnoi1;

        try {

            preStatBolnoi = connector.getConnection().prepareStatement(INSERT_Bolnoi);

            preStatBolnoi.setString(1, source.getSurname());
            preStatBolnoi.setString(2,source.getPol());
            preStatBolnoi.setInt(3,source.getDate());
            preStatBolnoi.setInt(4,source.getInn());
            preStatBolnoi.setInt(5, Math.toIntExact( source.getId_palat() ));

            preStatBolnoi.execute();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // TODO: 26.11.2022 добавить update врачей
    public void update (Bolnoi obj){

        final String update = "update bolnoi set name=?, age=?, pol=?, INN= ?, id_palat=? where bolnoi.id= " + obj.getId();

        try {
            PreparedStatement statement = connector.getConnection().prepareStatement(update);

            statement.setString(1,obj.getSurname());
            statement.setInt(2,obj.getDate());
            statement.setString(3,obj.getPol());
            statement.setInt(4,obj.getInn());
            statement.setLong(5, obj.getId_palat() );

            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bolnoi> listPoId(Long id) throws SQLException {
        List<Bolnoi> list = new ArrayList<>();

        String show="select v.id as id_vrach,v.name as vrach, b.id as id_bolnoi,b.name as bolnoi from vrach as v\n" +
                "left join bolnoi_vrach as bv on bv.id_vrach=v.id\n" +
                "left join bolnoi as b on b.id=bv.id_bolnoi\n" +
                "where v.id="+id;

        Statement statement = connector.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id_bolnoi = resultSet.getLong("id_bolnoi");
            String name = resultSet.getString("bolnoi");

            Bolnoi bolnoi = new Bolnoi(id_bolnoi,null,null,name,0,0,0L,0L);
            list.add(bolnoi);
        }
        return list;
    }

    @Override
    public List<Bolnoi> getListFree() throws SQLException {
        return null;
    }

    @Override
    public List<Bolnoi> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Bolnoi target) throws SQLException {
        String delete = "delete from bolnoi where id ="+target.getId();
        String delete2 ="delete from bolnoi_vrach where id_bolnoi ="+target.getId();
        Statement statement = connector.getConnection().createStatement();
        statement.execute(delete);
        statement.execute(delete2);
    }

    @Override
    public List<Bolnoi> list() {

        List<Bolnoi> list= new ArrayList<>();
        final String show =
                """
                        select b.id, b.name, b.pol, b.age,b.inn,b.id_palat as number_palat,ot.id as id_otdel, ot.name as otdel,v.name as vrach from bolnoi as b
                        left join palat_otdel as p on b.id_palat = p.id_palat
                        left join otdel as ot on ot.id = p.id_otdel
                        left join bolnoi_vrach as bv on bv.id_bolnoi = b.id
                        left join vrach as v on v.id = bv.id_vrach""";


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
                Long id_palat = resultSet.getLong("number_palat");
                Long id_otdel = resultSet.getLong("id_otdel");

                if(f==0){
                    Bolnoi o = new Bolnoi(id, ot, pol, name, age, inn,id_palat,id_otdel);
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
                            Bolnoi o = new Bolnoi(id, ot, pol, name, age, inn,id_palat,id_otdel);
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
