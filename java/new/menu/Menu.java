package menu;

import domain.Bolnoi;
import domain.Otdel;
import service.Service;

import javax.crypto.spec.PSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    LocalDate data = LocalDate.now();

    Scanner keyboard = new Scanner(System.in);
    private final Service<Bolnoi> serviceBolnoi;
    private final Service<Otdel> serviceOtdel;

    public Menu(Service<Bolnoi> serviceBolnoi, Service<Otdel> serviceOtdel) {
        this.serviceBolnoi = serviceBolnoi;
        this.serviceOtdel = serviceOtdel;
    }

    public void draw() throws SQLException {
        System.out.println("------ MENU ------");

        System.out.println("1. Отделы");
        System.out.println("2. Больные");
        System.out.println("3. Мед персонал");
        System.out.println("4. Оборудование");
        System.out.println("5. Кабинеты");
        System.out.println("6. Списки");
        System.out.println("9. Выход");

        execute();
    }

    private void execute() throws SQLException {
        int command = keyboard.nextInt();

        switch (command) {
            case 1 -> drawOtdel();
            case 2 -> drawBolnoi();



            case 6->drawLists();
            case 9 -> System.exit(0);
            default -> throw new IllegalArgumentException("No command found");
        }
    }
    private void drawLists() throws SQLException {
        System.out.println("1. Вывести весь список больных");
        System.out.println("2. Вывести весь список врачей");
        System.out.println("3. Вывести весь список отделений");
        System.out.println("");
        System.out.println("9. Назад в меню");
        int d=keyboard.nextInt();

        switch (d){
            case 1 -> {
                drawBolnoiList();
                draw();
            }
            case 2 -> {
                System.out.println("Разработка!!!");
                drawLists();
            }

            case 3 -> {
                System.out.println("Разработка!!!");
                drawLists();
            }
            case 9-> draw();
        }
    }

    private void drawOtdel(){
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 -> System.out.println("!!!");
        }
    }
    private void drawBolnoi() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->newBolnoi();

            case 3->changeBolnoi();
            case 9-> draw();
        }
    }

    private void changeBolnoi() throws SQLException {
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
        System.out.println("5. Отдел");
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
                System.out.println("В разработке!!!");
            }
            case 9->drawBolnoi();
            case 0 -> {
                serviceBolnoi.update(bolnoi);
                draw();
            }
        }
    }
    }

    private Bolnoi drawSingleBolnoi(Long id) throws SQLException {
        System.out.println("---- Single object ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
        return bolnoi;
    }

    private void newBolnoi(){
        System.out.println("Введите данные больного");
        System.out.print("Имя: ");String name = keyboard.next();
        System.out.print("Пол: ");String pol = keyboard.next();
        System.out.print("Год рождения: ");int date = data.getYear() - keyboard.nextInt();
        System.out.print("ИНН: ");int inn = keyboard.nextInt();

        Bolnoi o = new Bolnoi(null,null,pol,name,date,inn);
        serviceBolnoi.save(o);
    }

    private void drawSingleObject() throws SQLException {
        System.out.print("Enter object id: ");
        long id = keyboard.nextLong();
        System.out.println("---- Single object ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
    }

    private void drawBolnoiList() {
        System.out.println("---- Objects list ----");
        serviceBolnoi.getAll().forEach(System.out::println);
    }

}
