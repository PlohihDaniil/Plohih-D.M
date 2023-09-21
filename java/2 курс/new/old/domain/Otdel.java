package domain;

public class Otdel {

    private Long id;
    private String name;


    public Otdel(Long id, String name) {
        this.id=id;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return id+" "+ name;
    }

}

