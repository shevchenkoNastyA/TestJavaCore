/**
 * Created by Nastya on 19.10.2014.
 */
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

class Coffee {
    private long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
class Latte extends Coffee {
    public Latte() {
    }
}

class Mocha extends Coffee {
    public Mocha() {
    }
}

class Cappuccino extends Coffee {
    public Cappuccino() {
    }
} ///:~

class Americano extends Coffee {
    public Americano() {
    }
} ///:~

class Breve extends Coffee {
    public Breve() {
    }
} ///:~

public class Generics2Test {


    public class CoffeeGenerator implements Iterable<Coffee> {
        private Class[] types = { Latte.class, Mocha.class,
                Cappuccino.class, Americano.class, Breve.class };
        private Random rand = new Random(47);
        public CoffeeGenerator() {}
        // For iteration:
        private int size = 0;
        public CoffeeGenerator(int sz) { size = sz; }
        public Coffee next() {
            try {
                return (Coffee)
                        types[rand.nextInt(types.length)].newInstance();
// Report programmer errors at run time:
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
        class CoffeeIterator implements Iterator<Coffee> {
            int count = size;
            public boolean hasNext() { return count > 0; }
            public Coffee next() {
                count--;
                return CoffeeGenerator.this.next();
            }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
        public Iterator<Coffee> iterator() {
            return new CoffeeIterator();
        }
    }
    @Test
    public void test() {
        CoffeeGenerator gen = new CoffeeGenerator();
        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for(Coffee c : new CoffeeGenerator(5))///????
            System.out.println(c);
    }
}
