/*public class A {
    C c=null;
    public A() {
        System.out.print("+10");
        C c1=new C();
        c=new C();
    }
    public static void main(String[] args) {
        A a = new A();
        System.gc();
        new C();
        a = null;
        System.gc();
    }
}
class C {
    static int count=0;
    String name=null;
    public C() {
        name="2"+(++count);
        System.out.print("+"+name);
    }
    protected void finalize() {
        System.out.print("-"+name);
    }
}

class B {
    int x=4;
    B(int x) {this.x=x;}
}
public class A {
    A() {
        B b1=new B(3);
        B b2=new B(3);
        System.out.println(b1.equals(b2));
    }
    public static void main(String Args[]) {
        new A();
    }
}

class B {
    int x=3;
    B(int x) {this.x=x;}
}
public class A {
    void f() {
        try {
            B b1 = new B(5);
            B b2 = (B) b1.clone();
            b2.x++;
            System.out.println(b1.x + " " + b2.x);
        } catch (Exception e) {e.printStackTrace();}
    }
    public static void main(String string[]) {
        A a=new A();
        a.f();
    }}



class DemoAssert {
    int x=5;
    private void stampaInteroPositivo(int i) {
        assert i >= 0 : stampaErroreAssert();
        System.out.println(i);
    }
    public int stampaErroreAssert() {
        System.out.println("XX");
        return -1;
    }
    public static void main(String args[]) {
        int x=10;
        DemoAssert test = new DemoAssert();
        test.stampaInteroPositivo(x);
    }
}
 */

public class A {
    static int a = 2;
    void f(int k) {
        System.out.print(k*3);
    }
    public static void main (String args[]){
        System.out.println(a);
        Object z = new B();
        if (z instanceof A) ((A) z).f(1);
        if (z instanceof B) ((B) z).f(2);
    }
}
class B extends A{
    protected B() {
    }

    void f(int k) {
        System.out.print(k);
    }
}