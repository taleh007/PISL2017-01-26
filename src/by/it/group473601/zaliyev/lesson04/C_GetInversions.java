package by.it.group473601.zaliyev.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Рассчитать число инверсий одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо посчитать число пар индексов 1<=i<j<n, для которых A[i]>A[j]A[i]>A[j].

    (Такая пара элементов называется инверсией массива.
    Количество инверсий в массиве является в некотором смысле
    его мерой неупорядоченности: например, в упорядоченном по неубыванию
    массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
    инверсию образуют каждые (т.е. любые) два элемента.
    )

Sample Input:
5
2 3 9 2 9
Sample Output:
2

Головоломка (т.е. не обязательно).
Попробуйте обеспечить скорость лучше, чем O(n log n) за счет многопоточности.
Докажите рост производительности замерами времени.
Большой тестовый массив можно прочитать свой или сгенерировать его программно.
*/


public class C_GetInversions {
    private long inversions = 0;

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zaliyev/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        long result = instance.calc(stream);
        System.out.print(result);
    }

    long calc(InputStream stream) throws FileNotFoundException {
        Scanner scanner = new Scanner(stream);
        int countOfNumbers = scanner.nextInt();
        int[] array = new int[countOfNumbers];
        for (int i = 0; i < countOfNumbers; i++) {
            array[i] = scanner.nextInt();
        }
        inversions = 0;
        mergeSortAndCountInversions(array, 0, array.length - 1);
        return inversions;
    }

    private int[] mergeAndCountInversions(int[] leftArray, int[] rightArray) {
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
            } else if (leftArray[l] <= rightArray[r]) {
                result[i] = leftArray[l];
                l++;
            } else {
                result[i] = rightArray[r];
                inversions += leftArray.length - l;
                r++;
            }
        }
        return result;
    }

    private int[] mergeSortAndCountInversions(int[] array, int left, int right) {
        if (left < right) {
            int index = left + (right - left) / 2;
            return mergeAndCountInversions(mergeSortAndCountInversions(array, left, index), mergeSortAndCountInversions(array, index + 1, right));
        } else {
            int[] oneArray = new int[1];
            oneArray[0] = array[left];
            return oneArray;
        }
    }
}
