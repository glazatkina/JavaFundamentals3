package task5;

import org.junit.Test;

import java.util.*;

/**
 * Created by glazkina on 07.10.2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class LearningTests {
    private List<Person> students;

    @Test
    public void compareTest() throws Exception {
        init();
        for (Person p : students) {
            p.compareGrades();
            System.out.println("_______________");
        }
    }

    @Test
    public void printTest() throws Exception {
        init();
        print();
        Courses.MATH.setGrade(Grade.INTEGER);
        print();
    }

    private void init() {
        students = new ArrayList<>();
        Person p = new Person("Ivan Ivanov", 1);
        p.setGrade(Courses.JAVA, 5);
        p.setGrade(Courses.MATH, 3.8);
        p.setGrade(Courses.LANGUAGE, 4.6);
        students.add(p);

        p = new Person("Anna Petrova", 2);
        p.setGrade(Courses.JAVA, 4.4);
        p.setGrade(Courses.MATH, 3);
        p.setGrade(Courses.LANGUAGE, 5);
        students.add(p);
    }

    private void print() {
        for (Person p: students) {
            System.out.println(p.toString());
        }
    }
}
