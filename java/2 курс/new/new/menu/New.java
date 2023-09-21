package menu;

import domain.*;
import repository.*;
import service.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class New {

    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Bolnoi> serviceBolnoi= new ServiceBolnoi(new SQLBolnoiRepository());
    Service<Kabinet> serviceKabinet= new ServiceKabinet(new SQLKabinetRepository());
    Service<MedSister> serviceMedSister= new ServiceMedSister(new SQLMedSisterRepository());
    Service<Oborydovanie> serviceOborydovanie= new ServiceOborydovanie(new SQLOborydovanieRepository());
    Service<Palat> ServicePalat= new ServicePalat(new SQLPalatRepository());
    Service<Vrach> serviceVrach= new ServiceVrach(new SQLVrachRepository());

    Draw draw;

    LocalDate data = LocalDate.now();
    Scanner keyboard = new Scanner(System.in);

    public New(Draw draw) {
        this.draw = draw;
    }


    void newBolnoi() throws SQLException {
        System.out.println("Введите данные больного");
        System.out.print("Имя: ");String name = keyboard.next();
        System.out.print("Пол: ");String pol = keyboard.next();
        System.out.print("Год рождения: ");int date = data.getYear() - keyboard.nextInt();
        System.out.print("ИНН: ");int inn = keyboard.nextInt();

        draw.drawOtdelList();
        System.out.print("Выберите отделение:");
        long id_otdel = keyboard.nextLong();

        draw.drawPalatList(id_otdel);
        System.out.println("Выберите палату в которую хотите отправить больного: ");
        Long id =keyboard.nextLong();

        Otdel otdel = serviceOtdel.getById(id_otdel);

        String ot = otdel.getName();

        Bolnoi o = new Bolnoi(null,ot,pol,name,date,inn,id,id_otdel);
        int q=0;

        draw.drawVrachList();
        System.out.println("Выбирете врачей для больного:");

        while (q==0){
            Long id_vrach= keyboard.nextLong();

            Vrach vrach = draw.drawSingleVrach(id_vrach);
            o.addVrach( vrach.getSurname() );
            o.addIdVrach( vrach.getId() );
            o.addVrachList( vrach );

            System.out.println("1. Еще добавить");
            System.out.println("2. Закончить");
            int s=keyboard.nextInt();
            switch (s){
                case 1->{

                }
                case 2-> q=1;
            }
        }

        serviceBolnoi.save(o);
    }
    void newKabinet() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Название кабинета: ");
        String name = keyboard.next();

        draw.drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = draw.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Kabinet kabinet = new Kabinet(null,name,id_otdel,ot);
        serviceKabinet.save(kabinet);
    }
    void newMedSister() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Имя: ");
        String name = keyboard.next();

        System.out.println("Пол: ");
        String pol = keyboard.next();

        System.out.println("Год рождения: ");
        int date = data.getYear() - keyboard.nextInt();

        System.out.println("INN: ");
        int inn = keyboard.nextInt();

        System.out.println("З/п : ");
        int zp = keyboard.nextInt();

        draw.drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = draw.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        draw.drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = draw.drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        MedSister medSister= new MedSister(null,ot,zp,pol,name,date,inn,idKab,id_otdel,kab);
        serviceMedSister.save(medSister);
    }
    void newOborydovanie() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.print("Название оборудования: ");
        String name = keyboard.next();

        System.out.print("Номер оборудования:");
        int number = keyboard.nextInt();

        System.out.println("Где будет стоять оборудование");
        System.out.println("1. В палате");
        System.out.println("2. В кабинете");
        System.out.println("3. На складе");
        int s=keyboard.nextInt();
        long id_kab = 0L;
        long id_palat = 0L;
        switch (s){
            case 1->{
                draw.drawOtdelList();
                System.out.print("Выберите отдел:");
                draw.drawPalatList( keyboard.nextLong() );
                System.out.print("Выберите палату:");
                id_palat = keyboard.nextLong();
            }
            case 2->{
                draw.drawOtdelList();
                System.out.print("Выберите отдел:");
                draw.drawKabinetList( keyboard.nextLong() );
                System.out.print("Выберите кабинет: ");
                id_kab = keyboard.nextLong();
            }
            case 3->{

            }
        }
        Oborydovanie oborydovanie = new Oborydovanie(null,name,number,id_kab,id_palat);
        serviceOborydovanie.save(oborydovanie);
    }
    void newOtdel() throws SQLException {
        System.out.print("Введите название нового отдела: "); String name = keyboard.next();

        Otdel otdel = new Otdel(null, name);
        serviceOtdel.save(otdel);
    }
    void newPalat() throws SQLException {
        System.out.println("--- Введите данные ---");
        draw.drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = draw.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Palat palat = new Palat(null,id_otdel,ot);
        ServicePalat.save(palat);
        System.out.println("--- Завершено ---");
    }
    void newVrach() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Имя: ");
        String name = keyboard.next();

        System.out.println("Пол: ");
        String pol = keyboard.next();

        System.out.println("Год рождения: ");
        int date = data.getYear() - keyboard.nextInt();

        System.out.println("INN: ");
        int inn = keyboard.nextInt();

        System.out.println("З/п : ");
        int zp = keyboard.nextInt();

        draw.drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = draw.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        draw.drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = draw.drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        Vrach vrach = new Vrach(null, ot, zp, pol, name, date, inn, id_otdel, idKab, kab);
        serviceVrach.save(vrach);
    }
}
