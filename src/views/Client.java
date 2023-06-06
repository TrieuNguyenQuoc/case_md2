package views;

import controller.ElectronicManager;
import model.ElectronicDevice;
import model.Fridge;
import model.MobilePhone;
import model.Pc;

import java.util.Scanner;

import static login.Login.login;

public class Client {
    public static ElectronicManager admin = ElectronicManager.getInstance();
    public static Scanner checkInput = new Scanner(System.in);

    public static void main (String[] args) {
        login();
    }

    public static void menuManage ( ) {
        while (true) {
            System.out.println("===========================Menu của quản lý===========================");
            System.out.println("""
                    ||===================================================================||
                    ||    Mời chọn:                                                      ||
                    ||    1.  Hiển thị danh sách các sản phẩm có trong cửa hàng :        ||
                    ||    2.  Tổng tiền:                                                 ||
                    ||    3.  Thêm sản phẩm:                                             ||
                    ||    4.  Sửa sản phẩm:                                              ||
                    ||    5.  Xoá sản phẩm theo id:                                      ||
                    ||    6.  Tìm kiếm theo tên của sản phẩm:                            ||
                    ||    7.  Thanh toán                                                 ||
                    ||    8.  Mua hàng                                                   ||
                    ||    9.  Đăng xuất:                                                 ||
                    ||    10. thoát khỏi trương trình:                                   ||  
                    ||===================================================================||
                    """);
            System.out.println("Mời bạn nhập:");
            int choice = Integer.parseInt(checkInput.nextLine());
            switch (choice) {
                case 1:

                    admin.display();
                    break;
                case 2:

                    System.out.println(admin.priceElectronicDevice());
                    break;
                case 3:

                    admin.addElement(addElectronicDevice());
                    break;
                case 4:

                    admin.editElement(checkInput);
                    break;
                case 5:
                    admin.deleteElement(checkInput);
                    System.out.println("Đã sóa thành công!");
                    break;
                case 6:
                    admin.searchElement(checkInput);
                    break;
                case 7:
                    admin.payToBill();
                    break;
                case 8:
                    admin.buyElectronicDevice();
                    break;
                case 9:
                    login();
                default:
                    System.out.println("Nhập sai dữ liệu");
                case 10:
                    return;
                case 11:
            }
        }
    }

    public static void menuStaff ( ) {
        while (true) {
            System.out.println("==============Menu nhân viên==============");
            System.out.println("""
                    ||=======================================||
                    ||   Lựa chọn:                           ||
                    ||   1. Danh sách sản phẩm:              ||
                    ||   2. Tổng tiền sản phẩm:              ||
                    ||   3. Thanh toán:                      ||
                    ||   4. Đăng xuất.                       ||
                    ||   0. Thoát khỏi trương trình.         ||
                    ||=======================================||
                    """);

            int choice = Integer.parseInt(checkInput.nextLine());
            switch (choice) {
                case 1:
                    admin.display();
                    break;
                case 2:
                    admin.payToBill();
                    System.out.println(admin.priceElectronicDevice());
                    break;
                case 0:
                    return;
                case 3:
                    admin.buyElectronicDevice();
                    break;
                case 4:
                    System.out.println("Bạn đã đăng xuất!");
                    login();
            }
        }
    }

    public static ElectronicDevice addElectronicDevice ( ) {
        while (true) {
            System.out.println("Bạn muốn thêm sản phẩm nào? ");
            System.out.println("1. Thêm điện thoại: ");
            System.out.println("2. Thêm máy tính: ");
            System.out.println("3. Thêm tủ lạnh: ");
            System.out.println("0. Thoát ra");
            System.out.println("Mời bạn nhập:");
            int choice = Integer.parseInt(checkInput.nextLine());
            switch (choice) {
                case 1: {
                    System.out.println("Nhập id điện thoại:");
                    String id = admin.getID(checkInput);
                    System.out.println("Nhập tên điện thoại:");
                    String name = checkInput.nextLine();
                    System.out.println("Nhập giá tiền điện thoại:");
                    double cost = admin.checkDouble(checkInput);
                    System.out.println("Nhập màu sắc điện thoại:");
                    String color = checkInput.nextLine();
                    System.out.println("Nhập số lượng điện thoại:");
                    int quantity = admin.checkInt(checkInput);
                    System.out.println("Nhập hãng điện thoại:");
                    String typeOfScreen = checkInput.nextLine();
                    return new MobilePhone(id, name, cost, color, quantity, typeOfScreen);

                }
                case 2: {
                    System.out.println("Nhập id máy tính:");
                    String id = admin.getID(checkInput);
                    System.out.println("Nhập tên máy tính:");
                    String name = checkInput.nextLine();
                    System.out.println("Nhập giá tiền máy tính:");
                    double cost = admin.checkDouble(checkInput);
                    System.out.println("nhập màu sắc máy tính:");
                    String color = checkInput.nextLine();
                    System.out.println("Nhập số lượng máy tính:");
                    int quantity = admin.checkInt(checkInput);
                    System.out.println("Nhập loại card:");
                    String card = checkInput.nextLine();
                    return new Pc(id, name, cost, color, quantity, card);
                }
                case 3: {
                    System.out.println("Nhập id tủ lạnh:");
                    String id = admin.getID(checkInput);
                    System.out.println("Nhập tên tủ lạnh:");
                    String name = checkInput.nextLine();
                    System.out.println("Nhập giá tiền:");
                    double cost = admin.checkDouble(checkInput);
                    System.out.println("Nhập màu sắc:");
                    String color = checkInput.nextLine();
                    System.out.println("Nhập số lượng tủ lạnh:");
                    int quantity = admin.checkInt(checkInput);
                    System.out.println("Nhập loại tủ lạnh: ");
                    String cooling = checkInput.nextLine();
                    return new Fridge(id, name, cost, color, quantity, cooling);
                }
                case 0:
                    menuManage();
                    break;
            }
        }
    }
}
