package Device;

public class Temperature {
    private String degrees = "0";

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public void show(){
        System.out.println("Установленная температура -> " + degrees);
    }

}
