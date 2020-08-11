import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhonebookManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Person> personList;
    private PersonFile personFile;

    public PhonebookManager() {
        personFile = new PersonFile();
        personList = personFile.read();
    }

    public String inputPhonenumber(){
        System.out.println("Số điện thoại : ");
        return scanner.nextLine();
    }

    private String inputGroup(){
        System.out.println("Nhóm : ");
        return scanner.nextLine();
    }

    private String inputName() {
        System.out.println("Họ và tên: ");
        return scanner.nextLine();
    }

    private String inputGender() {
        System.out.println("Giới tính : ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.println("Địa chỉ : ");
        return scanner.nextLine();
    }

    private String inputDaB() {
        System.out.println("Ngày sinh : ");
        return scanner.nextLine();
    }

     private String inputEmail(){
         System.out.println("Email : ");
         return scanner.nextLine();
     }

    public String inputSearch() {
        System.out.println("Nhập số điện thoại hoặc họ tên muốn tìm : ");
        return scanner.nextLine();
    }

    public void add() {
        String phonenumber = inputPhonenumber();
        String group = inputGroup();
        String name = inputName();
        String gender = inputGender();
        String address = inputAddress();
        String dab = inputDaB();
        String email = inputEmail();
        Person person = new Person(phonenumber, group, name, gender, address, dab, email);
        personList.add(person);
        personFile.write(personList);
    }

    public void edit(String phonenumber) {
        boolean isExisted = false;
        int size = personList.size();
        for (int i = 0; i < size; i++) {
            if (personList.get(i).getPhonenumber().equals(phonenumber)) {
                isExisted = true;
                personList.get(i).setGroup(inputGroup());
                personList.get(i).setName(inputName());
                personList.get(i).setGender(inputGender());
                personList.get(i).setAddress(inputAddress());
                personList.get(i).setDab(inputDaB());
                personList.get(i).setEmail(inputEmail());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Số điện thoại = %d không tồn tại.\n", phonenumber);
        } else {
            personFile.write(personList);
        }
    }

    public void delete(String phonenumber) {
        Person person = null;
        int size = personList.size();
        for (int i = 0; i < size; i++) {
            if (personList.get(i).getPhonenumber().equals(phonenumber)) {
                person = personList.get(i);
                break;
            }
        }
        if (person != null) {
            personList.remove(person);
            personFile.write(personList);
        } else {
            System.out.printf("Id = %d không tồn tại.\n", phonenumber);
        }
    }

    public boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public void searchPhone(String key) {
        List<Person> productsListsSearch = new ArrayList<>();
        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (checkKey(key, person.getName() )||checkKey(key, person.getPhonenumber())) {
                productsListsSearch.add(person);
            }
        }
        for (Person person :productsListsSearch){
            System.out.println(person.getPhonenumber()+ " "  + person.getGroup() + " "+ person.getName()
                    + " " + person.getGender() +" "+  person.getAddress()
                    + " " + person.getDab() + " " +person.getEmail());
        }
    }


    public void show() {
        System.out.println("----------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------");
        System.out.printf("| %20s | ", "Số điện thoại");
        System.out.printf("%20s | ", "Nhóm");
        System.out.printf("%20s | ", "Họ tên");
        System.out.printf("%10s | ", "Giới tính");
        System.out.printf("%20s | ", "Địa chỉ");
        System.out.printf("%20s |", "Ngày sinh");
        System.out.printf("%20s |", "Email");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------");
        for (Person person : personList) {
            System.out.printf("| %20s | ", person.getPhonenumber());
            System.out.printf("%20s | ", person.getGroup());
            System.out.printf("%20s | ", person.getName());
            System.out.printf("%10s | ", person.getGender());
            System.out.printf("%20s | ", person.getAddress());
            System.out.printf("%20s |", person.getDab());
            System.out.printf("%20s |", person.getEmail());
            System.out.println();
            System.out.println("----------------------------------------------------------------------------" +
                    "----------------------------------------------------------------------------");        }
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setStudentList(List<Person> personList) {
        this.personList = personList;
    }
}
