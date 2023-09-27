package Devices;

import Other.Figures;
import Other.Task;

public class Plotter extends Task {
    public Plotter(Figures figures) {
        super(figures);
    }

    @Override
    public void conclusion() {
        figures.show("Плоттер вырезал ");
    }
}
