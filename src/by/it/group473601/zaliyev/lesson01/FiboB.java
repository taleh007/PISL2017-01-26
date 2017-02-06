package by.it.group473601.zaliyev.lesson01;

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
        int n = 33333;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        ArrayList<BigInteger> values = new ArrayList<> ();
        values.add(BigInteger.ONE);
        values.add(BigInteger.ONE);
        if ( n < 3 )
            return BigInteger.ONE;
        else {
            for( int i = 2; i < n; i++ ){
                values.add(values.get(i-2).add(values.get(i-1)));
            }
            return values.get(n-1);
        }
    }

}

