package by.it.group473601.borovsky.lesson01.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод со сложностью O(n)

Пример: https://karussell.wordpress.com/2010/03/01/fast-integer-sorting-algorithm-on/
Вольный перевод: http://programador.ru/sorting-positive-int-linear-time/
*/

public class B_CountSort {


    int[] countSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];

        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением сортировки подсчетом

        int minValue = points[0];
        int maxValue = points[0];

        for (int i = 1; i < n; i++) {
            if (points[i] < minValue) {
                minValue = points[i];
            } else if (points[i] > maxValue) {
                maxValue = points[i];
            }
        }

        int[] countsArray = new int[maxValue - minValue + 1];

        for (int i = 0;  i < n; i++) {
            countsArray[points[i] - minValue]++;
        }

        countsArray[0]--;
        for (int i = 1; i < countsArray.length; i++) {
            countsArray[i] +=countsArray[i-1];
        }

        int[] sortedArray = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedArray[countsArray[points[i] - minValue]--] = points[i];
        }

        return sortedArray;


        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //return points;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/borovsky/lesson01/lesson05/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
