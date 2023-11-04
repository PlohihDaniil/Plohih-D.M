package Device;

public class Light {
    private boolean activeTracker;

    public boolean isActiveTracker(){
        return activeTracker;
    }

    public void action(){
        if (isActiveTracker()){
            stop();
        }else {
            start();
        }
    }

    public void start(){
        System.out.println("Свет включен.");
        activeTracker = true;
    }
    public void stop(){
        System.out.println("Свет выключен.");
        activeTracker = false;
    }
}
