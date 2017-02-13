package by.it.group473601.irina_petrova.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 999999999;
        int m = 321;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    //период Пизано всегда начинается с 0, 1
    //период Пизано не может быть больше чем 6*m
    private static ArrayList<Long> getPeriodPezona(long m){
        ArrayList<Long> myArrayList = new ArrayList();
        myArrayList.add((long)0);
        myArrayList.add((long)1);
        for(int i = 2; i < m * 6; i++){
            myArrayList.add((myArrayList.get(i - 1) + myArrayList.get(i - 2)) % m);
            if(myArrayList.get(i) == 1 && myArrayList.get(i-1) == 0){
                break;
            }
        }
        return myArrayList;
    }

    //остатком будет элемент списка, индекс которого
    // есть остаток от деления числа n на период Пизано
    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<Long> myArrayList = getPeriodPezona(m);
        long period = myArrayList.size() - 2; // находим период Пизано
        int result = (int)(n % period);
        return myArrayList.get(result);
    }
}

