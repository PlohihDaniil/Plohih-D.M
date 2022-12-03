package menu;

import domain.Otdel;
import repository.SQLOtdelRepository;
import service.Service;
import service.ServiceOtdel;

import java.sql.SQLException;
import java.util.Scanner;

public class OtdelMenu {
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());

    private Menu menu;

    Scanner keyboard = new Scanner(System.in);


    void drawOtdel() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->{
                newOtdel();
            }
            case 2->{
                deleteOtdel();
            }
            case 3->{
                changeOtdel();
            }
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    private void changeOtdel() throws SQLException {
        int q =0;
        drawOtdelList();
        System.out.print("Выберите какой отдел хотите изменить: ");
        Long id= keyboard.nextLong();
        try {

            Otdel otdel = drawSingleOtdel(id);

            while (q==0){
                System.out.println("Выберите что хотите изменить");
                System.out.println("1. Название");
                System.out.println("9. Назад");
                System.out.println("0. Сохранить и выйти");
                int d= keyboard.nextInt();

                switch (d){
                    case 1->{
                        System.out.print("Новое название отдела:"); otdel.setName( keyboard.next() );
                    }
                    case 9->{
                        q=1;
                        drawOtdel();
                    }
                    case 0->{
                        q=1;
                        serviceOtdel.update(otdel);
                        menu.draw();
                    }
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    void deleteOtdel() throws SQLException {
        drawOtdelList();
        System.out.print("Выберите отдел который хотите удалить: ");
        Long id= keyboard.nextLong();
        try {
            Otdel otdel = drawSingleOtdel(id);

            serviceOtdel.delete(otdel);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void newOtdel() throws SQLException {
        System.out.print("Введите название нового отдела: "); String name = keyboard.next();

        Otdel otdel = new Otdel(null, name);
        serviceOtdel.save(otdel);
    }
    Otdel drawSingleOtdel(Long id)throws  SQLException{
        System.out.println("--- Single otdel ---");
        Otdel otdel = serviceOtdel.getById(id);
        System.out.println(otdel);
        return otdel;
    }
    void drawOtdelList() throws SQLException {
        System.out.println();
        System.out.println("--- Otdel list ---");
        serviceOtdel.getAll().forEach(System.out::println);
    }
}
