/**
 * Created by Nastya on 09.10.2014.
 */
public class StaticA {
    private static int InitX() {
        System.out.println("A.InitX()");
        return 1;
    }
    private static int InitY() {
        System.out.println ( "A.InitY()" );
        return 2;
    }
    private static int InitA() {
        System.out.println("A.InitA()");
        return 3;
    }
    private static int InitB() {
        System.out.println("A.InitB()");
        return 4;
    }
    private int у = InitY();
    private int x = InitX();
    private static int a = InitA();
    private static int b = InitB();

}


