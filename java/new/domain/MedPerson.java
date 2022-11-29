package domain;

public class MedPerson extends Person {
    private int zp;
    private String ot;
    private Long idKab;

    MedPerson(Long id, String ot, int zp, String pol, String name, int date, int inn, Long idKab) {
        super(id,pol, name, date, inn);
        this.zp=zp;
        this.ot=ot;
        this.idKab= idKab;
    }



    public Long getIdKab() {
        return idKab;
    }

    public void setIdKab(Long idKab) {
        this.idKab = idKab;
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




}
