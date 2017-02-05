package by.it.group473601.gorbachik.lesson01;

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
        BigInteger[] fibo_array = new BigInteger[n+2];
        fibo_array[0]=BigInteger.ZERO;
        fibo_array[1]=BigInteger.ONE;
        for (int i=2; i<n+2;i++) {
            fibo_array[i]=fibo_array[i-1].add(fibo_array[i-2]);
        }
        return fibo_array[n];
    }

}

