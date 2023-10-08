package Adapter;

import Devices.SD;
import Interface.Actions;

public class AdapterSD extends SD implements Actions {
    @Override
    public void read() {
        readFile();
    }

    @Override
    public void write() {
        writeFile();
    }
}
