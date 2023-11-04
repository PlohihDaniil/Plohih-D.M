public class Main {
    public static void main(String[] args) {
        Figure figure = new Figure(5,6,7);

        System.out.println(figure);

        Figure figureClone = figure.copy();
        figureClone.setA(10);
        System.out.println("""
                -----------------------------
                """+figureClone);
    }
}