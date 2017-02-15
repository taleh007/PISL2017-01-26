package by.it.group473602.kloster.lesson1;

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
        if(n<=0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        if (n == 2) return BigInteger.ONE;
        else {
            ArrayList<BigInteger> fibo1 = new ArrayList<>(n+1);
            fibo1.add(BigInteger.ZERO);
            fibo1.add(BigInteger.ONE);
            if (n > fibo1.size()) {
                for (int i=2;i<=n;i++) {
                    fibo1.add(i, fibo1.get(i-1).add(fibo1.get(i-2)));
                }

            }
            return fibo1.get(n);
        }

    }

}

