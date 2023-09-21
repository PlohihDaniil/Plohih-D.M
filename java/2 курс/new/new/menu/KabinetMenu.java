package menu;

import domain.Kabinet;
import domain.Oborydovanie;
import domain.Otdel;
import repository.SQLKabinetRepository;
import repository.SQLOborydovanieRepository;
import repository.SQLOtdelRepository;
import service.Service;
import service.ServiceKabinet;
import service.ServiceOborydovanie;
import service.ServiceOtdel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class KabinetMenu {
    Service<Kabinet> serviceKabinet;
    Service<Otdel> serviceOtdel;
    Service<Oborydovanie> serviceOborydovanie;
    private OtdelMenu otdelMenu = new OtdelMenu();
    private Menu menu;
    private OborydovanieMenu oborydovanieMenu = new OborydovanieMenu();
    Scanner keyboard = new Scanner(System.in);



}
