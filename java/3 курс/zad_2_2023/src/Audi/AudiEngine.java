package Audi;

import Interface.Engine;

public class AudiEngine implements Engine {
    @Override
    public void create() {
        System.out.println("Поставка Audi мотора...");
    }
}
