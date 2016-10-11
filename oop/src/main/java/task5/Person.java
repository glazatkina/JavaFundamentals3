package task5;

import java.util.EnumMap;
@SuppressWarnings("WeakerAccess")
public class Person {
    private String name;
    private int id;
    private EnumMap<Courses, Number> grades;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
        grades = new EnumMap<>(Courses.class);
    }

    public void setGrade(Courses course, Number grade) {
        switch (course.getGrade()) {
            case DOUBLE:
                grades.put(course, grade.doubleValue());
                break;
            case INTEGER:
                grades.put(course, grade.intValue());
        }

    }

    @Override
    public String toString() {
        String str = "PERSON ID#" + Integer.toString(id) + " " + name + "\n";
        str += "_______________________\n";
        for (EnumMap.Entry<Courses, Number> grade: grades.entrySet()) {
            str += grade.getKey().toString() + " - ";
            switch (grade.getKey().getGrade()) {
                case DOUBLE:
                    str += Double.toString(grade.getValue().doubleValue()) + "\n";
                    break;
                case INTEGER:
                    str += Integer.toString(grade.getValue().intValue()) + "\n";
                    break;
            }
        }
        str += "\n";
        return str;
    }

    public void compareGrades() {
        Courses maxCourse = Courses.JAVA;
        Courses minCourse = Courses.JAVA;
        Number maxGrade = -1;
        Number minGrade = 10;
        for (EnumMap.Entry<Courses, Number> grade: grades.entrySet()) {
            if (maxGrade.doubleValue() < grade.getValue().doubleValue()) {
                maxCourse = grade.getKey();
                maxGrade = grade.getValue();
            }

            if (minGrade.doubleValue() > grade.getValue().doubleValue()) {
                minCourse = grade.getKey();
                minGrade = grade.getValue();
            }
        }
        System.out.println("PERSON ID#" + Integer.toString(id) + " " + name);
        System.out.print("Best grade at " + maxCourse.name() + ": ");
        switch (maxCourse.getGrade()) {
            case DOUBLE:
                System.out.println(Double.toString(maxGrade.doubleValue()));
                break;
            case INTEGER:
                System.out.println(Integer.toString(maxGrade.intValue()));
        }

        System.out.print("The worst grade at " + minCourse.name() + ": ");
        switch (minCourse.getGrade()) {
            case INTEGER:
                System.out.println(Integer.toString(minGrade.intValue()));
                break;
            case DOUBLE:
                System.out.println(Double.toString(minGrade.doubleValue()));
        }
    }
}
