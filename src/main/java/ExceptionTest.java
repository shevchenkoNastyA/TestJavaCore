import org.junit.Test;

/**
 * Created by Nastya on 14.09.2014.
 */
public class ExceptionTest {
    class SimpleException extends Exception {}
    public class InheritingExceptions {
        public void f() throws SimpleException {
            System.out.println("Throw SimpleException from f()");
            throw new SimpleException();
        }

    }
    // Creating your own exceptions.
    @Test
    public void test() {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch(SimpleException e) {
            System.out.println("Caught it!");
        }
    }
    /* Output:
Throw SimpleException from f()
3 As do most languages, including C++, C#, Python, D, etc.
Caught it!
*/
    class MyException extends Exception {
        public MyException() {}
        public MyException(String msg) { super(msg); }
    }
    public class FullConstructors {
        public void f() throws MyException {
            System.out.println("Throwing MyException from f()");
            throw new MyException();
        }
        public void g() throws MyException {
            System.out.println("Throwing MyException from g()");
            throw new MyException("Originated in g()");
        }
    }
    //constructor with a String argument
    //printStackTrace
    @Test
    public void test2() {
            try {
                new FullConstructors().f();
            } catch(MyException e) {
                e.printStackTrace(System.out);
            }
            try {
                new FullConstructors().g();
            } catch(MyException e) {
                e.printStackTrace(System.out);
            }
    }


    // Generate an exception to fill in the stack trace
    public class WhoCalled {
        void f() {
            try {
                throw new Exception();
            } catch (Exception e) {
                for(StackTraceElement ste : e.getStackTrace())
                    System.out.println(ste.getMethodName());
            }
        }
        void g() { f(); }
        void h() { g(); }
    }
    @Test
    public void test3() {
        new WhoCalled().f();
        System.out.println("--------------------------------");
        new WhoCalled().g();
        System.out.println("--------------------------------");
        new WhoCalled().h();
    }
//produce losing of the exception
class VeryImportantException extends Exception {
        public String toString() {
            return "A very important exception!";
        }
    }
    class HoHumException extends Exception {
        public String toString() {
            return "A trivial exception";
        }
    }
    public class LostMessage {
        void f() throws VeryImportantException {
            throw new VeryImportantException();
        }
        void dispose() throws HoHumException {
            throw new HoHumException();
        }

    }
     @Test
     public void test4() {
            try {
                LostMessage lm = new LostMessage();
                try {
                    lm.f();
                }
                finally {
                    lm.dispose();
                    //return;
                }
            } catch(Exception e) {
                System.out.println(e);
            }
     }
    /* Output:
A trivial exception
*/

// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

    //constructor
    //Demonstrate that a derived-class constructor cannot catch exceptions thrown by its base-class constructor.
    class DirevedException extends Exception {
        public DirevedException() {
          System.out.println("DirevedException");
    }
    class A {
        public A () throws DirevedException {
            throw new DirevedException();
        }
    }
    /*class B extends  A {
        public B() throws DirevedException {
            try {
                super();
            } catch (DirevedException e) {
                System.out.println("Catch");
            }
        }
    }*/
    }



    ////override method exception
    class A {
        public void msg() throws Exception {
        }
    }
    class B extends A {
        public void msg() {
            System.out.println("bla-bla");
        }
    }
    @Test
    public void test5() {
        new B().msg();
    }


}
