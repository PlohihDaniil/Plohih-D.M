package Lada;

import Interface.Engine;

public class LadaEngine implements Engine {
    @Override
    public void create() {
        System.out.println("Поставка LADA мотора...");
    }
}
