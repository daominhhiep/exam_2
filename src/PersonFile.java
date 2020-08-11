import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PersonFile {
    private static final String PERSON_FILE = "person.csv";

    public void write(List<Person> personList) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(PERSON_FILE));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fileOutputStream);
            closeStream(objectOutputStream);
        }
    }


    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(PERSON_FILE));
            objectInputStream = new ObjectInputStream(fileInputStream);
            personList = (List<Person>) objectInputStream.readObject();
        } catch (FileNotFoundException exception) {
            System.err.println("Không tìm thấy file lưu trữ !");
        } catch (IOException exception) {
            System.err.println("Chưa có thông tin nào trong hệ thống!");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        } finally {
            closeStream(fileInputStream);
            closeStream(objectInputStream);
        }
        return personList;
    }


    private void closeStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}