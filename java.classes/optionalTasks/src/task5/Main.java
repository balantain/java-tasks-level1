package task5;

//Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные — в начало списка.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 20;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < ARRAY_LENGTH; i++){
            arrayList.add((int)(Math.random()*21) - 10);
        }
        System.out.println(arrayList);
        int count = 0;
        for (int i = 0;i < arrayList.size() - count;){
            if (arrayList.get(i) < 0){
                arrayList.add(arrayList.get(i));
                arrayList.remove(arrayList.get(i));
                count++;
            }
            else {
                i++;
            }
        }
        System.out.println(arrayList);
    }
}
