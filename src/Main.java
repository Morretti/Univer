package OOP.static_members._7.packet1;


/**
 * ����������� ����� �� ����� ���� ����������������� � ������������.
 * <p>
 * ����������� ����� ������������ ���������.
 */
abstract class BaseClass {
    //public abstract static void abstractStaticMethod(); // Error

    public static void staticMethod() {
        System.out.println("BaseClass.staticMethod");
    }
}

class DerivedClass extends BaseClass {
    public static void staticMethod() {
        System.out.println("DerivedClass.staticMethod");
    }
}

public class Main {
    public static void main(String[] args) {
        BaseClass baseClass = new DerivedClass();

        baseClass.staticMethod();
    }
}