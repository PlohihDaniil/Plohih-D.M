package Devices;

import Other.Figures;
import Other.Task;

public class Printer extends Task{

    public Printer(Figures figures) {
        super(figures);
    }

    @Override
    public void conclusion() {
        figures.show("Принтер напечатал ");
    }
}
