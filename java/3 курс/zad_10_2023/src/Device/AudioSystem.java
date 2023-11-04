package Device;

public class AudioSystem {
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
        System.out.println("Аудиосистема включена.");
        activeTracker = true;
    }
    public void stop(){
        System.out.println("Аудиосистема выключена.");
        activeTracker = false;
    }

    public void switching(){
        if(isActiveTracker()){
            System.out.println("Следущая песня...");
        }else {
            System.out.println("Сначала надо включить");
        }
    }

}
