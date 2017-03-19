package by.it.group473601.zaliyev.lesson04;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Lesson4Test {
    @Test
    public void A() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zaliyev/lesson04/dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        int[] result = instance.findIndex(stream);
        StringBuilder sb = new StringBuilder();
        for (int index : result) {
            sb.append(index).append(" ");
        }
        boolean ok = sb.toString().trim().equals("3 1 -1 1 -1");
        assertTrue("A failed", ok);
    }

    @Test
    public void B() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zaliyev/lesson04/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        int[] result = instance.getMergeSort(stream);
        boolean ok = result.length > 3;
        int test[] = new int[result.length];
        System.arraycopy(result, 0, test, 0, result.length);
        Arrays.sort(test);
        for (int i = 0; i < result.length && ok; i++) {
            ok = (result[i] == test[i]);
        }
        assertTrue("B failed", ok);
    }

    @Test
    public void C() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group473601/zaliyev/lesson04/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        long result = instance.calc(stream);
        assertTrue("C failed", 2 == result);
    }
}
