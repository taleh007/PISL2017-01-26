package by.it.group473601.kalashynski.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.util.ArrayList;
import java.util.List;

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
        if (n < m) {
            return n;
        } else if (n == m) {
            return 0L;
        } else {
            List<Long> listFib = new ArrayList(){{
                this.add(new Long(0));
                this.add(new Long(1));
            }};
            List<Long> ostList = new ArrayList(){{
                this.add(new Long(0));
                this.add(new Long(1));
            }};
            boolean flag = true;
            for(int i=2;i<n;i++) {
                listFib.add((listFib.get(listFib.size()-1) + listFib.get(listFib.size() - 2)));
                if (flag) {
                    ostList.add(listFib.get(listFib.size() - 1) % m);
                    if (ostList.get(listFib.size()-1) == 1 && ostList.get(listFib.size() - 2) == 0) {
                        flag = false;
                    }
                }
            }
            return ostList.get(listFib.size() % (ostList.size()-2)-1);
        }
    }
}

