package javakatas;

/**
 * Created by g.bykov on 26/04/2017.
 */
public class TestInheritance {

    private static class A {

        String foo;

    }

    private static class B extends A {}

    public static void main(String[] args) {
        A a = new A();
        B b = (B) a;
        System.out.println("OK");
    }
}
