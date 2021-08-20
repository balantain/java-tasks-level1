package task1;

// Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> poemLines = new ArrayList<>();
        FileReader fileReader = new FileReader("src/recourses/poetry/Burns/My heart's in the Highlands.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            poemLines.add(scanner.nextLine());
        }
        fileReader.close();
        poemLines.forEach(System.out::println);
        FileWriter fileWriter = new FileWriter("src/recourses/poetry/Burns/My heart's in the Highlands.txt");
        for (int i = poemLines.size()-1; i >= 0; i--){
            String s = poemLines.get(i).concat("\n");
            fileWriter.write(s);
            fileWriter.flush();
        }
    }
}
