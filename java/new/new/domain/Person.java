package domain;

public class Person {
    private Long id;

    private String pol;
    private String surname;
    private int date;
    private int inn;

    Person(Long id ,String pol, String surname, int date, int inn) {
        this.id = id;
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

    public int getInn() {
        return inn;
    }

    public int getDate() {
        return date;
    }

    public String getPol() {
        return pol;
    }

    public long getId() {
        return id;
    }
}
