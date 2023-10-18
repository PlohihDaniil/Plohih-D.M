package User;

import Interface.Observer;

import java.util.List;

public class Subscriber implements Observer {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handEvent(List<String> weather) {
        System.out.println(name + ". У нас для вас новые погодные новости:\n" + weather+ """
                
                ---------------------------------------------------------------
                """);
    }
}
