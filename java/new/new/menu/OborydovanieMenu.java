package menu;

import domain.Oborydovanie;
import repository.SQLOborydovanieRepository;
import service.Service;
import service.ServiceOborydovanie;

import java.sql.SQLException;
import java.util.Scanner;

public class OborydovanieMenu {

    Service<Oborydovanie> serviceOborydovanie;
    private final OtdelMenu otdelMenu = new OtdelMenu();
    private PalatMenu palatMenu;
    private final KabinetMenu kabinetMenu = new KabinetMenu();
    private Menu menu;

    Scanner keyboard = new Scanner(System.in);



}
