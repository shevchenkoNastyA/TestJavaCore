import org.junit.Test;

/**
 * Created by Nastya on 09.10.2014.
 */
public class main {
    @Test
    public void test() {
        StaticA a = new StaticA();
    }
    //test inherited inner class
    @Test
    public void test2() {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
