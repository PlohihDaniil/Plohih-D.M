package test;

public class Otdel {
    private String name;
    private int kolvoBol;
    private int KolvoVrach;

    Otdel(String name,int KolvoVrach, int kolvoBol) {
        this.name = name;
        this.KolvoVrach = KolvoVrach;
        this.kolvoBol = kolvoBol;
    }

    public int getKolvoVrach() {
        return KolvoVrach;
    }
    public void setKolvoVrach(int vrach) {
        this.KolvoVrach = vrach;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getKolvo() {
        return kolvoBol;
    }
    public void setKolvoBol(int kolvoBol) {
        this.kolvoBol = kolvoBol;
    }


    public String toString() {
        return name + "\t\t\t" + KolvoVrach + "\t\t\t\t\t" + kolvoBol;
    }

}

