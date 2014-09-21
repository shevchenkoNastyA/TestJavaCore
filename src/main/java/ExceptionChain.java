import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Created by Nastya on 17.09.2014.
 */
//Exercise 10: (2) Create a class with two methods, f( ) and g( ). In g( ), throw an exception of a new type that you define.
//In f( ), call g( ), catch its exception and, in the catch clause,
//throw a different exception (of a second type that you define). Test your code in main( ).
class DynamicFieldsException extends Exception {}
public class ExceptionChain {
    public void f() throws DynamicFieldsException {
        try {
            g();
        } catch (DynamicFieldsException e){
            throw new NoSuchElementException();
        }
    }
    public void g() throws DynamicFieldsException {
       throw new DynamicFieldsException();
    }
    @Test
    public void test() {
        try {
           f();
        } catch(DynamicFieldsException e) {
            e.printStackTrace(System.out);
        } catch(NoSuchElementException e) {
            e.printStackTrace(System.out);
        }
    }
}

