package menu;

import domain.Oborydovanie;
import domain.Otdel;
import domain.Palat;
import repository.SQLOborydovanieRepository;
import repository.SQLOtdelRepository;
import repository.SQLPalatRepository;
import service.Service;
import service.ServiceOborydovanie;
import service.ServiceOtdel;
import service.ServicePalat;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PalatMenu {
    Service<Palat> ServicePalat;
    Service<Otdel> serviceOtdel;
    Service<Oborydovanie> serviceOborydovanie;
    Service<Palat> servicePalat;
    private final OtdelMenu otdelMenu = new OtdelMenu();
    private Menu menu;
    private OborydovanieMenu oborydovanieMenu;
    private final KabinetMenu kabinetMenu = new KabinetMenu();

    Scanner keyboard = new Scanner(System.in);





}
