package Factory;

import Randomizer.RandomizerValues;

public class BySuitFactoryCards implements FactoryCars {
    RandomizerValues randomizerValues = new RandomizerValues();
    @Override
    public void print(int size,int suit) {
        String x;
        switch (suit){
            case 1 -> x = "Бубей";
            case 2 -> x = "Пик";
            case 3 -> x = "Червей";
            case 4 -> x = "Крестей";
            default -> throw new RuntimeException("Нет такой масти!!!");
        }
        System.out.println( randomizerValues.values(size) + " " + x );
    }
}
