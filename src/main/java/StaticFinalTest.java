import org.junit.Test;

import java.util.Random;

/**
 * Created by Nastya on 06.09.2014.
 */

class Value {
    int i; // Package access
    public Value(int i) { this.i = i; }
}
public class StaticFinalTest {
    private static Random rand = new Random(47);
    private String id;
    public StaticFinalTest(String id) { this.id = id; }
    // Can be compile-time constants:
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;
    // Typical public constant:
    public static final int VALUE_THREE = 39;
    // Cannot be compile-time constants:
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);
    // Arrays:
    private final int[] a = { 1, 2, 3, 4, 5, 6 };
    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    @Test
    public void test() {
        StaticFinalTest fd1 = new StaticFinalTest("fd1");
        //! fd1.valueOne++; // Error: can’t change value
        fd1.v2.i++; // Object isn’t constant!
        fd1.v1 = new Value(9); // OK -- not final
        for(int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++; // Object isn’t constant!
        //! fd1.v2 = new Value(0); // Error: Can’t
        //! fd1.VAL_3 = new Value(1); // change reference
        //! fd1.a = new int[3];
        System.out.print(fd1);
        System.out.print("Creating new FinalData");
        StaticFinalTest fd2 = new StaticFinalTest("fd2");
        System.out.print(fd1);
        System.out.print(fd2);
    }
/* Output:
fd1: i4 = 15, INT_5 = 18
Creating new FinalData
fd1: i4 = 15, INT_5 = 18
fd2: i4 = 13, INT_5 = 18
*/
class WithFinals {
    // Identical to "private" alone:
    private final void f() { System.out.print("WithFinals.f()"); }
    // Also automatically "final":
    private void g() { System.out.print("WithFinals.g()"); }
}
class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.print("OverridingPrivate.f()");
    }
    private void g() {
        System.out.print("OverridingPrivate.g()");
    }
}
class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.print("OverridingPrivate2.f()");
    }
    public void g() {
        System.out.print("OverridingPrivate2.g()");
    }
}
@Test
public void test3() {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can’t call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
}
}
/* Output:
OverridingPrivate2.f()
OverridingPrivate2.g()
*/
