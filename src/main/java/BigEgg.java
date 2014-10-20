import org.junit.Test;

/**
 * Created by Nastya on 13.10.2014.
 */
class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() { System.out.println("Egg.Yolk()"); }
    }
    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
    //test inheritance of inner class that
    @Test
    public void test() {
           // new BigEgg();
        new BigEgg.Yolk();
    }
}

