package storage;

import model.ElectronicDevice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile {
    private  ReadWriteFile() {}

    private static ReadWriteFile instance;

    public static ReadWriteFile getInstance() {
        if (instance == null) {
            return instance = new ReadWriteFile();
        }
        return instance;
    }
    public void writeToFile(List<ElectronicDevice> electronicDevices) {
        File file = new File("case_module_2.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(electronicDevices);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<ElectronicDevice> readToFile() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("case_module_2.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectInputStream != null) {
                List<ElectronicDevice> electronicDevices;
                try {
                    electronicDevices = (List<ElectronicDevice>) objectInputStream.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);

                }
                return electronicDevices;
            } else {
                return new ArrayList<>();
            }
        }

    }

}
