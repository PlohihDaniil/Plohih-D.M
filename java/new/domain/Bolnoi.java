package domain;


import java.util.ArrayList;
import java.util.List;

public class Bolnoi extends Person {
    private String ot;
    private List<String> vrach;

    private List<Long> vrachIdList;
    private Long id_palat;
    private List<Vrach> vrachList;
    private Long id_otdel;




    public Bolnoi(Long id, String ot, String pol, String name, int date, int inn,Long id_palat,Long id_otdel ) {
        super(id,pol, name, date, inn);
        this.ot=ot;
        this.vrach=new ArrayList<>();
        this.vrachIdList = new ArrayList<>();
        this.id_palat = id_palat;
        this.vrachList = new ArrayList<>();
        this.id_otdel = id_otdel;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public void addVrachList(Vrach vrach){
        vrachList.add(vrach);
    }

    public List<Vrach> getVrachList() {
        return vrachList;
    }

    public Long getId_palat() {
        return id_palat;
    }

    public void setId_palat(Long id_palat) {
        this.id_palat = id_palat;
    }

    public List<Long> getIdVrachList() {
        return vrachIdList;
    }

    public void addIdVrach(Long id) {
        vrachIdList.add(id);
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

        return getId()+" " + getSurname()+" " + getPol()+" " + getDate()+" " + getInn()+" "+getId_palat()+" " + ot + vrach;
    }




}

