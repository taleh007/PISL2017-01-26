package by.it.group473601.zaliyev.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zaliyev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        int[] result = instance.getMergeSort(stream);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
        int count = leftArray.length + rightArray.length;
        int[] result = new int[count];
        for (int i = 0, l = 0, r = 0; i < count; i++) {
            if (l >= leftArray.length) {
                for (; i < count; i++, r++) {
                    result[i] = rightArray[r];
                }
            } else if (r >= rightArray.length) {
                for (; i < count; i++, l++) {
                    result[i] = leftArray[l];
                }
            } else if (leftArray[l] < rightArray[r]) {
                result[i] = leftArray[l];
                l++;
            } else {
                result[i] = rightArray[r];
                r++;
            }
        }
        return result;
    }

    private int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int index = left + (right - left) / 2;
            return merge(mergeSort(array, left, index), mergeSort(array, index + 1, right));
        } else {
            int[] oneArray = new int[1];
            oneArray[0] = array[left];
            return oneArray;
        }
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        Scanner scanner = new Scanner(stream);
        int countOfNumbers = scanner.nextInt();
        int[] array = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            array[i] = scanner.nextInt();
        }
        return mergeSort(array, 0, array.length - 1);
    }
}
