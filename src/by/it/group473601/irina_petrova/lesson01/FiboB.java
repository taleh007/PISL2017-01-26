package by.it.group473601.irina_petrova.lesson01;

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

    //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
    BigInteger fastB(Integer n) {
        ArrayList<BigInteger> bigIntegerArrayList = new ArrayList<>();
        bigIntegerArrayList.add(BigInteger.ZERO);
        bigIntegerArrayList.add(BigInteger.ONE);
        bigIntegerArrayList.add(BigInteger.ONE);
        if(n < 0){
            System.out.println("Error");
            n = 0;
        }
        switch (n) {
            case 0: return BigInteger.ZERO;
            case 1: return BigInteger.ONE;
            case 2: return BigInteger.ONE;
            default:
                for (int k = 3; k <= n; k++){
                    bigIntegerArrayList.add(bigIntegerArrayList.get(k - 2).add(bigIntegerArrayList.get(k - 1)));
                }
                return bigIntegerArrayList.get(n);
        }
    }
}

