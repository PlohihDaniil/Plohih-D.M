package test;

public class Person {

    private String pol;
    private String surname;
    private int date;
    private int inn;

    Person(String pol, String surname, int date, int inn) {

        this.pol = pol;
        this.surname = surname;
        this.date = date;
        this.inn = inn;
    }

    public void setSurname(String newName) {
        this.surname = newName;
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

    public String getSurname() {
        return surname;
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
