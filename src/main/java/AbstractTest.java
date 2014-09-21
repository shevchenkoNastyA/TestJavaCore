import org.junit.Test;

/**
 * Created by Nastya on 06.09.2014.
 */
public class AbstractTest {
    abstract class A {
        int p1;
        A() {
            p1 = 1;
        }
        void print() {
            System.out.println(p1);
        }
    }
    class B extends A {
    }
    @Test
    public void test() {
           B ob2 = new B(); // будет вызван конструктов по умолчанию из A
           ob2.print();

    }
    @Test
    public void test1() {
        A ob1;
        B ob2 = new B();
        ob1 = (A) ob2; // явное приведение
        ob1.print();
        ob1 = ob2; // автоматическое приведение неявное
        ob1.print();
    }

    abstract class Pet {
        String name;
        int age;
        boolean hungry;
        abstract void voice();
        void food() {
            hungry = false;
        }
    }
    class Snake extends Pet {
        double length;
        void voice() {
            System.out.println("Шшш-ш-ш");
        }
    }
    class Dog extends Pet {
        void voice() {
            System.out.println("Гав-гав");
        }
    }

    @Test
    public void test3() {
        // ошибка: Pet zorka = new Pet();
        Dog nemo = new Dog();
        nemo.voice();
    }

    public abstract class ProcessorBase {
        public void process() {
            processData();
        }

        protected abstract void processData(); //abstract method can not have a body
    }
    public class ProcessorImpl extends ProcessorBase {
        @Override
        protected void processData() {
            System.out.println( "process Data" );
        }
    }

    @Test
    //abstract method
    public void test4() {
        ProcessorImpl processor = new ProcessorImpl();
        processor.process();
    }
    /*
    * Exercise 4: (3) Create an abstract class with no methods. Derive a class and add a method.
    * Create a static method that takes a reference to the base class, downcasts it to the derived class, and calls the method.
    * In main( ), demonstrate that it works.
     * Now put the abstract declaration for the method in the base class, thus eliminating the need for the downcast.
    * */
}
