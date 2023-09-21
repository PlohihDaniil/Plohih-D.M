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
    Service<Vrach> serviceVrach;

    private final OtdelMenu otdelMenu = new OtdelMenu();
    private final KabinetMenu kabinetMenu = new KabinetMenu();
    private Menu menu;
    private  BolnoiMenu bolnoiMenu ;







}
