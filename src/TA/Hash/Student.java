package TA.Hash;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String patronymic;

    public Student(int id, String name, String surname, String patronymic) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(patronymic, student.patronymic);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, patronymic);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + patronymic;
    }
}
