package domain;

public class MedPerson extends Person {
    private int zp;
    private String ot;

    MedPerson(Long id,String ot, int zp,String pol, String name, int date, int inn) {
        super(id,pol, name, date, inn);
        this.zp=zp;
        this.ot=ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    @Override
    public void setSurname(String newName) {
        super.setSurname(newName);
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
        return ot+" "+zp;
    }



}
