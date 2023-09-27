package Devices;

import Other.Figures;
import Other.Task;

public class Monitor extends Task {
    public Monitor(Figures figures) {
        super(figures);
    }

    @Override
    public void conclusion() {
        figures.show("Монитор вывел ");
    }
}
