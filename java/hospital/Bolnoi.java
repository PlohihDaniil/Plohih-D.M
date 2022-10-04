package test;

public class Bolnoi extends Person {
    private String ot;
    private String vrach;

    Bolnoi(String ot, String pol, String name, int date, int inn,String vrach) {
        super(pol, name, date, inn);
        this.ot=ot;
        this.vrach= vrach;
    }

    public String getVrach() {
        return vrach;
    }
    public void setVrach(String vrach) {
        this.vrach = vrach;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }
    public String getOt() {
        return ot;
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
    public void setName(String newName) {
        super.setName(newName);
    }
    @Override
    public void setPol(String pol) {
        super.setPol(pol);
    }

    @Override
    public String toString() {
        return getName()+" "+getPol()+" "+getDate()+" "+getInn()+" "+ getOt()+" "+ getVrach();
    }


}

