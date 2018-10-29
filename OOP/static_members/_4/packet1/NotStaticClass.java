package OOP.static_members._4.packet1;


/**
 * Статические блоки.
 * Статических блоков может быть сколько угодно и вызываться они будут в том же порядке, в котором написаны.
 */
public class NotStaticClass {
    static int x;

    static {
        x = 1;
        System.out.println("Static block  x = " + x);
    }

    static {
        x = 23;
        System.out.println("Static block  x = " + x);
    }

    static {
        x = -99;
        System.out.println("Static block  x = " + x);
    }

    public NotStaticClass(int x) {
        this.x = x;
        System.out.println("Constructor  X = " + x);
    }
}
