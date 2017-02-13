package by.it.group473601.irina_petrova.lesson01;

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


    //здесь простейший вариант, в котором код совпадает с мат.определением чисел Фибоначчи
    //время O(2^n)
    private int calc(int n) {

        int first = 1, second = 1;
        if(n < 0){
            System.out.println("Error");
            n = 0;
        }
        switch (n) {
            case 0: return 0;
            case 1: return 1;
            case 2: return 1;
            default:
                for (int k = 1; k < n - 1; k++){
                second = second + first;
                first = second - first;
                }
                return second;
        }

    }


    //рекурсия
    //здесь нужно реализовать вариант без ограничения на размер числа,
    //в котором код совпадает с мат.определением чисел Фибоначчи
    //время O(2^n)
    BigInteger slowA(Integer n) {
        if(n < 0){
            System.out.println("Error");
            n = 0;
        }
        switch (n) {
            case 0: return BigInteger.ZERO;
            case 1: return BigInteger.ONE;
            case 2: return BigInteger.ONE;
        }
        return slowA(n - 1).add(slowA(n - 2));
    }
}

