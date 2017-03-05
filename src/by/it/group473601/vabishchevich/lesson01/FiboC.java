package by.it.group473601.vabishchevich.lesson01;

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
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<Long> array =new ArrayList();
        array.add((long)0);
        array.add((long)1);
        for(int i=2;i<m*6;i++)
        {
            array.add((array.get(i-1)+ array.get(i-2))%m);
            if(array.get(i)==1 && array.get(i-1)==0)
            {
                break;
            }
        }
        int period=array.size()-2;
        int residual =(int)(n%period);
        return array.get(residual) ;
    }
}

