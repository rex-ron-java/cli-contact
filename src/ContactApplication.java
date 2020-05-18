import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        int choice;
        String output;

        output = " 1. View contacts.\n 2. Add a contact.\n 3. Search a contact by name.\n 4. Delete an existing contact.\n 5. Exit.\n Enter an option (1, 2, 3, 4 or 5):";
        System.out.println(output);
        System.out.println("Choice:");
        choice = scanner.nextInt();

        if(choice == 1) {
            readFile(contactFilePath, true);
        }




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

    public static List<String> readFile(Path aFile, boolean print){
        List<String> lines;
        try{
            lines = Files.readAllLines(aFile);
            if(print == true){
                for (String line: lines) {
                    System.out.println(line);
                }
                return null;
            }
            return lines;
        } catch (IOException e){
            System.out.println("Problems reading the file");
            e.printStackTrace();
            return null;
        }
    }

}



