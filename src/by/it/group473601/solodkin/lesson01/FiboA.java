package by.it.group473601.solodkin.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить рекурсивный способ вычисления чисел Фибоначчи
 */

public class FiboA {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboA fibo = new FiboA();
        int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        //вычисление чисел фибоначчи медленным методом (рекурсией)
        fibo = new FiboA();
        n = 33;
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());
    }


    private int calc(int n) {
        int a=1, b=1;
        for (int i=0; i<n-2; i++) {
            if (a<b)
                a+=b;
            else
                b+=a;
        }
        return a > b ? a : b;
    }


    BigInteger slowA(Integer n) {
        if (n <= 2)
            return BigInteger.ONE;
        else
            return slowA(n-1).add(slowA(n-2));
    }



}

