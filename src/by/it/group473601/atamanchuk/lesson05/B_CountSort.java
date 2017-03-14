package by.it.group473601.atamanchuk.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
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
        int countElements = scanner.nextInt();
        int maxNumber=10;
        int[] inputSequence=new int[countElements];

        //читаем точки
        for (int i = 0; i < countElements; i++) {
            inputSequence[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением сортировки подсчетом

        int[] sortedSequence = new int[countElements];
        int[] frequency = new int[maxNumber];

        for(int i=0;i<maxNumber;i++){
            frequency[i]=0;
        }

        for(int i=0;i<countElements;i++){
            frequency[inputSequence[i]]++;
        }

        for(int j=1;j<maxNumber;j++){
            frequency[j]=frequency[j]+frequency[j-1];
        }

        for(int i=countElements-1;i>=0;i--){
            frequency[inputSequence[i]]--;
            sortedSequence[frequency[inputSequence[i]]]=inputSequence[i];
        }




        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return sortedSequence;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/atamanchuk/lesson05/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
