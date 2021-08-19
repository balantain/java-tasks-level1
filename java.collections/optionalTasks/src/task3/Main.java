package task3;

// Создать список из элементов каталога и его подкаталогов.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File poetry = new File("src/recourses/poetry");
        ArrayList<File> filesList = new ArrayList<>(getAllFiles(poetry));
        System.out.println(filesList.size());
        filesList.forEach(file -> System.out.println(file.getName()));
    }
    public static ArrayList<File> getAllFiles(File f){
        ArrayList<File> allFiles = new ArrayList<>();
//        allFiles.add(f);                                   // оставить, если необходимо также добавлять имена директорий.
        for (File file : f.listFiles()){
            if (file.isDirectory()){
                allFiles.addAll(getAllFiles(file));
            }
            else {
                allFiles.add(file);
            }
        }
        return allFiles;
    }
}
