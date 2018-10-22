package TA.Hash;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "Абакумова", "Вікторія", "Сергіївна"),
                new Student(2, "Васечек", "Ілля", "Сергійович"),
                new Student(3,"Затерка","Павло","Владиславович"),
                new Student(4, "Кіпренко", "Євгеній", "Валентинович"),
                new Student(5, "Корж", "Максим", "Віталійович"),
                new Student(17, "Філатов", "Віталій", "Віталійович"),
                new Student(1, "Неліпа", "Александр", "Дмитрович")
        };

        HashTable<Integer, Student> group = new HashTable<>();

        for(Student student : students){
            group.put(student.getId(),student);
        }

        group.print();
        System.out.println();

        System.out.println(group.get(17));

        group.remove(17);
        group.print();


//        HashTableArray<Integer,Student>group = new HashTableArray<>();
//
//        for(Student student : students){
//            group.put(student.getId(),student);
//        }
//
//        group.print();
//        System.out.println();
//
//        System.out.println(group.get(17));
//        group.remove(17);
//
//        group.print();
    }
}
