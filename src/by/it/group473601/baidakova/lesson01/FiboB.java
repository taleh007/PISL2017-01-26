package by.it.group473601.baidakova.lesson01;

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

        ArrayList<BigInteger> arrayFib=new ArrayList<>();

        for (int i=0;i<2;i++) arrayFib.add(BigInteger.ONE);

        for (int j=2;j<n;j++) {
            arrayFib.add(arrayFib.get(j-1).add(arrayFib.get(j-2)));
        }

        return arrayFib.get(n-1);
    }

}

