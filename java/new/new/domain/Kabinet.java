package domain;


import java.util.ArrayList;

import java.util.List;

public class Kabinet {
    private Long id;
    private String name;
    private Long id_otdel;
    private String otdel;
    private List<Integer> ob;

    public Kabinet(Long id, String name, Long id_otdel, String otdel){
        this.id=id;
        this.name=name;
        this.id_otdel=id_otdel;
        this.ob=new ArrayList<>();
        this.otdel = otdel;
    }
    public void addOb(Integer o){
        ob.add(o);
    }

    public List<Integer> getOb() {
        return ob;
    }

    public Long getId() {
        return id;
    }

    public void setId_otdel(Long id_otdel) {
        this.id_otdel = id_otdel;
    }

    public Long getId_otdel() {
        return id_otdel;
    }

    public void setOtdel(String otdel) {
        this.otdel = otdel;
    }

    public String getOtdel() {
        return otdel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " "+ name+" "+ otdel;
    }
}
