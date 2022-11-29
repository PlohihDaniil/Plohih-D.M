package test;

import domain.*;
import menu.Menu;
import repository.*;
import service.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Repository<Bolnoi> repositoryBolnoi = new SQLBolnoiRepository();
        Service<Bolnoi> serviceBolnoi = new ServiceBolnoi(repositoryBolnoi);

        Repository<Otdel> repositoryOtdel = new SQLOtdelRepository();
        Service<Otdel> serviceOtdel = new ServiceOtdel(repositoryOtdel);

        Repository<Vrach> repositoryVrach = new SQLVrachRepository();
        Service<Vrach> serviceVrach = new ServiceVrach(repositoryVrach);

        Repository<MedSister> repositoryMedSister = new SQLMedSisterRepository();
        Service<MedSister> ServiceMedSister = new ServiceMedSister(repositoryMedSister);

//        Repository<Palat> repositoryPalat = new SQLPalatRepository();
        Service<Palat> ServicePalat = new ServicePalat(new SQLPalatRepository());

        Repository<Kabinet> repositoryKabinet = new SQLKabinetRepository();
        Service<Kabinet> ServiceKabinet = new ServiceKabinet(repositoryKabinet);

        Repository<Oborydovanie> repositoryOborydovanie = new SQLOborydovanieRepository();
        Service<Oborydovanie> ServiceOborydovanie = new ServiceOborydovanie(repositoryOborydovanie);

        Menu menu = new Menu(serviceBolnoi, serviceOtdel, serviceVrach, ServiceMedSister, ServicePalat, ServiceKabinet,ServiceOborydovanie);

        while (true) {
            menu.draw();
        }

}
}