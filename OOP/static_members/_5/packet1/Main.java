package OOP.static_members._5.packet1;


public class Main {
    public static void main(String[] args) {
        // 1 Вариант. (Вызывается только Статический конструктор.)
        NotStaticClass nc = new NotStaticClass();
        NotStaticClass nc1 = new NotStaticClass();
        NotStaticClass.staticMethod();

        // 2 Вариант. (Вызываются оба Конструктора.)
        // new NotStaticClass().notStaticMethod();
    }
}
