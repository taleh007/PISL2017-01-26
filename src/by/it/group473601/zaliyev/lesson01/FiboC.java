package by.it.group473601.zaliyev.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    long fasterC(long n, int m) {
        ArrayList<BigInteger> fibonachiArray = new ArrayList<>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE));
        ArrayList<Long> pizanoPeriod = new ArrayList<>(Arrays.asList(0L, 1L));
        for (long i = 2L; i <= 6 * m; i++) {
            fibonachiArray.add(fibonachiArray.get(Math.toIntExact(i - 2)).add(fibonachiArray.get(Math.toIntExact(i - 1))));
            pizanoPeriod.add(fibonachiArray.get(Math.toIntExact(i)).longValue() % m);
            if (pizanoPeriod.get(Math.toIntExact(i)) == 1 && pizanoPeriod.get(Math.toIntExact(i - 1)) == 0) {
                pizanoPeriod.remove(Math.toIntExact(i));
                pizanoPeriod.remove(Math.toIntExact(i - 1));
                i = 6 * m + 1;
            }
        }
        int length = pizanoPeriod.size();
        return pizanoPeriod.get(Math.toIntExact(n % length));
    }
}
