package by.it.group473601.atamanchuk.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано

        ArrayList<Long> cached = new ArrayList<Long>();
        long fibPrev = 0;
        long fib = 1;
        cached.add(fibPrev);
        cached.add(fib);
        for (int i = 2; i < n + 1; i++) {
            long fibOld = fib;
            fib = (fib + fibPrev) % m;
            fibPrev = fibOld;
            if(fibPrev==0&&fib==1)
            {
                cached.remove(cached.size()-1);
                break;
            }
            else
            {
                cached.add(fib);
            }

        }

        int offset = (int) (n%cached.size());
        return cached.get(offset);


    }



}

