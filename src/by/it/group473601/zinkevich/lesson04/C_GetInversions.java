package by.it.group473601.zinkevich.lesson04;

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
        int[] result = new int[sizeResult + 1];
        int iLeft = 0;
        int iRight = 0;

        for(int i = 0; i < sizeResult; i++){
            if(iLeft == left.length){
                result[i] = right[iRight++];
            }
            else {
                if (iRight == right.length) {
                    result[i] = left[iLeft++];
                }
                else {
                    if (left[iLeft] < right[iRight]) {
                        result[i] = left[iLeft++];
                    } else {
                        if (left[iLeft] > right[iRight]) { // подсчет инверсий
                            inversion += left.length - iLeft;
                        }
                        result[i] = right[iRight++];
                    }
                }
            }
        }
        return result;
        //return inversion;
    }
    static int inversion = 0;

    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int size = scanner.nextInt();
        //сам массив
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!

        array = sort(array);
        result = inversion;

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zinkevich/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
