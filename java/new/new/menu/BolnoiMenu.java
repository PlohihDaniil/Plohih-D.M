package menu;

import domain.*;
import repository.SQLBolnoiRepository;
import repository.SQLOtdelRepository;
import repository.SQLVrachRepository;
import service.Service;
import service.ServiceBolnoi;
import service.ServiceOtdel;
import service.ServiceVrach;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BolnoiMenu {
    LocalDate data = LocalDate.now();
    Service<Bolnoi> serviceBolnoi;
    Service<Otdel> serviceOtdel;
    Service<Vrach> serviceVrach;

    private final PalatMenu palatMenu = new PalatMenu();
    private final OtdelMenu otdelMenu = new OtdelMenu();
    private  VrachMenu vrachMenu;
    private Menu menu;

    Scanner keyboard = new Scanner(System.in);


    // TODO: 28.11.2022 больные




}
