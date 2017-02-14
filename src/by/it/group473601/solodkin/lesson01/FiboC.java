package by.it.group473601.solodkin.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;

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
        if (n<m) {
            FiboB fiboB = new FiboB();
            return fiboB.fastB(new Long(n).intValue()).longValue();
        }
        ArrayList<Integer> surplus = new ArrayList<>();
        surplus.add(0);
        surplus.add(1);
        int period = 2;
        for (int i = 2; i < n; i++) {
            surplus.add((surplus.get(i - 1) + surplus.get(i - 2)) % m);
            if (surplus.get(i - 1) == 0 && surplus.get(i) == 1)
                break;
            period++;
        }
        return surplus.get(new Long(n % period).intValue());
    }


}

