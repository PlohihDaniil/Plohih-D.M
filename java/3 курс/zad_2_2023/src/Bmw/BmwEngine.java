package Bmw;

import Interface.Engine;

public class BmwEngine implements Engine {
    @Override
    public void create() {
        System.out.println("Поставка BMW мотора...");
    }
}
