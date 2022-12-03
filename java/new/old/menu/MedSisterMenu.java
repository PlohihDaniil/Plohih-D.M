package menu;

import domain.Kabinet;
import domain.MedSister;
import domain.Otdel;
import repository.SQLMedSisterRepository;
import service.Service;
import service.ServiceMedSister;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MedSisterMenu {
    LocalDate data = LocalDate.now();

    Service<MedSister> serviceMedSister = new ServiceMedSister(new SQLMedSisterRepository());

    Scanner keyboard = new Scanner(System.in);
    private OtdelMenu otdelMenu;
    private KabinetMenu kabinetMenu;
    private Menu menu;


    private void deleteMedSister() throws SQLException {
        drawMedSisterList();
        Long id= keyboard.nextLong();
        MedSister medSister = drawSingleMedSister(id);
        serviceMedSister.delete(medSister);
    }
    void drawMedSister() throws SQLException {
        System.out.println("--- Мед сестры ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newMedSister();
            case 2-> deleteMedSister();
            case 3-> changeMedSister();

            case 9-> menu.drawMedPers();
            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    private void changeMedSister() throws SQLException {
        int q=0;
        drawMedSisterList();
        System.out.print("Выберите мед сестру: ");
        long id = keyboard.nextLong();
        MedSister medSister = drawSingleMedSister(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Отедал и кабинет");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); medSister.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); medSister.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); medSister.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); medSister.setDate( keyboard.nextInt() );
                }
                case 5->{
                    Long id_otdel=keyboard.nextLong();
                    System.out.println("Выберите новый отдел: ");otdelMenu.drawOtdelList(); medSister.setId_otdel( id_otdel );
                    System.out.println("Выберите новый кабинет: ");kabinetMenu.drawKabinetList(id_otdel); medSister.setIdKab( keyboard.nextLong() );
                }
                case 9 -> {
                    drawMedSister();
                    q=1;
                }
                case 0 -> {
                    serviceMedSister.update(medSister);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
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

        otdelMenu.drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = otdelMenu.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        kabinetMenu.drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = kabinetMenu.drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        MedSister medSister= new MedSister(null,ot,zp,pol,name,date,inn,idKab,id_otdel,kab);
        serviceMedSister.save(medSister);
    }
    MedSister drawSingleMedSister(Long id) throws SQLException {
        return serviceMedSister.getById(id);
    }
    void drawMedSisterList() throws SQLException {
        System.out.println();
        System.out.println("--- Med sister list ---");
        serviceMedSister.getAll().forEach(System.out::println);
    }
}
