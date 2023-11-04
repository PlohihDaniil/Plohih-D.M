public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.setLight();
        facade.setTemperature("-5");
        facade.setAudioSystem();
        facade.audioSystem.switching();

    }
}