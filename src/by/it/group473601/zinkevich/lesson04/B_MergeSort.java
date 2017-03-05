package by.it.group473601.zinkevich.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
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

//    int[] merge(int[] ar_1, int[] ar_2){
//        int max = ar_1.length + ar_2.length;
//        int[] result = new int[max];
//        int m = 0, n = 0;
//        for (int i = 0; i < max; i++){
//            if (m >= ar_1.length & n < ar_2.length){
//                result[i] = ar_2[n];
//                n++;
//            }else if(n >= ar_2.length & m < ar_1.length){
//                result[i] = ar_1[m];
//                m++;
//            }else if (ar_1[m] <= ar_2[n] & m < ar_1.length){
//                result[i] = ar_1[m];
//                m++;
//            }else {
//                result[i] = ar_2[n];
//                n++;
//            }
//        }
//        return result;
//    }
//
//    int[] mergeSort(int[] arr, int l, int r){
//        int[] result = new int[1];
//        int index = (int)(l + r) / 2;
//        if (l < r){
//           return merge(mergeSort(arr, l, index), mergeSort(arr, index + 1, r));
//        }else {
//            result[0] = arr[l];
//            return result;
//        }
//    }


    //рекурсивная функция сортировки частей массива
    public static int[] sort(int[] array){
        if(array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        return merge(sort(left), sort(right));
    }
    //слияние двух массивов в один отсортированный
    public static int[] merge(int[] left,int right[]){
        int sizeResult = left.length + right.length;
        int[] result = new int[sizeResult];
        int iLeft=0;
        int iRight=0;
        for(int i = 0; i < sizeResult; i++){
            if(iLeft == left.length){
                result[i] = right[iRight++];
            }
            else {
                if (iRight == right.length) {
                    result[i] = left[iLeft++];
                } else {
                    if (left[iLeft] < right[iRight]) {
                        result[i] = left[iLeft++];
                    } else {
                        result[i] = right[iRight++];
                    }
                }
            }
        }
        return result;
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

        //размер массива
        int sizeArray = scanner.nextInt();
        //сам массива
        int[] array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = scanner.nextInt();
            System.out.println(array[i]);
        }

        // тут ваше решение (реализуйте сортировку слиянием)
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием

        //a = mergeSort(a, 0, a.length - 1);
        array = sort(array);


        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return array;
    }
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zinkevich/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
