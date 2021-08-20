package task8;

// Задан файл с текстом на английском языке. Выделить все различные слова. Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/recourses/poetry/Dickens/A Child's Hymn.txt");
        Scanner scanner = new Scanner(fileReader);
        HashSet<String> hashSet = new HashSet<>();
        String text = "";
        while (scanner.hasNext()){
            text += scanner.next() + " ";
        }
        System.out.println(text);
        String[] words = text.replaceAll("[^a-zA-Z' ]", "").toLowerCase().split("\\s+");
        System.out.println("Всего слов: " + words.length);
        for (int i = 0; i < words.length; i++){
            hashSet.add(words[i]);
            System.out.print(words[i] + " ");
        }
        System.out.println("\nУникальных: " + hashSet.size());

    }
}
