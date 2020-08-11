import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        PhonebookManager phonebookManager = new PhonebookManager();
        PersonFile personFile = new PersonFile();
        String phonenumber;


        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    phonebookManager.show();
                    break;
                case "2":
                    phonebookManager.add();
                    System.out.println("-----Done!-----");
                    showMenu();
                    break;
                case "3":
                    phonenumber = phonebookManager.inputPhonenumber();
                    phonebookManager.edit(phonenumber);
                    showMenu();
                    break;
                case "4":
                    phonenumber = phonebookManager.inputPhonenumber();
                    phonebookManager.delete(phonenumber);
                    showMenu();
                    break;
                case "5":
                    phonenumber = phonebookManager.inputSearch();
                    phonebookManager.searchPhone(phonenumber);
                    showMenu();
                    break;
                case "6":
                    personFile.read();
                    break;
                case "7":

                    break;
                case "8":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
            }
        }
    }

    public static void showMenu() {
        System.out.println("----CHƯƠNG TÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ File");
        System.out.println("7. Ghi từ File");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
    }
}
