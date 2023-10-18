package City;

import Interface.Observed;
import Interface.Observer;

import java.util.ArrayList;
import java.util.List;

public class Voronezh implements Observed {
    List<String> weather = new ArrayList<>();

    List<Observer> subscriber = new ArrayList<>();

    public void addWeather (String weather){
        this.weather.add(weather);
        notifyObserver();
    }

    public void removeWeather(String weather){
        this.weather.remove(weather);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscriber.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscriber.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer :subscriber) {
            observer.handEvent(this.weather);
        }
    }
}
