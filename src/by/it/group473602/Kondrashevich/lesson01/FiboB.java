package by.it.group473602.Kondrashevich.lesson01;

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
        if(n==0) return BigInteger.ZERO;

        ArrayList<BigInteger> list= new ArrayList<>();

        list.add(BigInteger.ZERO);
        list.add(BigInteger.ONE);

        for(int i=2;i<=n;i++)
            list.add(list.get(i-1).add(list.get(i-2)));

        return list.get(n);
    }

}

