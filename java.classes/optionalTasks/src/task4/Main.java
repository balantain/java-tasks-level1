package task4;

//Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/recourses/poetry/Dickens/Lucy's Song.txt");
        Scanner scanner = new Scanner(fileReader);
        ArrayList<String> poem = new ArrayList<>();
        while (scanner.hasNextLine()){
            poem.add(scanner.nextLine());
        }
        poem.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        poem.forEach(System.out::println);
    }
}
