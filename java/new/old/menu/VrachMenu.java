package menu;

import domain.Kabinet;
import domain.Otdel;
import domain.Vrach;
import repository.SQLVrachRepository;
import service.Service;
import service.ServiceVrach;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class VrachMenu {
    LocalDate data = LocalDate.now();
    Scanner keyboard = new Scanner(System.in);
    Service<Vrach> serviceVrach = new ServiceVrach(new SQLVrachRepository());

    private OtdelMenu otdelMenu;
    private KabinetMenu kabinetMenu;
    private Menu menu;
    private MedSisterMenu medSisterMenu;
    private BolnoiMenu bolnoiMenu;



    void drawVrach() throws SQLException {
        System.out.println("--- Врачи ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newVrach();
            case 2-> deleteVrach();
            case 3-> changeVrach();
            case 9-> menu.drawMedPers();
            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }

    }
    private void changeVrach() throws SQLException {
        int q=0;
        drawVrachList();
        System.out.print("Выберите врача: ");
        long id = keyboard.nextLong();
        Vrach vrach = drawSingleVrach(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Отдел");
            System.out.println("6. Кабинет");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); vrach.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); vrach.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); vrach.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); vrach.setDate( keyboard.nextInt() );
                }
                case 5->{
                    otdelMenu.drawOtdelList();
                    System.out.print("Выберите новый отдел: "); vrach.setId_otdel( keyboard.nextLong() );
                }
                case 6->{
                    kabinetMenu.drawKabinetList( vrach.getId_otdel() );
                    System.out.print("Выберите новый кабинет: ");
                    Kabinet kabinet = kabinetMenu.drawSingleKabinet(keyboard.nextLong() );
                    vrach.setKab(kabinet.getName() );
                    vrach.setIdKab(kabinet.getId() );
                }
                case 9 -> {
                    bolnoiMenu.drawBolnoi();
                    q=1;
                }
                case 0 -> {
                    serviceVrach.update(vrach);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void drawVrachList() throws SQLException {
        System.out.println();
        System.out.println("--- Vrach list ---");
        serviceVrach.getAll().forEach(System.out::println);
    }
    Vrach drawSingleVrach(Long id) throws SQLException {
        System.out.println("--- Single otdel ---");
        Vrach vrach = serviceVrach.getById(id);
        System.out.println(vrach);
        return vrach;
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

        otdelMenu.drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = otdelMenu.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        kabinetMenu.drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = kabinetMenu.drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        Vrach vrach = new Vrach(null, ot, zp, pol, name, date, inn, id_otdel, idKab, kab);
        serviceVrach.save(vrach);
    }
    void deleteVrach() throws SQLException {
        drawVrachList();
        Long id= keyboard.nextLong();
        Vrach vrach = drawSingleVrach(id);
        serviceVrach.delete(vrach);
    }
}
