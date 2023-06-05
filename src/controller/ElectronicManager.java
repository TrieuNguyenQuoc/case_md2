
package controller;

import model.*;
import storage.ReadWriteFile;

import views.Client;

import java.util.List;
import java.util.Scanner;

public class ElectronicManager {
    private static ElectronicManager instance;
    private final List<ElectronicDevice> electronicDevices;
    private final ReadWriteFile readWriteFile = ReadWriteFile.getInstance();

    private ElectronicManager ( ) {
        this.electronicDevices = readWriteFile.readToFile();
    }

    public static ElectronicManager getInstance ( ) {
        if (instance == null) {
            instance = new ElectronicManager();
        }
        return instance;
    }


    public void display ( ) {
        System.out.println(electronicDevices);
    } //In ra màn hình


    public double totalPriceMobilePhone ( ) {//Tổng tiền điện thoại
        double priceMobilePhone = 0;
        double totalPriceMobilePhoneSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof MobilePhone) {
                priceMobilePhone += electronicDevice.getRealMoney();
                totalPriceMobilePhoneSale += (electronicDevice.getAmount() - priceMobilePhone);
            }
        }
        return totalPriceMobilePhoneSale;
    }


    public double totalPricePc ( ) { //Tổng tiền máy tính
        double pricePc = 0;
        double totalPricePcSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof Pc) {
                pricePc += electronicDevice.getRealMoney();
                totalPricePcSale += (electronicDevice.getAmount() - pricePc);
            }
        }
        return totalPricePcSale;
    }

    public double totalPriceFridge ( ) {    //Tổng tiền tủ lạnh
        double totalPriceFridgeSale = 0;
        for (ElectronicDevice electronicDevice :
                electronicDevices) {
            if (electronicDevice instanceof Fridge) {
                totalPriceFridgeSale += (electronicDevice.getAmount() - electronicDevice.getRealMoney());
            }
        }
        return totalPriceFridgeSale;
    }

    public double totalElectronicDeviceBeforeSale ( ) {
        double totalElectroniceDevice = 0;
        for (ElectronicDevice e :
                electronicDevices) {
            totalElectroniceDevice += e.getAmount();
        }
        return totalElectroniceDevice;
    }


    public double priceElectronicDevice ( ) {
        double priceElectronicDevice = 0;
        priceElectronicDevice += totalPriceFridge() + totalPricePc() + totalPriceMobilePhone();//Tổng tiền các sản phẩm sau khuyến mãi
        return priceElectronicDevice;
    }


    public void addElement (ElectronicDevice electronicDevice) {  // Thêm phần tử
        electronicDevices.add(electronicDevice);
        readWriteFile.writeToFile(electronicDevices);
    }


    public void deleteElement (Scanner scanner) {
        System.out.println("Nhập sản phẩm cần xóa theo id: ");// Xóa theo id
        String id = String.valueOf(checkInt(scanner));
        for (ElectronicDevice e :
                electronicDevices) {
            if (electronicDevices.size() == 0) {
                System.out.println("không có gì để xóa ");
                break;
            } else if (id.equals(e.getId())) {
                electronicDevices.remove(e);
                break;

            }
        }
        readWriteFile.writeToFile(electronicDevices);
    }

    public void deleteElectronicDevice ( ) {
        electronicDevices.removeAll(electronicDevices);  // Xóa tất cả phần tử
        readWriteFile.writeToFile(electronicDevices);
    }

    public void payToBill ( ) {
        System.out.println("Tổng số tiền phải trả là:    " + priceElectronicDevice());
//        deleteElectronicDevice();
    }

    public void searchElement (Scanner scanner) {
        int flag = -1;
        System.out.println("Mời bạn nhập tên sản phẩm: ");  //Tìm theo tên
        String searhString = scanner.nextLine();

        for (int i = 0; i < electronicDevices.size(); i++) {
            if (searhString.equals(electronicDevices.get(i).getName())) {
                System.out.println("Sản phẩm là: " + electronicDevices.get(i));
                flag = i;
            }
        }
        if (electronicDevices.size() == 0 || flag < 0) {
            System.out.println("Không tìm thấy sản phẩm");
        }

    }

    public void editElement (Scanner scanner) {//Sửa theo tên sản phẩm
        int flag = -1;
        String newId;
        String newName;
        double newCost;
        String newColor;
        int newQuantity;
        String newCooling;
        String newScreenType;
        String newCard;
        System.out.println("Mởi bạn nhập id sản phẩm: ");
        String id = scanner.nextLine();
        for (ElectronicDevice e : electronicDevices) {
            if (id.equals(e.getId())) {
                System.out.println("Mời bạn nhập id : ");
                newId = getID(scanner);
                System.out.println("Mời bạn nhập tên: ");
                newName = scanner.nextLine();
                System.out.println("Mời bạn nhập giá: ");
                newCost = checkDouble(scanner);
                System.out.println("Mời bạn nhập màu: ");
                newColor = scanner.nextLine();
                System.out.println("Mời bạn nhập số lượng: ");
                newQuantity = checkInt(scanner);
                e.setId(newId);
                e.setName(newName);
                e.setCost(newCost);
                e.setColor(newColor);
                e.setQuantity(newQuantity);
                if (e instanceof Fridge) {
                    System.out.println("Mời bạn nhập kiểu tủ lạnh: ");
                    newCooling = scanner.nextLine();
                    ((Fridge) e).setCooling(newCooling);
                    break;
                } else if (e instanceof Pc) {
                    System.out.println("Mời bạn nhâp kiểu card của pc: ");
                    newCard = scanner.nextLine();
                    ((Pc) e).setCard(newCard);
                    break;
                } else if (e instanceof MobilePhone) {
                    System.out.println("Mời bạn nhập kiểu màn hình của điện thoại: ");
                    newScreenType = scanner.nextLine();
                    ((MobilePhone) e).setScreenType(newScreenType);
                    break;
                }
                break;
            }
            flag = 0;
        }
        if (flag < 0) {
            for (ElectronicDevice e :
                    electronicDevices) {
                if (!id.equals(e.getId())) {
                    System.out.println("""
                            ||=======================================================================||
                            ||       Đã thay thế sản phẩm cần sửa. Bạn có muốn nhập lại không?       ||
                            ||       1. Có, mời bạn nhập lại:                                        ||
                            ||       2. Thoát ra menu.                                               ||
                            ||=======================================================================||
                            """);
                    int inPut = checkInt(scanner);
                    switch (inPut) {
                        case 1:
                            editElement(scanner);
                            break;
                        case 2:
                            Client.menuManage();
                            break;
                        default:
                            System.out.println("Nhập lỗi.");
                    }
                    break;
                }
            }
        }
        readWriteFile.writeToFile(electronicDevices);
    }

    public int checkInt (Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai, mời bạn nhập lại: ");
        }
        return checkInt(scanner);
    }

    public double checkDouble (Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai, mời bạn nhập lại: ");
        }
        return checkDouble(scanner);
    }

    public String getID (Scanner scanner) {
        while (true) {
            try {
                String id = scanner.nextLine();
                if (Regex.validateId(id)) {

                    for (ElectronicDevice e : electronicDevices) {


                        if (e.getId().equals(id)) {
                            throw new Exception();
                        }
                    }
                    return id;
                } else System.out.println("Mời bạn nhập id là số: ");
            } catch (Exception e) {
                System.out.println("Mời bạn nhập id khác: ");
            }
        }
    }
}