package by.it.group473601.gorbachik.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    private int[] merge(int[] arr_1, int[] arr_2){
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int arr_1_index = 0, arr_2_index = 0, finalLen = len_1 + len_2;
        int[] result = new int[finalLen];
        for (int i = 0; i < finalLen; i++) {
            if (arr_1_index < len_1 && arr_2_index < len_2) {
                if (arr_1[arr_1_index] > arr_2[arr_2_index]) result[i] = arr_2[arr_2_index++];
                else result[i] = arr_1[arr_1_index++];
            }

            else if (arr_2_index < len_2) {
                result[i] = arr_2[arr_2_index++];
            }

            if (arr_2_index > len_2) {
                result[i] = arr_1[arr_1_index++];
            }
        }
        return result;
    }

    private int[] mergeSort(int[] arr, int l, int r){
        int[] result = new int[1];
        int index = (int)(l + r) / 2;
        if (l < r){
           return merge(mergeSort(arr, l, index), mergeSort(arr, index + 1, r));
        }else {
            result[0] = arr[l];
            return result;
        }
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int n = scanner.nextInt();
        //сам массива
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        a = mergeSort(a, 0, a.length - 1);
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/gorbachik/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
