package Lada;

import Interface.AutoFactory;
import Interface.Body;
import Interface.Engine;
import Interface.Wheels;

public class LadaFactory implements AutoFactory {
    @Override
    public Body getBody() {
        return new LadaBody();
    }

    @Override
    public Engine getEngine() {
        return new LadaEngine();
    }

    @Override
    public Wheels getWheels() {
        return new LadaWheel();
    }
}
