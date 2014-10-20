import org.junit.Test;

import java.util.Random;

/**
 * Created by Nastya on 19.10.2014.
 */
public class StringTests {
    public class WhitherStringBuilder {
        public String implicit(String[] fields) {
            String result = "";
            for(int i = 0; i < fields.length; i++)
                result += fields[i];
            return result;
        }
        public String explicit(String[] fields) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < fields.length; i++)
                result.append(fields[i]);
            return result.toString();
        }
    }


    public class UsingStringBuilder {
        public Random rand = new Random(47);
        public String toString() {
            StringBuilder result = new StringBuilder("[");
            for(int i = 0; i < 25; i++) {
                result.append(rand.nextInt(100));
                result.append(", ");
            }
            result.delete(result.length()-2, result.length());
            result.append("]");
            return result.toString();
        }
    }
    @Test
    public void test(){
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }

    @Test
    public void test2() {
        String strVaska = "Васька";
        int year = 6;
        String strFinal = String.format(strVaska+ year);
        System.out.println(strFinal);
    }
}
