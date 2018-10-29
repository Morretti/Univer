package OOP.static_members._6.packet1;


public abstract class AbstractClass {
    // Статический фабричный метод.
    public static AbstractClass CreateObject() {
        return new ConcreteClass();
    }

    public abstract void method();
}

