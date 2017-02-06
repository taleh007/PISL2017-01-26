package by.it.group473602.matys.lesson1;

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
		// решение практически невозможно найти интуитивно
		// вам потребуется дополнительный поиск информации
		// см. период Пизано
		
		List<Integer> sequenceList = new ArrayList<Integer>();
		sequenceList.add(0);
		sequenceList.add(1);

		for (int i = 2; i < 6 * m; i++) {
			sequenceList.add((sequenceList.get(i - 1) + sequenceList.get(i - 2)) % m);
			if (sequenceList.get(i) == 1 && sequenceList.get(i - 1) == 0)
				break;
		}

		int period = sequenceList.size() - 2;
		int value = (int) (n % period);
		
		return sequenceList.get(value);

	}

}
