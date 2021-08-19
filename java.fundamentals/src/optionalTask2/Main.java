package optionalTask2;

//Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//        1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
//        2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
//        3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
//        4.     Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean inputCorrect = false;
    int n = 0;
        do {
        System.out.println("Type the matrix size from 5 to 10: ");
        if (sc.hasNextInt()){
            n = sc.nextInt();
            if (n >= 5 && n <= 10){
                inputCorrect = true;
            }
            else {
                System.out.println("Wrong input!");
            }
        }
        else {
            System.out.println("Wrong input!");
            sc.next();
        }
    }
        while (!inputCorrect);

    int M = 50;
    int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++){
        for (int j = 0; j < matrix[i].length; j++){
            matrix[i][j] = M - (int)(Math.random()*(M*2+1));
            System.out.print(matrix[i][j] + "\t");
        }
        System.out.println();
    }
    task1(matrix);             // 1.Задание
    task2(matrix);             // 2.Задание
    task2modernized(matrix);   // 2.Задание усложненное
    task3(matrix);             // 3.Задание
    task4(matrix);             // 4.Задание
}

    //-----------1.Упорядочить строки (столбцы) матрицы в порядке возрастания значений k-го столбца (строки)------------

    public static void task1(int[][] matrix){
        int k = 0;
        System.out.println("Lets sort the matrix according to the value of " + k + " line.");
        int[][] sortedByLineMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            System.arraycopy(matrix[i], 0, sortedByLineMatrix[i], 0, matrix[i].length);
        }
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < sortedByLineMatrix[k].length - 1; i++){
                if (sortedByLineMatrix[k][i] > sortedByLineMatrix[k][i+1]){
                    isSorted = false;
                    for (int f = 0; f < sortedByLineMatrix.length; f++){
                        int buf = sortedByLineMatrix[f][i];
                        sortedByLineMatrix[f][i] = sortedByLineMatrix[f][i+1];
                        sortedByLineMatrix[f][i+1] = buf;
                    }
                }
            }
        }
        printMatrix(sortedByLineMatrix);

        System.out.println("Lets sort the matrix according to the value of " + k + " column.");
        int[][] sortedByColumnMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            System.arraycopy(matrix[i], 0, sortedByColumnMatrix[i], 0, matrix[i].length);
        }
        isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < sortedByColumnMatrix.length - 1; i++){
                if (sortedByColumnMatrix[i][k] > sortedByColumnMatrix[i+1][k]){
                    isSorted = false;
                    for (int l = 0; l < sortedByColumnMatrix[i].length; l++){
                        int buf = sortedByColumnMatrix[i][l];
                        sortedByColumnMatrix[i][l] = sortedByColumnMatrix[i+1][l];
                        sortedByColumnMatrix[i+1][l] = buf;
                    }
                }
            }
        }
        printMatrix(sortedByColumnMatrix);
    }

    //----------2.Вывести наибольшее количество воздаствющих (убывающих) элементов матрицы, идущих подряд---------------

    public static void task2(int[][] matrix){
        int longestStrictAscendingOrder = 0;
        int count = 1;
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] < ints[j + 1]) {
                    count += 1;
                } else {
                    if (count > longestStrictAscendingOrder) {
                        longestStrictAscendingOrder = count;
                    }
                    count = 1;
                }
            }
            count = 1;
        }
        System.out.println("The maximum quantity of numbers in strict ascending order is " + longestStrictAscendingOrder);
    }

    //----------------2.Вывести максимальное количество возрастающих элементов + сами элементы--------------------------
    public static void task2modernized(int[][] matrix){
        ArrayList<Integer> longestArray = new ArrayList<Integer>();
        ArrayList<Integer> nextArray = new ArrayList<Integer>();
        int line = 0;
        int column = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length - 1; j++){
                if (nextArray.size() < 1) {
                    nextArray.add(matrix[i][j]);
                }
                if (matrix[i][j] < matrix[i][j+1]){
                    nextArray.add(matrix[i][j+1]);
                }
                else {
                    if (nextArray.size() > longestArray.size()){
                        longestArray = (ArrayList<Integer>) nextArray.clone();
                        line = i;
                        column = j - (longestArray.size()-1);
                    }
                    nextArray.clear();
                }
            }
            nextArray.clear();
        }
        System.out.println("The maximum quantity of numbers in lines in strict ascending order is: " + longestArray.size());
        System.out.println("The first longest array is: ");
        for (Integer integer : longestArray) {
            System.out.print(integer + " ");
        }
        System.out.println("\nIt starts with " + line + " line, " + column + " column.");

    }

    //----3.Найти сумму элементов матрицы, расположенных между первым и вторым положительным элементом каждой строки----

    public static void task3 (int[][] matrix){
        int sum = 0;
        int count = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] > 0 && count == 0){
                    count += 1;
                }
                else if (matrix[i][j] > 0 && count > 0){
                    break;
                }
                if (matrix[i][j] <= 0 && count > 0){
                    sum += matrix[i][j];
                }
            }

            System.out.println("The sum of numbers within the positive elements in " + i + " line is " + sum);
            sum = 0;
            count = 0;
        }
    }

    public static void task4(int[][] matrix){
        HashSet<Integer> linesToDelete = new HashSet<>();
        HashSet<Integer> columnsToDelete = new HashSet<>();
        int max = matrix[0][0];
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }
        System.out.println("Matrix max element is: " + max);
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == max){
                    linesToDelete.add(i);
                    columnsToDelete.add(j);
                }
            }
        }
        System.out.println(linesToDelete.toString());
        System.out.println(columnsToDelete.toString());

        ArrayList<Integer> arrayToString = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++){
            if(!linesToDelete.contains(i)){
                for (int j = 0; j < matrix[i].length; j++){
                    if (!columnsToDelete.contains(j)){
                        arrayToString.add(matrix[i][j]);
                    }
                }
            }
        }

        int n = 0;
        int lines = matrix.length - linesToDelete.size();
        int columns = matrix[0].length - columnsToDelete.size();
        int[][] newMatrix = new int[lines][columns];
        for(int i = 0; i < newMatrix.length; i ++){
            for (int j = 0; j < newMatrix[i].length; j++){
                newMatrix[i][j] = arrayToString.get(n);
                n += 1;
            }
        }
        for (int[] ints : newMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    //-----------------------------------------Метод для вывода матрицы в консоль --------------------------------------

    public static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
