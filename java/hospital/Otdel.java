package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Otdel {
    private String name;
    private int kolvoBol;
    private int KolvoVrach;
    private List<String> vr = new ArrayList<>();

    Otdel(String name, int KolvoVrach, int kolvoBol, String...vr) {
        this.name = name;
        this.KolvoVrach = KolvoVrach;
        this.kolvoBol = kolvoBol;
        this.vr.addAll((Arrays.asList(vr)));
    }

    public void setVr(String vr) {
        this.vr.add(vr);
    }

    public List<String> getVr() {
        for (int i =0;i<vr.size();i++){
            System.out.println(vr.get(i));
        }
        return null;
    }

    public void delete(String a){
        for (int i=0;i<vr.size();i++) {
            if ( a.equals(vr.get(i)) ){
                vr.remove(i);
            }
        }
    }


    public String splitVr(){
        String g=String.join(",",vr);
        return g;
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

