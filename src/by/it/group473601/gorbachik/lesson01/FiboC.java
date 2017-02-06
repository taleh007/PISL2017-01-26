package by.it.group473601.gorbachik.lesson01;

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
        int m = 1;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    private static ArrayList<Long> getPisanoSequencePeriod(long m){
        ArrayList<Long> sequence = new ArrayList();
        sequence.add((long)0);
        sequence.add((long)1);
        for(int i = 2; i < m * 6; i++){
            sequence.add((sequence.get(i - 1) + sequence.get(i - 2)) % m);
            if(sequence.get(i) == 1 && sequence.get(i-1) == 0){
                break;
            }
        }
        return sequence;
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<Long> sequence = getPisanoSequencePeriod(m);
        long period = sequence.size() - 2;
        int val = (int)(n % period);
        return sequence.get(val);
//        return 0L;
    }


}

