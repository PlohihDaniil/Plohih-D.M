public class Figure implements Copyable {
    private int A;
    private int B;
    private int C;

    public Figure(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    @Override
    public Figure copy() {
        Figure copy = new Figure(A,B,C);
        return copy;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
