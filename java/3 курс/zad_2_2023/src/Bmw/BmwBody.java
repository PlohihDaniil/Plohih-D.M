package Bmw;

import Interface.Body;

public class BmwBody implements Body {
    @Override
    public void create() {
        System.out.println("Поставка BMW корпуса...");
    }
}
