package task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by glazkina on 07.10.2016.
 */
public class Person {
    private String name;
    private int id;
    private HashMap<Courses, Number> grades;


    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setGrade(Courses course, Number grade) {
        grades.put(course, grade);
    }
//    @Override
//    public String toString() {
//        String str // TODO: 07.10.2016
//    }
}
