package Bmw;

import Interface.Wheels;

public class BmwWheels implements Wheels {
    @Override
    public void create() {
        System.out.println("Поставка BMW колес...");
    }
}
