import org.junit.Test;

/**
 * Created by Nastya on 06.09.2014.
 */
public class PolymorfismTest {
    public enum Note {
        MIDDLE_C, C_SHARP, B_FLAT; // Etc.
    }
    class Instrument {
        public void play(Note n) {
            System.out.print("Instrument.play()");
        }
    }
    // Wind objects are instruments
    // because they have the same interface:
    public class Wind extends Instrument {
        // Redefine interface method:
        public void play(Note n) {
            System.out.println("Wind.play() " + n);
        }
    }
    // Inheritance & upcasting.
    public void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
    @Test
    public void test() {
        Wind flute = new Wind();
        tune(flute); // Upcasting Output: Wind.play() MIDDLE_C
    }

    // Overloading instead of upcasting
    class Stringed extends Instrument {
        public void play(Note n) {
            System.out.println("Stringed.play() " + n);
        }
    }
    class Brass extends Instrument {
        public void play(Note n) {
            System.out.println("Brass.play() " + n);
        }
    }
    public class Music2 {
        public void tune(Wind i) {
            i.play(Note.MIDDLE_C);
        }

        public void tune(Stringed i) {
            i.play(Note.MIDDLE_C);
        }

        public void tune(Brass i) {
            i.play(Note.MIDDLE_C);
        }
    }
    @Test
    public void test2() {
        Wind flute = new Wind();
        Stringed violin = new Stringed();
        Brass frenchHorn = new Brass();
        tune(flute); // No upcasting
        tune(violin);
        tune(frenchHorn);
    }
        /* Output:
    Wind.play() MIDDLE_C
    Stringed.play() MIDDLE_C
    Brass.play() MIDDLE_C*/

   /* Create a base class with two methods.
    In the first method, call the second method.
    Inherit a class and override the second method.
    Create an object of the derived class, upcast it to the base type, and call the first method.
    Explain what happens.*/

    class A {
        private int someField = 1;
        public void doSomehing() {
            System.out.print("A:" + someField);
        }
    }
    class B extends A {
        private int someField = 2;
        @Override
        public void doSomehing() {
            System.out.print("B:" + someField);
        }
    }
    static void method(A a) {
        System.out.println("Method A");
    }

    static void method(B b) {
        System.out.println("Method B");
    }

    @Test
    public void test3() {
      B b = new B();
      A a = (A) b;
      a.doSomehing(); //B
      //usefull upcast
      method(b);   // "Method B"
      // upcasting a B into an A:
      method((A) b); // "Method A"
    }

    //constructors
// Order of constructor calls.
    class Meal {
        Meal() { System.out.print("Meal()"); }
    }
    class Lunch extends Meal {
        Lunch() { System.out.print("Lunch()"); }
    }
    class PortableLunch extends Lunch {
        PortableLunch() { System.out.print("PortableLunch()");}
    }
    public class Sandwich extends PortableLunch {
        public Sandwich() { System.out.print("Sandwich()"); }
    }

    @Test
    public void test4() {
        new Sandwich();
    }

    // Constructors and polymorphism
    class Glyph {
        void draw() { System.out.print("Glyph.draw()"); }
        Glyph() {
            System.out.print("Glyph() before draw()");
            draw();
            System.out.print("Glyph() after draw()");
        }
    }
    class RoundGlyph extends Glyph {
        private int radius = 1;
        RoundGlyph(int r) {
            radius = r;
            System.out.print("RoundGlyph.RoundGlyph(), radius = " + radius);
        }
        void draw() {
            System.out.print("RoundGlyph.draw(), radius = " + radius);
        }
    }
    @Test
    public void test5() {
       new RoundGlyph(5);
    }
}
