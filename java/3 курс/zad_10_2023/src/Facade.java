import Device.AudioSystem;
import Device.Light;
import Device.Temperature;

import java.util.List;

public class Facade {
    AudioSystem audioSystem = new AudioSystem();
    Light light = new Light();
    Temperature temperature = new Temperature();

    public void setLight(){
        light.action();
    }

    public void setTemperature(String degrees){
        temperature.setDegrees(degrees);
        temperature.show();
    }

    public void setAudioSystem(){
        audioSystem.action();
    }
}
