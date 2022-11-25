package test;

import domain.Bolnoi;
import domain.Otdel;
import menu.Menu;
import repository.Repository;
import repository.SQLBolnoiRepository;
import repository.SQLOtdelRepository;
import service.Service;
import service.ServiceBolnoi;
import service.ServiceOtdel;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Repository<Bolnoi> repository = new SQLBolnoiRepository();
        Service<Bolnoi> serviceBolnoi = new ServiceBolnoi(repository);

        Repository<Otdel> repositoryOtdel = new SQLOtdelRepository();
        Service<Otdel> serviceOtdel = new ServiceOtdel(repositoryOtdel);

        Menu menu = new Menu(serviceBolnoi, serviceOtdel);

        while (true) {
            menu.draw();
        }

}
}