package Lada;

import Interface.Wheels;

public class LadaWheel implements Wheels {
    @Override
    public void create() {
        System.out.println("Поставка LADA колес...");
    }
}
