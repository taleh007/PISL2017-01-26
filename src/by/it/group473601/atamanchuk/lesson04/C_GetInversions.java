package by.it.group473601.atamanchuk.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
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

    private long merge(int[] resultArray, int[] leftArray, int[] rightArray) {
        int indexFirstArray = 0, indexSecondArray = 0, countInverse = 0;
        while (indexFirstArray < leftArray.length || indexSecondArray < rightArray.length) {
            if (indexFirstArray == leftArray.length) {
                resultArray[indexFirstArray+indexSecondArray] = rightArray[indexSecondArray];
                indexSecondArray++;
            } else if (indexSecondArray == rightArray.length) {
                resultArray[indexFirstArray+indexSecondArray] = leftArray[indexFirstArray];
                indexFirstArray++;
            } else if (leftArray[indexFirstArray] <= rightArray[indexSecondArray]) {
                resultArray[indexFirstArray+indexSecondArray] = leftArray[indexFirstArray];
                indexFirstArray++;
            } else {
                resultArray[indexFirstArray+indexSecondArray] = rightArray[indexSecondArray];
                countInverse += leftArray.length-indexFirstArray;
                indexSecondArray++;
            }
        }
        return countInverse;
    }

    private long inverseCount(int[] array) {
        if (array.length < 2) {
            return 0;
        }

        int middle = (array.length + 1) / 2;
        int leftArray[] = Arrays.copyOfRange(array, 0, middle);
        int rightArray[] = Arrays.copyOfRange(array, middle, array.length);
        return inverseCount(leftArray) + inverseCount(rightArray) + merge(array, leftArray, rightArray);
    }




    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = 0;
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!

        result=(int) inverseCount(a);
        System.out.println(result);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root=System.getProperty("user.dir")+"/src/";
        InputStream stream = new FileInputStream(root+"by/it/group473601/atamanchuk/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
