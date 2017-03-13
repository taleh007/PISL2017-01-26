package by.it.group473601.zaliyev.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
В первой строке источника данных даны:
        - целое число 1<=n<=100000 (размер массива)
        - сам массив A[1...n] из n различных натуральных чисел,
          не превышающих 10E9, в порядке возрастания,
Во второй строке
        - целое число 1<=k<=10000 (сколько чисел нужно найти)
        - k натуральных чисел b1,...,bk не превышающих 10E9 (сами числа)
Для каждого i от 1 до kk необходимо вывести индекс 1<=j<=n,
для которого A[j]=bi, или -1, если такого j нет.

        Sample Input:
        5 1 5 8 12 13
        5 8 1 23 1 11

        Sample Output:
        3 1 -1 1 -1

(!) Обратите внимание на смещение начала индекса массивов JAVA относительно условий задачи
*/

public class A_BinaryFind {
    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by\\it\\group473601\\zaliyev\\lesson04\\dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        int[] result = instance.findIndex(stream);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    int[] findIndex(InputStream stream) throws FileNotFoundException {
        Scanner scanner = new Scanner(stream);
        int dataCount = scanner.nextInt();
        int[] dataSortArray = new int[dataCount];
        for (int i = 1; i <= dataCount; i++) {
            dataSortArray[i - 1] = scanner.nextInt();
        }
        int indexCount = scanner.nextInt();
        int[] resultArray = new int[indexCount];
        for (int i = 0; i < indexCount; i++) {
            int valueForSearch = scanner.nextInt();
            resultArray[i] = -1;
            if (valueForSearch > dataSortArray[dataCount - 1] || valueForSearch < dataSortArray[0]) {
                continue;
            } else {
                int start = 0;
                int finish = dataCount;
                int middle;
                while (start < finish) {
                    middle = (start + (finish - start) / 2);
                    if (dataSortArray[middle] == valueForSearch) {
                        resultArray[i] = middle + 1;
                        break;
                    } else if (dataSortArray[middle] > valueForSearch) {
                        finish = middle;
                    } else if (dataSortArray[middle] < valueForSearch) {
                        start = middle + 1;
                    }
                }
            }
        }
        return resultArray;
    }
}
