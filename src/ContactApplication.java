import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContactApplication {

    public static void main(String[] args) {

        String directory = "src/data";
        String filename = "src/data/contacts.txt";
        List<String> contacts = new ArrayList<>();

        contacts.add("Rex Sutton 12345678");
        contacts.add("Ron Palencia 12345679");

        Path dataDirectory = Paths.get(directory);
        Path contactFilePath = Paths.get(filename);


        createDir(dataDirectory);
        createFile(contactFilePath);

        writeFile(contactFilePath, contacts);

    }

    public static void writeFile(Path aFile, List<String> aList){
        try {
            Files.write(aFile, aList);
//            Files.write(aFile, aList, StandardOpenOption.APPEND);
        } catch (IOException e){
            System.out.println("Problems writing in the file");
            e.printStackTrace();
        }
    }

    private static void createDir(Path aDir) {
        if (Files.notExists(aDir)) {
            try {
                Files.createDirectory(aDir);
            } catch (IOException e) {
                System.out.println("Problems creating the directory");
                e.printStackTrace();
            }
        }
    }

    public static void createFile(Path aFile) {
        if (!Files.exists(aFile)) {
            try {
                Files.createFile(aFile);
            } catch (IOException e) {
                System.out.println("Problems creating the file");
                e.printStackTrace();
            }
        }
    }

}



