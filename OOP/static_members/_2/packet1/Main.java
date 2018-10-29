package OOP.static_members._2.packet1;


/**
 * В статических методах нельзя обращаться к нестатическим полям.
 */
public class Main {
    public static void main(String[] args) {
        NotStaticClass instance = new NotStaticClass(1);

        NotStaticClass.method();
    }
}
