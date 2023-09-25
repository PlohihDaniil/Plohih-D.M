package Audi;

import Interface.Body;

public class AudiBody implements Body {
    @Override
    public void create() {
        System.out.println("Поставка Audi корпуса...");
    }
}
