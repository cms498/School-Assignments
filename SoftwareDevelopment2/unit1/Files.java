import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Files {
    public static void info(String filename){
        File file = new File(filename);
        System.out.println("Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());
        if (file.exists()){
            System.out.println("Length: " + file.length());
        }
    }

    public static void printFile(String filename){
        File file = new File(filename);
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public static void main(String[] args){
        info("Strings.java");
        info("data/alice.txt");
        info("data/fake_file.txt");

        try{
            FileReader fileReader = new FileReader("Files.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            String line = bufferedReader.readLine();
            System.out.println(line);
    
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        printFile("data/alice.txt");
    }
}
