package menu;

import domain.*;
import repository.*;
import service.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Delete {
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Bolnoi> serviceBolnoi= new ServiceBolnoi(new SQLBolnoiRepository());
    Service<Kabinet> serviceKabinet= new ServiceKabinet(new SQLKabinetRepository());
    Service<MedSister> serviceMedSister= new ServiceMedSister(new SQLMedSisterRepository());
    Service<Oborydovanie> serviceOborydovanie= new ServiceOborydovanie(new SQLOborydovanieRepository());
    Service<Palat> ServicePalat= new ServicePalat(new SQLPalatRepository());
    Service<Vrach> serviceVrach= new ServiceVrach(new SQLVrachRepository());

    Scanner keyboard = new Scanner(System.in);
    Draw draw;

    public Delete(Draw draw) {
        this.draw=draw;
    }


    void deleteBolnoi() throws SQLException {
        draw.drawBolnoiList();
        System.out.print("Выберите больного которого хотите удалить:");
        Bolnoi bolnoi = draw.drawSingleBolnoi(keyboard.nextLong() );
        serviceBolnoi.delete(bolnoi);
    }
    void deleteKabinet() throws SQLException {
        draw.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        draw.drawKabinetList(id_otdel);
        System.out.println("Выберите какой кабинет зотите удалить: ");
        Long id= keyboard.nextLong();
        Kabinet kabinet = draw.drawSingleKabinet(id);
        serviceKabinet.delete(kabinet);
    }
    void deleteMedSister() throws SQLException {
        draw.drawMedSisterList();
        Long id= keyboard.nextLong();
        MedSister medSister = draw.drawSingleMedSister(id);
        serviceMedSister.delete(medSister);
    }
    void deleteOborydovanie() throws SQLException {
        draw.drawOborydovanieList();
        System.out.print("Выберите какое оборудование удалить :");
        Oborydovanie oborydovanie = draw.drawSingleOborydovanie( keyboard.nextLong() );
        serviceOborydovanie.delete( oborydovanie );
    }
    void deleteOtdel() throws SQLException {
        draw.drawOtdelList();
        System.out.print("Выберите отдел который хотите удалить: ");
        Long id= keyboard.nextLong();
        try {
            Otdel otdel = draw.drawSingleOtdel(id);

            serviceOtdel.delete(otdel);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void deletePalat() throws SQLException {
        draw.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        draw.drawPalatList(id_otdel);
        System.out.println("Выберите какую палату хотите удалить: ");
        Long id= keyboard.nextLong();
        Palat palat = draw.drawSinglePalat(id);
        ServicePalat.delete(palat);
    }
    void deleteVrach() throws SQLException {
        draw.drawVrachList();
        Long id= keyboard.nextLong();
        Vrach vrach = draw.drawSingleVrach(id);
        serviceVrach.delete(vrach);
    }
}
