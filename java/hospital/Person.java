package test;

public class Person {

    private String pol;
    private String name;
    private int date;
    private int inn;

    Person(String pol, String name, int date, int inn) {

        this.pol = pol;
        this.name = name;
        this.date = date;
        this.inn = inn;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public String getPol() {
        return pol;
    }

    public int getDate() {
        return date;
    }

    public int getInn() {
        return inn;
    }

}
