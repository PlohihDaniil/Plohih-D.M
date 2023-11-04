import Figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class TeamFigures {
    private List<Figure> figures = new ArrayList<Figure>();

    public void addFigures(Figure figure){
        figures.add(figure);
    }
    public void removeFigure(Figure figure){
        figures.remove(figure);
    }
    public void createFigureTeam(){
        System.out.println("Team figures:\n");
        for (Figure figures : figures) {
            System.out.println(figures);
        }
    }
}
