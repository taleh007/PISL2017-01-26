package by.it.group473601.kalashynski.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;

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
        if (n < 3) {
            switch (n) {
                case 1:
                    return BigInteger.ZERO;
                case 2:
                    return BigInteger.ONE;
                default:
                    throw new IndexOutOfBoundsException("не правильный ввод");
            }
        } else {
            ArrayList<BigInteger> fibMas = new ArrayList<>();
            fibMas.add(BigInteger.ZERO);
            fibMas.add(BigInteger.ONE);
            for (int i = 2; i < n; i++) {
                fibMas.add(fibMas.get(i - 1).add(fibMas.get(i - 2)));
            }
            return fibMas.get(n - 1);
        }
    }
}

