package Audi;

import Interface.AutoFactory;
import Interface.Body;
import Interface.Engine;
import Interface.Wheels;

public class AudiFactory implements AutoFactory {
    @Override
    public Body getBody() {
        return new AudiBody();
    }

    @Override
    public Engine getEngine() {
        return new AudiEngine();
    }

    @Override
    public Wheels getWheels() {
        return new AudiWheels();
    }
}
