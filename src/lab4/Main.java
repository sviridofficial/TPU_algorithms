package lab4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте!");
        System.out.print("Введите размер массива: ");

        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Заполнить массив числами от 0 до: ");

       int limit = scanner.nextInt();
       scanner.nextLine();

        System.out.print("Введите число, которое нужно найти: ");

       int find = scanner.nextInt();
       scanner.nextLine();

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * limit);
        }

//        Несортированный
        long timeStart1 = System.nanoTime();
        SortAlgorithms.lineForDis(arr, find);
        long timeEnd1 = System.nanoTime();

        long timeStart2 = System.nanoTime();
        SortAlgorithms.fastLineForDis(arr, find);
        long timeEnd2 = System.nanoTime();

        Arrays.sort(arr);
//        Сортированный
        long timeStart3 = System.nanoTime();
        SortAlgorithms.fastLineForOrd(arr, find);
        long timeEnd3 = System.nanoTime();

        long timeStart4 = System.nanoTime();
        SortAlgorithms.binForOrd(arr, find);
        long timeEnd4 = System.nanoTime();

        long timeStart5 = System.nanoTime();
        SortAlgorithms.blockForOrd(arr, find);
        long timeEnd5 = System.nanoTime();


//        Вывод массива
      for (int i = 0; i < arr.length; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("-------------------------------");
        if (SortAlgorithms.fastLineForDis(arr, find)) {
            System.out.println("Элемент был найден в массиве!");
        } else {
            System.out.println("Такого элемента нет в массиве!");
        }
        System.out.println("-------------------------------");
        System.out.println("Время выполнения алгоритмов: ");
        System.out.println("\t- неупорядоченного:");
        System.out.println("\t\t* линейного: " + (timeEnd1 - timeStart1)/1000 + "mks");
        System.out.println("\t\t* быстрого линейного: " + (timeEnd2 - timeStart2)/1000 + "mks");
        System.out.println("\t- упорядоченного: " );
        System.out.println("\t\t* быстрого линейного: " + (timeEnd3 - timeStart3)/1000 + "mks");
        System.out.println("\t\t* бинарного: " + (timeEnd4 - timeStart4)/1000 + "mks");
        System.out.println("\t\t* блочного: " + (timeEnd5 - timeStart5)/1000 + "mks");

    }
}
