package by.it.group473601.borovsky.lesson01.lesson04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    int mergeArrays(int[] baseArray, int [] arrayForMergeOne, int [] arrayForMergeTwo){

        int sumLength = arrayForMergeOne.length + arrayForMergeTwo.length;
        int indexForArrayOne = 0;
        int indexForArrayTwo = 0;
        int inverseCount = 0;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < sumLength; i++){
            if (indexForArrayOne == arrayForMergeOne.length)
            {
                result.add(arrayForMergeTwo[indexForArrayTwo]);
                indexForArrayTwo++;
                continue;
            }
            if(indexForArrayTwo == arrayForMergeTwo.length)
            {
                result.add(arrayForMergeOne[indexForArrayOne]);
                indexForArrayOne++;
                continue;
            }
            if (arrayForMergeOne[indexForArrayOne] <= arrayForMergeTwo[indexForArrayTwo])
            {
                result.add(arrayForMergeOne[indexForArrayOne]);
                indexForArrayOne++;
            }
            else
            {
                result.add(arrayForMergeTwo[indexForArrayTwo]);
                inverseCount += arrayForMergeOne.length-indexForArrayOne;
                indexForArrayTwo++;
            }
        }

        return inverseCount;
    }

    int getInversions(int[] inputArray){
        if(inputArray.length <= 1){
            return 0;
        }
        int middle = (inputArray.length + 1)/2;
        return getInversions(Arrays.copyOfRange(inputArray, 0, middle)) +
                getInversions(Arrays.copyOfRange(inputArray, middle, inputArray.length)) +
                mergeArrays(inputArray, Arrays.copyOfRange(inputArray, 0, middle), Arrays.copyOfRange(inputArray, middle, inputArray.length));
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

        result = getInversions(a);

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/borovsky/lesson01/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
