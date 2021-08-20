package task2;

//Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int number = 123456789;
        String s = Integer.toString(number);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            stack.add(s.charAt(i));
        }
        StringBuilder newNumberAsString = new StringBuilder();
        while (!stack.isEmpty()){
            newNumberAsString.append(stack.pop());
        }
        int newNumber = Integer.parseInt(newNumberAsString.toString());
        System.out.println(newNumber);
    }
}
