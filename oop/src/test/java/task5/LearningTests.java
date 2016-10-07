package task5;

import org.junit.Test;

import java.util.List;

/**
 * Created by glazkina on 07.10.2016.
 */
public class LearningTests {
    List<Person> students;

    @Test
    public void compareTest() throws Exception {
        init();
    }

    void init() {
        Person p = new Person("Ivan Ivanov", 1);
        p.setGrade(Courses.JAVA, 5);
        p.setGrade(Courses.MATH, 3);
        p.setGrade(Courses.LANGUAGE, 4);
    }
}
