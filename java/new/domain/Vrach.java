package domain;


public class Vrach extends MedPerson {

    private Long id_otdel;
    private String kab;




    public Vrach(Long id, String ot, int zp, String pol, String surname, int date, int inn, Long id_otdel, Long idKab,String kab) {
        super(id,ot, zp, pol, surname, date, inn,idKab);
        this.id_otdel=id_otdel;
        this.kab=kab;

    }

    @Override
    public void setIdKab(Long idKab) {
        super.setIdKab(idKab);
    }

    public String getKab() {
        return kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    @Override
    public String toString() {
        return getId()+" "+ getSurname()+" "+ getPol()+" "+ getDate()+" "+getInn()+" "+ getZp()+" "+ getId_otdel()+" "+getOt() +" "+ getIdKab()+" "+getKab();
    }
}

