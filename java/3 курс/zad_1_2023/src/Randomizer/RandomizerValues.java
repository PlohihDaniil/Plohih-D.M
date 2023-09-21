package Randomizer;

import java.util.Random;

public class RandomizerValues {

    public String values (int size){

        Random random = new Random();

        switch ( random.nextInt(size/4) ){
            case 0 -> {
                return "T";
            }
            case 1 -> {
                return "K";
            }
            case 2 -> {
                return "D";
            }
            case 3 -> {
                return "B";
            }
            case 4 -> {
                return "10";
            }
            case 5 -> {
                return "9";
            }
            case 6 -> {
                return "8";
            }
            case 7 -> {
                return "7";
            }
            case 8 -> {
                return "6";
            }
            case 9 -> {
                return "5";
            }
            case 10 -> {
                return "4";
            }
            case 11 -> {
                return "3";
            }
            case 12 -> {
                return "2";
            }

            default -> throw new RuntimeException("Ошибка в назначении достоинство карты");
        }
    }
}
