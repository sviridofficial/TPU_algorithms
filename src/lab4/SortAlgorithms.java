package lab4;

import java.util.Arrays;

public class SortAlgorithms {
    //    линейный для несортированного
    public static boolean lineForDis(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
    //    быстрый линейный для несортированного
    public static boolean fastLineForDis(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return true;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;

        while (arr[i] != key) {
            i++;
        }

        if (i != (arr.length - 1)) {
            arr[arr.length - 1] = temp;
            return true;
        }

        arr[arr.length - 1] = temp;
        return false;
    }

    //    быстрый линейный для сортированного
    public static boolean fastLineForOrd(int[] arr, int key) {
        if (arr[arr.length - 1] == key) return true;
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        int i = 0;
        while (arr[i] <= key) {
            if (arr[i] == key) {
                arr[arr.length - 1] = temp;
                break;
            }
            i++;
        }

        if (i != (arr.length - 1)) return true;

        arr[arr.length - 1] = temp;
        return false;
    }

    //    бинарный для сортированного
    public static boolean binForOrd(int[] arr, int key) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == key) {
                return true;
            }
            else if (arr[middleIndex] < key)
                firstIndex = middleIndex + 1;
            else if (arr[middleIndex] > key)
                lastIndex = middleIndex - 1;
        }
        return false;
    }

    //    блочный для сортированного
    public static boolean blockForOrd(int[] arr, int key) {
        int div = 4;
        int int_amount = arr.length / div;
        int rem = arr.length % div;

        if (int_amount == 0) {
            return SortAlgorithms.lineForDis(arr, key);
        }
        for (int i = 0; i < div; i++) {
            if (arr[int_amount * i + int_amount - 1] == key)
                return true;
            if (arr[int_amount * i + int_amount - 1] > key) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, int_amount * i, arr.length), int_amount);
                return SortAlgorithms.blockForOrd(newArr, key);
            }
            if (rem != 0) {
                int[] newArr = Arrays.copyOf(Arrays.copyOfRange(arr, div * int_amount, arr.length), rem);
                if (SortAlgorithms.blockForOrd(newArr, key)) {
                    return true;
                }
            }
        }
        return false;
    }
}
