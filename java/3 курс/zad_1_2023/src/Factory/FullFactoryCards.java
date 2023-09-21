package Factory;

import Randomizer.RandomizerSuit;
import Randomizer.RandomizerValues;

public class FullFactoryCards implements FactoryCars {
    RandomizerSuit randomizerSoit = new RandomizerSuit();
    RandomizerValues randomizerValues = new RandomizerValues();

    @Override
    public void print(int size,int suit) {
        System.out.println( randomizerValues.values(size) + " " + randomizerSoit.suit() );
    }
}
