package domain;

public class Oborydovanie {
    private Long id;

    private String name;
    private int number;
    private Long id_kab;
    private Long id_palat;

    public Oborydovanie(Long id, String name, int number, Long id_kab, Long id_palat){
        this.id=id;
        this.name = name;
        this.number=number;
        this.id_kab=id_kab;
        this.id_palat=id_palat;
    }

    public Long getId_palat() {
        return id_palat;
    }

    public void setId_palat(Long id_palat) {
        this.id_palat = id_palat;
    }

    public Long getId_kab() {
        return id_kab;
    }

    public void setId_kab(Long id_kab) {
        this.id_kab = id_kab;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name+" "+number;
    }

}
