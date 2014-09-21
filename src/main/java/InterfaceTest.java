import org.junit.Test;

/**
 * Created by Nastya on 06.09.2014.
 */
public class InterfaceTest {
    interface Instruments {
        final static String key = "До мажор";
        public void play();
    }
    class Drum implements Instruments {
        public void play() {
            System.out.println("бум бац бац бум бац бац");
        }
    }
    class Guitar implements Instruments {
        public void play() {
            System.out.println("до ми соль до ре до");
        }
    }

    @Test
    public void test() {
        new Guitar().play();
        new Drum().play();
    }
    //множественное наследование
    interface Interface1 {
        int someField = 100;
        String someMethod();
    }
    interface Interface2 {
        int someField = 200;
        String someMethod();
    }
    class SomeClass implements Interface1, Interface2 {
        public String someMethod() {
            return "It Works";
        }
    }
    @Test
    public void test2() {
            SomeClass a = new SomeClass();
            System.out.println( a.someMethod() ); // It works
            //System.out.println( a.someField ); // ошибка
            System.out.println( ( (Interface1) a).someField ); // 100
            System.out.println( Interface1.someField ); // 100
    }

    // Extending an interface with inheritance.
    interface Monster {
        void menace();
    }
    interface DangerousMonster extends Monster {
        void destroy();
    }
    interface Lethal {
        void kill();
    }
    class DragonZilla implements DangerousMonster {
        public void menace() {}
        public void destroy() {}
    }
    interface Vampire extends DangerousMonster, Lethal {
        void drinkBlood();
    }
    class VeryBadVampire implements Vampire { //should determine all methods
        public void menace() {}
        public void destroy() {}
        public void kill() {}
        public void drinkBlood() {}
    }
    public static class HorrorShow {
        static void u(Monster b) {
            b.menace();
        }
        static void v(DangerousMonster d) {
            d.menace();
            d.destroy();
        }
        static void w(Lethal l) {
            l.kill();
        }
    }
    @Test
    public void test3() {
        DangerousMonster barney = new DragonZilla();
        HorrorShow.u(barney);
        HorrorShow.v(barney);
        Vampire vlad = new VeryBadVampire();
        HorrorShow.u(vlad);
        HorrorShow.v(vlad);
        HorrorShow.w(vlad);
    }

}
