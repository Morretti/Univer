package OOP.static_members._2.packet1;


public class NotStaticClass {
    private int id;

    // Конструктор.
    public NotStaticClass(int id) {
        this.id = id;
    }

    public static void method() {
        //System.out.println("Instance.id = {0}", id);

        System.out.println("Can't invoke non-static field");
    }
}
