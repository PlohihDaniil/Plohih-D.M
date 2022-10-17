package test;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kabinet {
    private String name;
    private int number;
    private List<Oborydovanie> ob=new ArrayList<>();

    Kabinet(String name,int number, Oborydovanie...ob){
        this.name=name;
        this.number=number;
        this.ob.addAll((Arrays.asList(ob)));
    }

    public void setOb(Oborydovanie ob) {
        this.ob.add(ob);
    }

    public List<Oborydovanie> getOb() {
        for (int i =0;i<ob.size();i++){
            System.out.println(ob.get(i));
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
            if (a == ob.get(i).getNumber()){
                ob.remove(i);
                System.out.println(i);
            }
        }
    }

    public  void renameOb(int a,String newName){
        for (int i=0;i<ob.size();i++) {
            if (a == ob.get(i).getNumber()){
                ob.get(i).setName(newName);
            }
        }
    }
    public void reIdNumber(int a,int newNumber){
        for (int i=0;i<ob.size();i++) {
            if (a == ob.get(i).getNumber()){
                ob.get(i).setNumber(newNumber);
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
