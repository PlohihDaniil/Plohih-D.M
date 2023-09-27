package Other;

public abstract class Task {
    public Figures figures;

    public Task(Figures figures) {
        this.figures = figures;
    }

    public abstract void conclusion();

}
