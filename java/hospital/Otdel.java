package test;

public class Otdel {
    private String name;
    private int kolvo;
    private String vrach;

    Otdel(String name,String vrach, int kolvo) {
        this.name = name;
        this.vrach = vrach;
        this.kolvo = kolvo;
    }

    public String getVrach() {
        return vrach;
    }
    public void setVrach(String vrach) {
        this.vrach = vrach;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getKolvo() {
        return kolvo;
    }
    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }


    public String toString() {
        return name + " " + kolvo;
    }

}

