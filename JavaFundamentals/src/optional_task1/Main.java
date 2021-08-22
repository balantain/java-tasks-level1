package optional_task1;

//Задание. Ввести n чисел с консоли.
//        1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//        2.     Вывести числа в порядке возрастания (убывания) значений их длины.
//        3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
//        4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
//        5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
//        6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
//        7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        String input;
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please enter " + n + " integer positive numbers:");

            input = sc.nextLine();
            if (isInputCorrect(input, n)) {
                validInput = true;
            } else {
                System.out.println("Wrong input! Try again: ");
            }
        }
        while (!validInput);
        sc.close();
        String[] arr = input.split("\\s+");

        findMaxMinLength(arr);          // 1.Задание
        printLengthSortedNumbers(arr);  // 2.Задание
        avrLengthNum(arr);              // 3.Задание
        minDifNum(arr);                 // 4.Задание
        countEvenNumbers(arr);          // 5.Задание
        numWithDigitsInAscendOrd(arr);  // 6.Задание
        numWithOnlyUniqueDigits(arr);   // 7.Задание
    }

    //----------------------------------Проверка корректности ввода-----------------------------------------------------

    public static boolean isInputCorrect(String input, int n){
        String[] arr = input.split("\\s+");
        boolean isInputCorrect = false;
        if (arr.length == n){
            for (String s: arr){
                if (s.matches("\\d+")) {
                    isInputCorrect = true;
                } else {
                  isInputCorrect = false;
                  break;
                }
            }
        }
        return isInputCorrect;
    }

    //-------------1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.------------

    public static void findMaxMinLength (String[] arr){
        String maxLengthNum = arr[0];
        String minLengthNum = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (maxLengthNum.length() < arr[i].length()){
                maxLengthNum = arr[i];
            }
            if (minLengthNum.length() > arr[i].length()){
                minLengthNum = arr[i];
            }
        }

        StringBuilder equalMaxNum = new StringBuilder();
        StringBuilder equalMinNum = new StringBuilder();

        int countMax = 0;
        int countMin = 0;

        for (String s : arr){
            if (maxLengthNum.length() == s.length()){
                countMax += 1;
                equalMaxNum.append(s).append(" ");
            }
            if (minLengthNum.length() == s.length()){
                countMin += 1;
                equalMinNum.append(s).append(" ");
            }
        }
        if (countMax > 1){
            System.out.println("The longest numbers are: " + equalMaxNum + " Their length is: " + maxLengthNum.length());
        }
        else {
            System.out.println("The longest number is: " + maxLengthNum + " Its length is: " + maxLengthNum.length());
        }
        if (countMin > 1){
            System.out.println("The shortest numbers are: " + equalMinNum + " Their length is: " + minLengthNum.length());
        }
        else {
            System.out.println("The shortest number is: " + minLengthNum + " Its length is: " + minLengthNum.length());
        }
    }

    // ----------------2. Вывести числа в порядке возрастания (убывания) значений их длины.------------------------------

    public static void printLengthSortedNumbers (String[] arr){
        String[] sortedArr = new String[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        boolean isSorted = false;
        String buf;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < sortedArr.length - 1; i++) {
                if (sortedArr[i].length() > sortedArr[i + 1].length()) {
                    isSorted = false;
                    buf = sortedArr[i];
                    sortedArr[i] = sortedArr[i + 1];
                    sortedArr[i + 1] = buf;
                }
            }
        }
        for (String s : sortedArr){
            System.out.print(s + " ");
        }
    }

    //----3.Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.----

    public static void avrLengthNum (String[] arr){
        float avr;
        int sum = 0;
        for (String s : arr){
            sum += s.length();
        }
        avr = (float)sum/arr.length;
        System.out.println("\nAverage length of numbers is: " + avr);

        StringBuilder lengthMoreAvr = new StringBuilder();
        StringBuilder lengthLessAvr = new StringBuilder();

        for (String s : arr){
            if (s.length() < avr){
                lengthLessAvr.append(s).append(" (length - ").append(s.length()).append(") ");
            }
            if (s.length() > avr){
                lengthMoreAvr.append(s).append(" (length - ").append(s.length()).append(") ");
            }
        }
        System.out.println("The numbers with length less then average are: \n" + lengthLessAvr);
        System.out.println("The numbers with length more then average are: \n" + lengthMoreAvr);
    }

    //---4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.---

    public static void minDifNum(String[] arr){
        String[] difArr = new String[arr.length];
        StringBuilder difNum = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length(); j++){
                if (!difNum.toString().contains(arr[i].substring(j,j+1))){
                    difNum.append(arr[i].charAt(j));
                }
            }
            difArr[i] = difNum.toString();
            difNum = new StringBuilder();
        }
        String minDifNum = difArr[0];
        int minDifNumIndex = 0;
        for (int i = 0; i < difArr.length; i++){
            if (minDifNum.length() > difArr[i].length()){
                minDifNum = difArr[i];
                minDifNumIndex = i;
            }
        }
        System.out.println("\nThe number with less different numbers is: " + arr[minDifNumIndex]);
    }

    //--5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.--

    public static void countEvenNumbers(String[] arr){
        int countOnlyEvenNum = 0;
        StringBuilder numbersWithOnlyEvenDig = new StringBuilder();
        int countEqualEvenOddNum = 0;
        StringBuilder numbersWithEqualEvenOddNum = new StringBuilder();
        int countEvenDigit = 0;
        int countOddDigit = 0;

        for (String s: arr){
            for (int i = 0; i < s.length(); i++){
                if (Integer.parseInt(s.substring(i, i+1)) % 2 == 0){
                    countEvenDigit += 1;
                }
                else {
                    countOddDigit +=1;
                }
            }
            if (countEvenDigit == s.length()){
                countOnlyEvenNum += 1;
                numbersWithOnlyEvenDig.append(s).append(" ");
            }
            if (countEvenDigit == countOddDigit){
                countEqualEvenOddNum += 1;
                numbersWithEqualEvenOddNum.append(s).append(" ");
            }
            countEvenDigit = 0;
            countOddDigit = 0;
        }
        if (countOnlyEvenNum == 1){
            System.out.println("There is only 1 number with only even digits. It is " + numbersWithOnlyEvenDig);
        }
        else if (countOnlyEvenNum > 1){
            System.out.println("There are " + countOnlyEvenNum + " numbers with only even digits. They are: " + numbersWithOnlyEvenDig);
        }
        else {
            System.out.println("There are no numbers with only even digits.");
        }
        if (countEqualEvenOddNum == 1){
            System.out.println("There is only 1 number with equal quantity of even and odd digits. It is " + numbersWithEqualEvenOddNum);
        }
        else if (countEqualEvenOddNum > 1){
            System.out.println("There are " + countEqualEvenOddNum + " numbers with equal quantity of even and odd digits. Trey are " + numbersWithEqualEvenOddNum);
        }
        else {
            System.out.println("There are no numbers with equal quantity of even and odd digits.");
        }
    }

    //--6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.--

    public static void numWithDigitsInAscendOrd (String[] arr){
        String ascOrdDigitNum = "";
        boolean isSorted = false;
        for (String s: arr){
            for (int i = 0; i < s.length() - 1 ; i++){
                if (Integer.parseInt(s.substring(i, i+1)) < Integer.parseInt(s.substring(i+1, i+2))){
                    isSorted = true;
                }
                else {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted){
                ascOrdDigitNum = s;
                break;
            }
        }
        if (ascOrdDigitNum.equals("")){
            System.out.println("There are no numbers with digits in strict ascending order.");
        }
        else{
            System.out.println("The number with digits in strict ascending order is: " + ascOrdDigitNum);
        }
    }

    //-------7.Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них---------

    public static void numWithOnlyUniqueDigits (String[] arr){
        StringBuilder numUnique = new StringBuilder();
        for (String s: arr){
            for (int i = 0; i < s.length(); i++){
                if (!numUnique.toString().contains(s.substring(i, i+1))){
                    numUnique.append(s.charAt(i));
                }
                else {
                    numUnique = new StringBuilder();
                    break;
                }
            }
            if (!numUnique.toString().equals("")){
                break;
            }
        }
        if (numUnique.toString().equals("")){
            System.out.println("There are no numbers with only unique digits.");
        }
        else {
            System.out.println("The number with unique digits is: " + numUnique);
        }
    }
}
