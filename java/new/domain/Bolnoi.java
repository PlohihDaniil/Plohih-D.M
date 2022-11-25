package domain;


import java.util.ArrayList;
import java.util.List;

public class Bolnoi extends Person {
    private String ot;
    private List<String> vrach;



    public Bolnoi(Long id, String ot, String pol, String name, int date, int inn ) {
        super(id,pol, name, date, inn);
        this.ot=ot;
        this.vrach=new ArrayList<>();
    }


    public void addVrach(String name){
        vrach.add(name);
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    @Override
    public void setDate(int date) {
        super.setDate(date);
    }
    @Override
    public void setInn(int inn) {
        super.setInn(inn);
    }
    @Override
    public void setSurname(String newName) {
        super.setSurname(newName);
    }
    @Override
    public void setPol(String pol) {
        super.setPol(pol);
    }

    public List<String> getVrach() {
        return vrach;
    }

    @Override
    public String toString() {

        return getId()+" " + getSurname()+" " + getPol()+" " + getDate()+" " + getInn()+" " + ot + vrach;
    }




}

