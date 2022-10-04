package test;

import javax.sound.midi.Soundbank;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class DataBase {
    String queryB = "select * from bolnoilists";
    String queryV = "select * from vrachlists";
    String queryOt = "select * from otdelLists";
    private final String INSERT_Bolnoi = " insert into bolnoilists values (?,?,?,?,?,?,?)";
    private final String INSERT_Vrach = " insert into vrachlists values (?,?,?,?,?,?,?)";
    private final String INSERT_Otdel = "insert into otdellists values (?,?,?,?)";
    DBWorker worker = new DBWorker();
    Statement statement;
    Scanner scan = new Scanner(System.in);

    private List<Vrach> vrachList = new ArrayList<>();
    private List<Bolnoi> bolnoiList = new ArrayList<>();
    private List<Otdel> otdelList = new ArrayList<>();

    //БОЛЬНЫЕ
    void addBolnoi(Bolnoi Bolnoi) {
        bolnoiList.add(Bolnoi);
    }

    void showBolnoi() {
        for (int i = 0; i < bolnoiList.size(); i++) {
            Person number = bolnoiList.get(i);
            System.out.println(number);
        }
    }

    void showIdBolnoi() {
        for (int i = 0; i < bolnoiList.size(); i++) {
            Person number = bolnoiList.get(i);
            System.out.println(i + " " + number);
        }
    }

    Bolnoi newBolnoi() {
        LocalDate data = LocalDate.now();

        System.out.println("Введите имя больного: ");
        String name = scan.next();

        System.out.println("Выберите отдел: ");
        showIdOtdel();
        int x = scan.nextInt();

        String ot = ((Otdel) otdelList.get(x)).getName();

        int ko = ((Otdel) otdelList.get(x)).getKolvo() + 1;
        ((Otdel) otdelList.get(x)).setKolvoBol(ko);

        System.out.println("Выберите врача: ");
        String vrach;
        if(vrachList.size()!=0) {
            for (int i = 0; i < vrachList.size(); i++) {
                if (((Vrach) vrachList.get(i)).getOt() == ((Otdel) otdelList.get(x)).getName()) {
                    System.out.println(i + " " + ((Vrach) vrachList.get(i)).getName());

                }
            }
            int d = scan.nextInt();
            vrach = ((Vrach) vrachList.get(d)).getName();
        }
        else{
                System.out.println("Нет врачей в данном отделении!!!");
                vrach=null;
            }

        System.out.println("Введите год рождения больного: ");
        int n = scan.nextInt();
        int date = data.getYear() - n;

        System.out.println("Введите пол больного: ");
        String pol = scan.next();

        System.out.println("Введите ИНН больного: ");
        int inn = scan.nextInt();

        Bolnoi h = new Bolnoi(ot, pol, name, date, inn, vrach);
        System.out.println(h);
        return h;
    }

    void deleteBolnoi() {
        System.out.println();
        System.out.println("Введите номер больного: ");
        int n = scan.nextInt();
        bolnoiList.remove(n);
    }


    void changeBolnoi() {
        LocalDate data = LocalDate.now();
        System.out.println();
        System.out.println("Введите номер больного, которого хотите изменить: ");
        int numberBol = scan.nextInt();
        Object p = bolnoiList.get(numberBol);
        System.out.println(p);
        System.out.println("Выберите что хотите изменить: 0 Полностью больного 1 Пол 2 Имя 3 Дата рождения 4 ИНН 5 Отдел 6 Врача");
        int x = scan.nextInt();
        switch (x) {
            case 0:
                System.out.println("Введите какого больного хотите полностью изменить: ");
                int c = scan.nextInt();
                bolnoiList.set(c, newBolnoi());
                break;
            case 1:
                System.out.println("Введите новый пол: ");
                String g = scan.next();
                ((Bolnoi) bolnoiList.get(numberBol)).setPol(g);
                break;
            case 2:
                System.out.println("Введите новое имя: ");
                g = scan.next();
                ((Bolnoi) bolnoiList.get(numberBol)).setName(g);
                break;
            case 3:
                System.out.println("Введите новую дату рождения: ");
                int d = scan.nextInt();
                d = data.getYear() - d;
                ((Bolnoi) bolnoiList.get(numberBol)).setDate(d);
                break;
            case 4:
                System.out.println("Введите новый ИНН: ");
                d = scan.nextInt();
                ((Bolnoi) bolnoiList.get(numberBol)).setInn(d);
                break;
            case 5:
                System.out.println("Выберети новый отдел: ");
                showIdOtdel();
                int id = 0;
                int newOt = scan.nextInt();
                changeKolvoBol(numberBol, newOt);
                String nOt = ((Otdel) otdelList.get(newOt)).getName();
                ((Bolnoi) bolnoiList.get(numberBol)).setOt(nOt);

            case 6:
                System.out.println("Выберети нововго врача: ");
                showIdVrach();
                int v = scan.nextInt();
                int idv = 0;
                int idOt = 0;
                for (int i = 0; i < vrachList.size(); i++) {
                    if (((Bolnoi) bolnoiList.get(numberBol)).getVrach() == ((Vrach) vrachList.get(i)).getName()) {
                        idv = i;
                    }
                }
                for (int i = 0; i < otdelList.size(); i++) {
                    if (((Vrach) vrachList.get(idv)).getOt() == ((Otdel) otdelList.get(i)).getName()) {
                        idOt = i;
                    }
                }

                changeKolvoBol(numberBol, idOt);
                String nm = ((Vrach) vrachList.get(v)).getName();
                ((Bolnoi) bolnoiList.get(numberBol)).setVrach(nm);

                break;
            default:
                break;
        }

    }


    void changeKolvoBol(int numberBol, int newOt) {
        int id = 0;
        if (((Bolnoi) bolnoiList.get(numberBol)).getOt() != ((Otdel) otdelList.get(newOt)).getName()) {
            for (int i = 0; i < otdelList.size(); i++) {
                if (((Bolnoi) bolnoiList.get(numberBol)).getOt() == ((Otdel) otdelList.get(i)).getName()) {
                    id = i;
                }
            }
            int u = ((Otdel) otdelList.get(id)).getKolvo() - 1;
            ((Otdel) otdelList.get(id)).setKolvoBol(u);
            int r = ((Otdel) otdelList.get(newOt)).getKolvo() + 1;
            ((Otdel) otdelList.get(newOt)).setKolvoBol(r);
        }
    }


    //ОТДЕЛЫ
    void addOtdel(Otdel Otdel) {
        otdelList.add(Otdel);
    }

    void showOtdel() {

        for (int i = 0; i < otdelList.size(); i++) {
            Otdel number = otdelList.get(i);
            System.out.println(number);
        }

    }

    void showIdOtdel() {
        for (int i = 0; i < otdelList.size(); i++) {
            Otdel number = otdelList.get(i);
            System.out.println(i + " " + number);
        }
    }

    Otdel newOtdel() {
        int vrach = 0;
        int kolvo = 0;
        System.out.println("Введите название нового отдела: ");
        String name = scan.next();
        Otdel h = new Otdel(name, vrach, kolvo);
        System.out.println(h);
        return h;
    }

    Otdel newOtdelVrach(String name) {
        int kolvo = 0;
        int vrach = 1;
        Otdel h = new Otdel(name, vrach, kolvo);
        System.out.println(h);
        return h;
    }

    void deleteOtdel() {
        System.out.println();
        System.out.println("Введите номер отделения: ");
        int n = scan.nextInt();
        otdelList.remove(n);
    }

    void changeOtdel() {
        System.out.println();
        System.out.println("Введите номер отделения, которое хотите изменить: ");
        int n = scan.nextInt();
        Object p = otdelList.get(n);
        System.out.println(p);
        System.out.println("Выберите что хотите изменить: 0 Полностью отдел 1 Название 2 Количество больных");
        int x = scan.nextInt();
        switch (x) {
            case 0:
                System.out.println("Введите какой отдел хотите полностью изменить: ");
                int c = scan.nextInt();
                otdelList.set(c, newOtdel());
                break;
            case 1:
                System.out.println("Введите новое название: ");
                String g = scan.next();
                ((Otdel) otdelList.get(n)).setName(g);
                break;
            case 2:
                System.out.println("Введите новое количество больных: ");
                int k = scan.nextInt();
                ((Otdel) otdelList.get(n)).setKolvoBol(k);
                break;
            default:
                break;
        }
    }

    //ВРАЧИ
    void addVrach(Vrach Vrach) {
        vrachList.add(Vrach);
    }

    void showIdVrach() {
        for (int i = 0; i < vrachList.size(); i++) {
            Person number = vrachList.get(i);
            System.out.println(i + " " + number);
        }
    }

    void showVrach() {
        for (int i = 0; i < vrachList.size(); i++) {
            Person number = vrachList.get(i);
            System.out.println(number);
        }
    }

    Vrach newVrach() {
        LocalDate data = LocalDate.now();

        System.out.println("Введите имя врача: ");
        String name = scan.next();

        System.out.println("Введите зарплату данного врача: ");
        int zp = scan.nextInt();
        System.out.println("Выберите 1. Создать новый отдел 2. Выбрать отдел");
        int x = scan.nextInt();
        String ot = null;
        if (x == 1) {
            System.out.println("Введите название отдела: ");
            ot = scan.next();
            addOtdel(newOtdelVrach(ot));
        }
        if (x == 2) {
            System.out.println("Выберите отдел: ");
            showIdOtdel();
            int a = scan.nextInt();
            int q = ((Otdel) otdelList.get(a)).getKolvoVrach();
            ((Otdel) otdelList.get(a)).setKolvoVrach(q + 1);
        }


        System.out.println("Введите год рождения врача: ");
        int n = scan.nextInt();
        int date = data.getYear() - n;

        System.out.println("Введите пол врача: ");
        String pol = scan.next();

        System.out.println("Введите ИНН врача: ");
        int inn = scan.nextInt();

        Vrach h = new Vrach(ot, zp, pol, name, date, inn);
        System.out.println(h);
        return h;
    }

    void deleteVrach() {
        System.out.println();
        System.out.println("Введите номер врача: ");
        int n = scan.nextInt();
        vrachList.remove(n);
    }

    void changeVrach() {
        LocalDate data = LocalDate.now();
        System.out.println();
        System.out.println("Введите номер врача, которого хотите изменить: ");
        int n = scan.nextInt();
        Object p = vrachList.get(n);
        System.out.println(p);
        System.out.println("Выберите что хотите изменить: 0 Полностью врача 1 Пол 2 Имя 3 Дата рождения 4 ИНН 5 Отдел 6 Зарплату");
        int x = scan.nextInt();
        switch (x) {
            case 0:
                System.out.println("Введите какого врача хотите полностью изменить: ");
                int c = scan.nextInt();
                vrachList.set(c, newVrach());
                break;
            case 1:
                System.out.println("Введите новый пол: ");
                String g = scan.next();
                ((Vrach) vrachList.get(n)).setPol(g);
                break;
            case 2:
                System.out.println("Введите новое имя: ");
                g = scan.next();
                ((Vrach) vrachList.get(n)).setName(g);
                break;
            case 3:
                System.out.println("Введите новую дату рождения: ");
                int d = scan.nextInt();
                d = data.getYear() - d;
                ((Vrach) vrachList.get(n)).setDate(d);
                break;
            case 4:
                System.out.println("Введите новый ИНН: ");
                d = scan.nextInt();
                ((Vrach) vrachList.get(n)).setInn(d);
                break;
            case 5:
                System.out.println("1. Создать новый отдел 2. Перевести в другой отдел");
                int r = scan.nextInt();
                if (r == 1) {
                    addOtdel(newOtdel());
                }
                if (r == 2) {
                    System.out.println("Выберите отдел");
                    showIdOtdel();
                    int z = scan.nextInt();
                    changeKolvoVrach(n, z);

                    String l = ((Otdel)otdelList.get(z)).getName();
                    ((Vrach)vrachList.get(n)).setOt( l );
                }

                break;
            case 6:
                System.out.println("Введите новую зарплату: ");
                int m = scan.nextInt();
                ((Vrach) vrachList.get(n)).setZp(m);
            default:
                break;
        }
    }

    void changeKolvoVrach(int vrach, int newOt) {
        int starId=0;
        for (int i=0;i<otdelList.size();i++){
            if ( ((Vrach) vrachList.get(vrach)).getOt() == ((Otdel) otdelList.get(i)).getName() ) {
                starId=i;
            }
        }

        if (((Vrach) vrachList.get(vrach)).getOt() != ((Otdel) otdelList.get(newOt)).getName() ) {

            int a = ((Otdel)otdelList.get(starId)).getKolvoVrach();
            ((Otdel)otdelList.get(starId)).setKolvoVrach(a-1);

            int g= ((Otdel)otdelList.get(newOt)).getKolvoVrach();
            ((Otdel)otdelList.get(newOt)).setKolvoVrach(g+1);
        }

    }




    //Прочее

    void showPoOtdel() {
        showIdOtdel();
        System.out.println("Введите номер отдела: ");
        int n = scan.nextInt();
        System.out.println(  ((Otdel) otdelList.get(n)).getName()  );
        for (int i = 0; i < bolnoiList.size(); i++) {
            if (((Otdel) otdelList.get(n)).getName().equals(((Bolnoi) bolnoiList.get(i)).getOt())) {
                System.out.println(  (Bolnoi) bolnoiList.get(i)  );
            }
        }
    }

    void showVsePoOtdel() {
        for (int i = 0; i < otdelList.size(); i++) {
            System.out.println(((Otdel) otdelList.get(i)).getName());
            for ( int j = 0; j < bolnoiList.size(); j++) {
                if (((Otdel) otdelList.get(i)).getName().equals(((Vrach) vrachList.get(j)).getOt())){
                    System.out.println((Vrach) vrachList.get(j));
                }
                if (((Otdel) otdelList.get(i)).getName().equals(((Bolnoi) bolnoiList.get(j)).getOt())) {
                    System.out.println((Bolnoi) bolnoiList.get(j));
                }
            }
            System.out.println();
        }
    }

    void loading(){
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSetB = statement.executeQuery(queryB);
            while (resultSetB.next()){

                String name = resultSetB.getString("name");
                int age= resultSetB.getInt("age");;
                String pol= resultSetB.getString("pol");;
                int inn= resultSetB.getInt("INN");;
                String otdel= resultSetB.getString("otdel");;
                String vrach= resultSetB.getString("vrach");

                Bolnoi bbb = new Bolnoi(otdel,pol,name,age,inn,vrach);
                bolnoiList.add(bbb);

            }

            ResultSet resultSetV = statement.executeQuery(queryV);
            while (resultSetV.next()){
                String name = resultSetV.getString("name");
                int age= resultSetV.getInt("age");
                String pol= resultSetV.getString("pol");;
                int inn= resultSetV.getInt("inn");;
                int zp = resultSetV.getInt("zp");
                String otdel= resultSetV.getString("otdel");

                Vrach vvv = new Vrach( otdel,  zp, pol,  name,  age,  inn);
                vrachList.add(vvv);
            }

            ResultSet resultSetOt =statement.executeQuery(queryOt);
            while (resultSetOt.next()){
                String name = resultSetOt.getString("name");
                int vrach= resultSetOt.getInt("kol-vo vrach");;
                int kolvo= resultSetOt.getInt("kol-vo bolnix");;

                Otdel ooo = new Otdel( name, vrach,  kolvo);
                otdelList.add(ooo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void save(){
        try {
            statement = worker.getConnection().createStatement();
            statement.executeUpdate("delete from bolnoilists");
            statement.executeUpdate("delete from vrachlists");
            statement.executeUpdate("delete from otdellists");
            PreparedStatement preStatB= worker.getConnection().prepareStatement(INSERT_Bolnoi);
            for (int i=0;i<bolnoiList.size();i++){

                preStatB.setInt(1,i+1);
                preStatB.setString(2,( (Bolnoi) bolnoiList.get(i) ).getName() );
                preStatB.setInt(3,( (Bolnoi) bolnoiList.get(i) ).getDate());
                preStatB.setString(4,((Bolnoi) bolnoiList.get(i)).getPol());
                preStatB.setInt(5,((Bolnoi) bolnoiList.get(i)).getInn());
                preStatB.setString(6,((Bolnoi) bolnoiList.get(i)).getOt());
                preStatB.setString(7,((Bolnoi) bolnoiList.get(i)).getVrach());

                preStatB.execute();

            }
            PreparedStatement preStatV= worker.getConnection().prepareStatement(INSERT_Vrach);
            for (int i=0;i<vrachList.size();i++){

                preStatV.setInt(1,i+1);
                preStatV.setString(2,( (Vrach) vrachList.get(i) ).getName() );
                preStatV.setInt(3,( (Vrach) vrachList.get(i) ).getDate());
                preStatV.setString(4,((Vrach) vrachList.get(i)).getPol());
                preStatV.setInt(5,( (Vrach) vrachList.get(i) ).getInn());
                preStatV.setString(7,( (Vrach) vrachList.get(i) ).getOt());
                preStatV.setInt(6,( (Vrach) vrachList.get(i) ).getZp());

                preStatV.execute();

            }
            PreparedStatement preStatOt= worker.getConnection().prepareStatement(INSERT_Otdel);
            for (int i=0;i<otdelList.size();i++){

                preStatOt.setInt(1,i+1);
                preStatOt.setString(2,( (Otdel) otdelList.get(i) ).getName() );
                preStatOt.setInt(3,( (Otdel) otdelList.get(i) ).getKolvoVrach());
                preStatOt.setInt(4,( (Otdel) otdelList.get(i) ).getKolvo());

                preStatOt.execute();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}