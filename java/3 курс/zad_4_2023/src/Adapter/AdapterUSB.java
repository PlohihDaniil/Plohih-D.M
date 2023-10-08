package Adapter;

import Devices.USB;
import Interface.Actions;

public class AdapterUSB extends USB implements Actions {
    @Override
    public void read() {
        readFile();
    }

    @Override
    public void write() {
        writeFile();
    }
}
