package task7;

//Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.

import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String string = "(){{}}[](){{{[]()}}}()";
        System.out.println(isBracketsCorrect(string));
    }
    public static boolean isBracketsCorrect(String string){
        boolean isBracketsCorrect = false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++){
            if (!isCloseBracket(string.charAt(i))){
                stack.push(string.charAt(i));
            }
            else {
                try{
                    if (isPareBrackets(stack.pop(), string.charAt(i))){
                        isBracketsCorrect = true;
                    }
                    else {
                        isBracketsCorrect = false;
                        break;
                    }
                }
                catch (EmptyStackException e){
                    isBracketsCorrect = false;
                    break;
                }
            }
        }
        if (stack.size() > 0){
            isBracketsCorrect = false;
        }
        return isBracketsCorrect;
    }
    public static boolean isCloseBracket(Character character){
        return (character.equals('}') || character.equals(']') || character.equals(')'));
    }
    public static boolean isPareBrackets(Character open, Character close){
        return  ((open == '{' && close == '}') || (open == '(' && close == ')') || (open == '[' && close == ']'));
    }
}
