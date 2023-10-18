import Abstract.Template;
import Education.Offline;
import Education.Online;
import Education.Webinar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Template offline = new Offline();
        Template online = new Online();
        Template webinar = new Webinar();

        offline.print();
        online.print();
        webinar.print();
    }
}