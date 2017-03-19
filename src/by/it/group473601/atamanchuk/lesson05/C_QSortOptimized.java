package by.it.group473601.atamanchuk.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Видеорегистраторы и площадь 2.
Условие то же что и в задаче А.

        По сравнению с задачей A доработайте алгоритм так, чтобы
        1) он оптимально использовал время и память:
            - за стек отвечает элиминация хвостовой рекурсии,
            - за сам массив отрезков - сортировка на месте
            - рекурсионные вызовы должны проводится на основе 3-разбиения

        2) при поиске подходящих отрезков для точки реализуйте метод бинарного поиска,
        помните при реализации, что поиск множественный
        (т.е. отрезков, подходящих для точки, может быть много)

    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/


public class C_QSortOptimized {

    //отрезок
    private class Segment  implements Comparable{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Object o) {
            //подумайте, что должен возвращать компаратор отрезков
            Segment obj = (Segment) o;
            if (obj.start>=this.start){
                return 1;
            }
            if (obj.start<this.start){
                return -1;
            }
            return 0;
        }
    }

    public void quickSort(Segment[] segments,int left, int right){
        Segment piv = segments[(left+right)/2];
        int baseLeft= left;
        int baseRight = right;
        while(left<=right){
            while(segments[left].compareTo(piv)==1){
                left++;
            }
            while(segments[right].compareTo(piv)==-1){
                right--;
            }
            if(left<=right){
                Segment tmpObject = segments[left+1];
                segments[left+1]=segments[right-1];
                segments[right-1]=tmpObject;
                left++;
                right--;
            }
        }
        if(baseLeft<right){
            quickSort(segments,baseLeft,right);
        }
        if(baseRight>left){
            quickSort(segments,left,baseRight);
        }


    }

    public void binarySort(int[] result, Segment[] segments, int[] points){
        for (int i = 0; i < points.length; i++) {
            int lefIndex=0;
            int rightIndex=segments.length-1;
            while(lefIndex<=rightIndex) {
                int middleIndex=(lefIndex+rightIndex)/2;
                if(segments[middleIndex].start<=points[i]&&segments[middleIndex].stop>=points[i]){

                    result[i]++;
                    break;
                }
                else{
                    if(segments[middleIndex].start<points[i]){

                        rightIndex=middleIndex-1;
                    }
                    else{
                        lefIndex=middleIndex+1;
                    }
                }
            }

        }
    }

    int[] getAccessory2(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[n];
        int[] result=new int[m];
        for(int i=0;i<m;i++){
            result[i]=0;
        }
        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
        }
        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор
        quickSort(segments,0,segments.length-1);

        binarySort(result,segments,points);

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/atamanchuk/lesson05/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}
