package domain;

public class Palat {
    private Long id;
    private Long id_otdel;
    private String name_otdel;


    public Palat(Long id,Long id_otdel,String name_otdel) {
        this.id = id;
        this.id_otdel=id_otdel;
        this.name_otdel=name_otdel;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setName_otdel(String name_otdel) {
        this.name_otdel = name_otdel;
    }

    public String getName_otdel() {
        return name_otdel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return id+" " + name_otdel;
    }
}
