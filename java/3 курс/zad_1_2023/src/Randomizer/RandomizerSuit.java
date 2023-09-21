package Randomizer;

import java.util.Random;

public class RandomizerSuit {

    public String suit(){

        Random random = new Random();

        switch ( random.nextInt(4) ){
            case 0 -> {
                return "Cv";
            }
            case 1 -> {
                return "Pk";
            }
            case 2 -> {
                return "Bb";
            }
            case 3 -> {
                return "Ks";
            }
            default -> throw new RuntimeException("Ошибка в назначении масти карты") ;
        }

    }
}
