package menu;

import domain.*;
import repository.SQLBolnoiRepository;
import repository.SQLOtdelRepository;
import repository.SQLVrachRepository;
import service.Service;
import service.ServiceBolnoi;
import service.ServiceOtdel;
import service.ServiceVrach;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BolnoiMenu {
    LocalDate data = LocalDate.now();
    Service<Bolnoi> serviceBolnoi = new ServiceBolnoi(new SQLBolnoiRepository());
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Vrach> serviceVrach = new ServiceVrach(new SQLVrachRepository());

    private PalatMenu palatMenu;
    private OtdelMenu otdelMenu;
    private VrachMenu vrachMenu;
    private Menu menu;

    Scanner keyboard = new Scanner(System.in);


    // TODO: 28.11.2022 больные
    void changeBolnoi() throws SQLException {
        int q=0;
        drawBolnoiList();
        System.out.print("Выберите больного: ");
        long id = keyboard.nextLong();
        Bolnoi bolnoi = drawSingleBolnoi(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Палату");
            System.out.println("6. Врачей");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); bolnoi.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); bolnoi.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); bolnoi.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); bolnoi.setDate( keyboard.nextInt() );
                }
                case 5->{
                    System.out.println("Выберите новую палату : ");palatMenu.drawPalatList( bolnoi.getId_otdel() ); bolnoi.setId_palat( keyboard.nextLong() );
                }
                case 6->{
                    System.out.println("В разработке!!!");
                }
                case 9 -> {
                    drawBolnoi();
                    q=1;
                }
                case 0 -> {
                    serviceBolnoi.update(bolnoi);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void drawBolnoi() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){

            case 1 ->newBolnoi();
            case 2-> deleteBolnoi();
            case 3-> changeBolnoi();
            case 9-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    Bolnoi drawSingleBolnoi(Long id) throws SQLException {
        System.out.println("---- Single bolnoi ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
        return bolnoi;
    }
    void newBolnoi() throws SQLException {
        System.out.println("Введите данные больного");
        System.out.print("Имя: ");String name = keyboard.next();
        System.out.print("Пол: ");String pol = keyboard.next();
        System.out.print("Год рождения: ");int date = data.getYear() - keyboard.nextInt();
        System.out.print("ИНН: ");int inn = keyboard.nextInt();

        otdelMenu.drawOtdelList();
        System.out.print("Выберите отделение:");
        long id_otdel = keyboard.nextLong();

        palatMenu.drawPalatList(id_otdel);
        System.out.println("Выберите палату в которую хотите отправить больного: ");
        Long id =keyboard.nextLong();

        Otdel otdel = serviceOtdel.getById(id_otdel);

        String ot = otdel.getName();

        Bolnoi o = new Bolnoi(null,ot,pol,name,date,inn,id,id_otdel);
        int q=0;

        vrachMenu.drawVrachList();
        System.out.println("Выбирете врачей для больного:");

        while (q==0){
            Long id_vrach= keyboard.nextLong();

            Vrach vrach = vrachMenu.drawSingleVrach(id_vrach);
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
    void drawBolnoiList() throws SQLException {
        System.out.println();
        System.out.println("---- Bolnoi list ----");
        serviceBolnoi.getAll().forEach(System.out::println);
    }
    void deleteBolnoi() throws SQLException {
        drawBolnoiList();
        System.out.print("Выберите больного которого хотите удалить:");
        Bolnoi bolnoi = drawSingleBolnoi(keyboard.nextLong() );
        serviceBolnoi.delete(bolnoi);
    }
    void drawListBolnoiPoVrach() throws SQLException {
        List<Vrach> vraches=serviceVrach.getAll();
        System.out.println("--- Список больных по врачам ---");
        for (Vrach vrach : vraches) {

            System.out.println(vrach.getId() + " " + vrach.getSurname());
            List<Bolnoi> list = serviceBolnoi.listPoId(vrach.getId());
            if (list.size() != 0) {
                for (Bolnoi bolnoi : list) {
                    System.out.println("   " + bolnoi.getId() + " " + bolnoi.getSurname());
                }
            } else {
                System.out.println("--- Пусто ---");
            }
        }
    }


}
