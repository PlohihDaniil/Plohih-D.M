package Figures;

public class Square extends Figure {
    private int A;

    public Square(int a) {
        A = a;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    @Override
    public String toString() {
        return "Square{" +
                "A=" + A +
                '}';
    }
}
