package by.it.group473601.dontsova.lesson1;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger[] arrayFib = new BigInteger[n+2];
        arrayFib[0]=BigInteger.valueOf(0);
        arrayFib[1]=BigInteger.valueOf(1);
        for(int i=2;i<n+1;i++)
            arrayFib[i]=arrayFib[i-1].add(arrayFib[i-2]);
        return arrayFib[n];
    }

}

