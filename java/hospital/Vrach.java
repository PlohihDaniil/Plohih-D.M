package test;

public class Vrach extends Person{
    private int zp;
    private String ot;

    Vrach(String ot, int zp,String pol, String name, int date, int inn) {
        super(pol, name, date, inn);
        this.zp=zp;
        this.ot=ot;
    }


    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getOt() {
        return ot;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    public int getZp() {
        return zp;
    }

    @Override
    public void setName(String newName) {
        super.setName(newName);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setInn(int inn) {
        super.setInn(inn);
    }
    @Override
    public void setDate(int date) {
        super.setDate(date);
    }
    @Override
    public void setPol(String pol) {
        super.setPol(pol);
    }

    @Override
    public String toString() {
        return ot+" "+getName()+" "+getPol()+" "+ getInn()+" "+zp;
    }
}

