import org.junit.Test;

import java.util.Random;

/**
 * Created by Nastya on 06.09.2014.
 */
public class MathAndLogicalTests {
    @Test
    public void test() {
        int i = 1;
        System.out.print("i : " + i);
        System.out.print("++i : " + ++i); // Pre-increment
        System.out.print("i++ : " + i++); // Post-increment
        System.out.print("i : " + i);
        System.out.print("--i : " + --i); // Pre-decrement
        System.out.print("i-- : " + i--); // Post-decrement
        System.out.print("i : " + i);
    }
    @Test
    public void test2() {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
    }

    @Test
    public void test3() {
        Value v1 = new Value(1);
        Value v2 = new Value(1);
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));
    }
    @Test
    public void test4() {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        System.out.print("i = " + i);
        System.out.print("j = " + j);
        System.out.print("i > j is " + (i > j));
        System.out.print("i < j is " + (i < j));
        System.out.print("i >= j is " + (i >= j));
        System.out.print("i <= j is " + (i <= j));
        System.out.print("i == j is " + (i == j));
        System.out.print("i != j is " + (i != j));
// Treating an int as a boolean is not legal Java:
//! print("i && j is " + (i && j));
//! print("i || j is " + (i || j));
//! print("!i is " + !i);
        System.out.print("(i < 10) && (j < 10) is "
                + ((i < 10) && (j < 10)) );
        System.out.print("(i < 10) || (j < 10) is "
                + ((i < 10) || (j < 10)) );
    }
}
