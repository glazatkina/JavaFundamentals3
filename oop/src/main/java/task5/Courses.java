package task5;

/**
 * Created by glazkina on 29.09.2016.
 */
public enum Courses {
    MATH(Grade.DOUBLE),
    LANGUAGE(Grade.INTEGER),
    JAVA(Grade.INTEGER);

    private Grade grade;
    private Courses(Grade _grade) {grade = _grade;}
    public Grade getGrade() {return grade;}
}

enum Grade {
    DOUBLE,
    INTEGER
}