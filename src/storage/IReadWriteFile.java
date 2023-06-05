package storage;

import model.ElectronicDevice;

import java.util.List;

public interface IReadWriteFile {

    void writeToFile(List<ElectronicDevice> electronicDevices);
     List<ElectronicDevice> readToFile();
}
