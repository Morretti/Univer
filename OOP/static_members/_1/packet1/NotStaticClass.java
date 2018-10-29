package OOP.static_members._1.packet1;


public class NotStaticClass {
    private int Id;
    public static int field;

    // Конструктор.
    public NotStaticClass(int Id) {
        this.Id = Id;
    }

    public void method() {
        System.out.println("Instance{0}.field = " + Id + ", " + field);
    }
}
