package Bmw;

import Interface.AutoFactory;
import Interface.Body;
import Interface.Engine;
import Interface.Wheels;

public class BmwFactory implements AutoFactory {
    @Override
    public Body getBody() {
        return new BmwBody();
    }

    @Override
    public Engine getEngine() {
        return new BmwEngine();
    }

    @Override
    public Wheels getWheels() {
        return new BmwWheels();
    }
}
