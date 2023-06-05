package login;
import static views.Client.*;
public class Login {
    private static final Email email1 = new Email();
    private static final Password password = new Password();
    public static final String[] validEmail = new String[]{"sep@gmail.com", "nhanvien@gmail.com"};
    public static final String[] validPassword = new String[]{"*****", "trieu.com"};

    public static void login() {
        while (inPut != 0) {
            System.out.println("-----Đăng nhập-----");
            System.out.println("Nhập tên tài khoản: ");
            String tk = checkInput.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password1 = checkInput.nextLine();
            for (String s : validEmail) {
                boolean isValid = email1.validate(s);
                for (String i :
                        validPassword) {
                    boolean isValid1 = password.validatePassword(i);
                    if (validEmail[0].equals(tk) && validPassword[0].equals(password1)) {
                        menuManage();
                        break;
                    } else if (isValid && isValid1 && validEmail[1].equals(tk) && validPassword[1].equals(password1)) {
                        menuStaff();
                        break;
                    }
                }
            }
            for (String s : validEmail) {
                for (String value : validPassword) {
                    if (!s.equals(tk) || !value.equals(password1)) {
                        loginReal();
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void loginReal() {
        while (inPut != 0) {
            System.out.println("""
            ||=========================================================||
            ||       Bạn đã nhập sai tên tài khoản hoặc mật khẩu!      ||
            ||         Mời bạn nhập lại mật khẩu đã quên!              ||
            ||       Bạn có muốn nhập lại không?                       ||
            ||       0. Thoát                                          ||
            ||       1. Nhập lại:                                      ||
            ||=========================================================||
            """);
            inPut = admin.checkInt(checkInput);
            switch (inPut) {
                case 0:
                    System.exit(inPut);
                case 1:
                    login();
                    break;
                default:
                    System.out.println("Nhập lỗi.");
                    break;
            }
        }
    }
}
