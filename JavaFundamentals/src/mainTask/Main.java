package mainTask;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        userGreeting();
        argumentsInBackOrder();
        printRandomNumbers();
        countNumbersProdAndSum();
        monthInput();
    }
    //----------------1.Приветствовать любого пользователя при вводе его имени через командную строку-------------------

    public static void userGreeting(){
        System.out.println("Please, enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "! We're glad to see you.");
        sc.close();
    }

    //----------------2.Отобразить в окне консоли аргументы командной строки в обратном порядке-------------------------

    public static void argumentsInBackOrder(){
        System.out.println("Please, enter some arguments here and we'll return them in back order:");
        Scanner sc = new Scanner(System.in);
        String args = sc.nextLine();
        String[] argsArray = args.split("\\s+");
        StringBuilder argsInBackOrder = new StringBuilder();
        if (argsArray.length == 1){                              // для разнообразия, если введено одно слово - выводим его наоборот
            for (int i = args.length()-1; i>= 0; i--){
                argsInBackOrder.append(args.charAt(i));
            }
        }
        else {                                                  // если несколько, то выводим их в обратном порядке
            for (int i = argsArray.length - 1; i >=0; i--){
                argsInBackOrder.append(argsArray[i]).append(" ");
            }
        }
        System.out.println(argsInBackOrder);
        sc.close();
    }

    //---------3.Вывести заданное количество случайных чисел с переходом и без перехода на новую строку-----------------

    public static void printRandomNumbers(){
        System.out.println("How many numbers shall we print:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print(Math.random()*10 + " ");
        }
        for (int i = 0; i < n; i++){
            System.out.println(Math.random()*10);
        }
        sc.close();
    }

    //4.Вывести целые числа как аргументы командной строки. Подсчитать их сумму и произведение. Вывести результат на консоль

    public static void countNumbersProdAndSum(){
        System.out.println("PLease, enter some integer numbers: ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] array = line.split("\\s+");
        int sum = 0;
        int prod = 1;
        for (String s : array){
            sum += Integer.parseInt(s);
            prod *= Integer.parseInt(s);
        }
        System.out.println("The sum is: " + sum);
        System.out.println("The prod is: " + prod);
        sc.close();
    }

    //5.Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

    public static void monthInput(){
        boolean isInputCorrect = false;
        System.out.println("Please, enter an integer number from 1 to 12:");
        while (!isInputCorrect){
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()){
                System.out.println("Wrong input. Not a number or not an integer number.");
                System.out.println("Please, enter an integer number from 1 to 12:");
                sc.next();
            }
            int userInput = sc.nextInt();
            if (userInput > 12 || userInput < 1){
                System.out.println("Wrong input. Number is not in diapason.");
                System.out.println("Please, enter an integer number from 1 to 12:");
                isInputCorrect = false;
            }
            else{
                isInputCorrect = true;
                switch (userInput){
                    case 1:
                        System.out.println("January"); break;
                    case 2:
                        System.out.println("February"); break;
                    case 3:
                        System.out.println("March"); break;
                    case 4:
                        System.out.println("April"); break;
                    case 5:
                        System.out.println("May"); break;
                    case 6:
                        System.out.println("June"); break;
                    case 7:
                        System.out.println("July"); break;
                    case 8:
                        System.out.println("August"); break;
                    case 9:
                        System.out.println("September"); break;
                    case 10:
                        System.out.println("October"); break;
                    case 11:
                        System.out.println("November"); break;
                    case 12:
                        System.out.println("December"); break;
                    default: throw new IllegalArgumentException("DEFAULT! Wrong input!");
                }
            }
            sc.close();
        }
    }
}
