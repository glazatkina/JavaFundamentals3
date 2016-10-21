package serialization;

import java.io.Serializable;

/**
 * Created by glazkina on 20.10.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Actor implements Serializable{
    Actor() {}
    enum Gender {MALE, FEMALE}
    private Gender gender;
    private String name;
    private String surname;

    public Actor(Gender gender, String name, String surname) {
        this.gender = gender;
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        if (getGender() == Gender.FEMALE) {
            return "ACTRESS: " + getFullName();
        } else {
            return "ACTOR: " + getFullName();
        }
    }
}
