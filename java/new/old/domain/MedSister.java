package domain;

public class MedSister extends MedPerson {
    private Long id_otdel;
    private String kab;

    public MedSister(Long id, String ot, int zp, String pol, String name, int date, int inn, Long idKab, Long id_otdel,String kab) {
        super(id,ot, zp, pol, name, date, inn, idKab);
        this.id_otdel=id_otdel;
        this.kab=kab;
    }

    public void setKab(String kab) {
        this.kab = kab;
    }

    public String getKab() {
        return kab;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    @Override
    public String toString() {
        return getId() +" "+ getSurname() +" ";
    }
}
