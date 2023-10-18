package Abstract;

public abstract class Template {
    public void print(){
        System.out.println("\n-----------------------------\n");

        System.out.println("НАЧАЛИ");
        show();
        System.out.println("ЗАКОНЧИЛИ");
    }

    public abstract void show();
}
