package by.it.group473601.borovsky.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;
import java.util.Locale;

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
        ArrayList<Long> output = new ArrayList<>();
        output.add(0,(long)0);
        output.add(1,(long)1);

        int i = 2;
        while (i < m*6){
            output.add((output.get(i-1) + output.get(i-2))%m);
            if(output.get(i-1) == 0 && output.get(i) == 1) break;
            i++;
        }
        long period = output.size() - 2;
        int index = (int)(n%period);
        return output.get(index);
    }


}

