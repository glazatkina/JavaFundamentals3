package task5;

/**
 * Created by glazkina on 29.09.2016.
 */

@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate"})
public enum Courses {
    MATH(Grade.DOUBLE),
    LANGUAGE(Grade.INTEGER),
    JAVA(Grade.INTEGER);

    private Grade grade;
    Courses(Grade _grade) {grade = _grade;}
    public Grade getGrade() {return grade;}
    public void setGrade(Grade _grade) {grade = _grade;}
}

enum Grade {
    DOUBLE,
    INTEGER
}