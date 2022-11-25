package domain;


import java.util.ArrayList;

import java.util.List;

public class Kabinet {
    private String name;
    private int number;
    private final List<Integer> ob=new ArrayList<>();

    Kabinet(String name,int number){
        this.name=name;
        this.number=number;
        this.ob.addAll(new ArrayList<>());
    }

    public void setOb(int ob) {
        this.ob.add(ob);
    }

    public List<Integer> getOb() {
        for (int oborydovanie : ob) {
            System.out.println(oborydovanie);
        }
        return null;
    }
    public List<Oborydovanie> getIdOb() {
        for (int i =0;i<ob.size();i++){
            System.out.println(i+" "+ob.get(i));
        }
        return null;
    }

    public void delete(int a){
        for (int i=0;i<ob.size();i++) {
            System.out.println(a);
            if (a == ob.get(i)){
                ob.remove(i);
                System.out.println(i);
            }
        }
    }

    public void reIdNumber(int a,int newNumber){
        for (int i=0;i<ob.size();i++) {
            if (a == ob.get(i)){
               // ob.get(i).
            }
        }
    }


    public String splitOb(){
        String g=null;
        for (int i=0;i< ob.size();i++){
            if (g==null){
                g=ob.get(i)+",";
            }
            else{
                g+= ob.get(i)+",";
            }
        }
        return g;
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
        return name + " "+ number;
    }
}
