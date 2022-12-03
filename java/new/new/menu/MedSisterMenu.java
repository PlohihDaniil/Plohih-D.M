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

    Service<MedSister> serviceMedSister;

    Scanner keyboard = new Scanner(System.in);
    private final OtdelMenu otdelMenu = new OtdelMenu();
    private final KabinetMenu kabinetMenu = new KabinetMenu();
    private Menu menu;




}
