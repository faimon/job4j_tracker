package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenGetAClass() {
        Student student = new Student("ivan", 50);
        Student student1 = new Student("Sasha", 90);
        Student student2 = new Student("Vasya", 30);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        List<Student> rsl = School.collect(students, (x) -> x.getScore() >= 70 && x.getScore() <= 100);
        List<Student> excepted = Arrays.asList(student1);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenGetBClass() {
        Student student = new Student("ivan", 50);
        Student student1 = new Student("Sasha", 90);
        Student student2 = new Student("Vasya", 30);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        List<Student> rsl = School.collect(students, (x) -> x.getScore() >= 50 && x.getScore() < 70);
        List<Student> excepted = Arrays.asList(student);
        assertThat(rsl, is(excepted));
    }

    @Test
    public void whenGetCClass() {
        Student student = new Student("ivan", 50);
        Student student1 = new Student("Sasha", 90);
        Student student2 = new Student("Vasya", 30);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        List<Student> rsl = School.collect(students, (x) -> x.getScore() > 0 && x.getScore() < 50);
        List<Student> excepted = Arrays.asList(student2);
        assertThat(rsl, is(excepted));
    }
}