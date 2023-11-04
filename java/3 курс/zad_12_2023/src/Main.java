import Figures.Circle;
import Figures.Figure;
import Figures.Square;
import Figures.Triangle;

public class Main {
    public static void main(String[] args) {
        TeamFigures team = new TeamFigures();

        Figure circle = new Circle(5);
        Figure square = new Square(6);
        Figure triangle = new Triangle(7,8,2);

        team.addFigures(circle);
        team.addFigures(square);
        team.addFigures(triangle);

        team.createFigureTeam();

    }
}