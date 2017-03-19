package by.it.group473601.vabishchevich.lesson04;

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

    int[] merge(int[] ar_1, int[] ar_2){
        int len1=ar_1.length;
        int len2=ar_2.length;
        int maxLength = len1+len2;
        int[] result = new int[maxLength];
        int first = 0;
        int second = 0;
        for (int i = 0; i < maxLength; i++) {
            if (second < len2 && first < len1) {
                if (ar_1[first] > ar_2[second])
                    result[i] = ar_2[second++];
                else result[i] = ar_1[first++];
            }
            else if (second < len2) {
            result[i]=ar_2[second++];
            }
            else{
                result[i]=ar_1[first++];
            }
        }
          return result;
    }

    int[] mergeSort(int[] arr, int leftIndex, int rightIndex){
        int[] result = new int[1];
        int midIndex = (int)(leftIndex + rightIndex) / 2;
        if (leftIndex < rightIndex){
           return merge(mergeSort(arr, leftIndex, midIndex), mergeSort(arr, midIndex + 1, rightIndex));
        }else {
            result[0] = arr[leftIndex];
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
            System.out.println(a[i]);

        }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием

        a = mergeSort(a, 0, a.length - 1);




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream("C:\\Users\\Колобок\\IdeaProjects\\PISL2017-01-26\\src\\by\\it\\group473601\\vabishchevich\\lesson04\\dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
