package Audi;

import Interface.Wheels;

public class AudiWheels implements Wheels {
    @Override
    public void create() {
        System.out.println("Поставка Audi колес...");
    }
}
