import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Nastya on 20.09.2014.
 */
public class ArraysClass {
    ///3-d array
    @Test
    public void test() {
        Random rand = new Random(47);
        int[][][] a = new int[rand.nextInt(7)][][];
        for(int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for(int j = 0; j < a[i].length; j++)
                a[i][j] = new int[rand.nextInt(5)];
        }
        System.out.println(Arrays.deepToString(a));
    }

    //demonstrate generics
    @Test
    public void test2() {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<String>();
        // Compile-time checking produces an error:
        // ls[1] = new ArrayList<Integer>();
        // The problem: List<String> is a subtype of Object
        Object[] objects = ls; // So assignment is OK
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();
    }

    //Arrays utility
    //comparing arrays
    @Test
    public void test3 () {
            int[] a1 = new int[10];
            int[] a2 = new int[10];
            Arrays.fill(a1, 47);
            Arrays.fill(a2, 47);
            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.equals(a1, a2));
            a2[3] = 11;
            System.out.println(Arrays.equals(a1, a2));
            String[] s1 = new String[4];
            Arrays.fill(s1, "Hi");

            String[] s2 = { new String("Hi"), new String("Hi"), ///method equal is overriden
                    new String("Hi"), new String("Hi") };
            System.out.println(Arrays.equals(s1, s2));
        }
/* Output:
true
false
true
*/
    //(2) Create a class with an int field that’s initialized from a constructor argument.
    // Create two arrays of these objects, using identical initialization values for each array, and show that Arrays.equals( )
    // says that they are unequal.
    // Add an equals( ) method to your class to fix the problem.
    class SomeClass {
    public int getField() {
        return field;
    }

    private int field;
        public SomeClass(int number) {
            this.field = number;
        }

        @Override
        public boolean equals(Object obj) {
            SomeClass cl = (SomeClass)obj;
            return this.field == cl.getField();
        }
    }

    @Test
    public void test4 () {
        SomeClass[] s1 = new SomeClass[1];
        s1[0] = new SomeClass(3);
        SomeClass[] s2 = new SomeClass[1];
        s2[0] = new SomeClass(3);
        System.out.println(Arrays.equals(s1, s2));
    }
}
