import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nastya on 19.10.2014.
 */
public class GenericsTest {
    public class RandomList<T> {
        private ArrayList<T> storage = new ArrayList<T>();
        private Random rand = new Random(47);
        public void add(T item) { storage.add(item); }
        public T select() {
            return storage.get(rand.nextInt(storage.size()));
        }
    }
    @Test
    public void test() {
        RandomList<String> rs = new RandomList<String>();
        for(String s: ("The quick brown fox jumped over " +
                "the lazy brown dog").split(" "))
            rs.add(s);
        for(int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
    }
//wrong
   // List<?> numList = new ArrayList<Integer>();
    //numList = new ArrayList<String>();
    //right
    //List<? extends Number> numList = new ArrayList<Integer>();
   // numList = new ArrayList<String>();
}
