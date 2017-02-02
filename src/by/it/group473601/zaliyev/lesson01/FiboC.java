package by.it.group473601.zaliyev.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;

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
        ArrayList<BigInteger> fibonachi_array = new ArrayList<>();
        fibonachi_array.add(BigInteger.ZERO);
        fibonachi_array.add(BigInteger.ONE);
        ArrayList<Long> pizano_period = new ArrayList<>();
        pizano_period.add(0L);
        pizano_period.add(1L);
//        1 получаем периодичную последовательность
        for (long i = 2L; i<=6*m; i++){
            fibonachi_array.add(fibonachi_array.get(Math.toIntExact(i-2)).add(fibonachi_array.get(Math.toIntExact(i-1))));
            pizano_period.add(fibonachi_array.get(Math.toIntExact(i)).longValue()% m);
            if(pizano_period.get(Math.toIntExact(i))==1 && pizano_period.get(Math.toIntExact(i-1)) == 0){
                pizano_period.remove(Math.toIntExact(i));
                pizano_period.remove(Math.toIntExact(i-1));
                i = 6*m+1;
            }
        }
//        2 берем ее длину
        int length = pizano_period.size();
//        3 делим n % длину периода Пизано, получаем I
//        4 берем I элемент периода

        return pizano_period.get(Math.toIntExact(n % length));
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано


    }
}
