package serialization;

import java.io.Serializable;

/**
 * Created by glazkina on 20.10.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Movie implements Serializable{
    Movie() {}
    enum Genre {COMEDY, HORROR, THRILLER, MUSICAL, ANIMATION}
    private Actor[] mainRoles;
    private String title;
    private Genre genre;

    public Movie(Actor[] mainRoles, String title, Genre genre) {
        this.mainRoles = mainRoles;
        this.title = title;
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getActors() {
        StringBuilder res = new StringBuilder("MAIN ROLES:\n");
        for (Actor actor : mainRoles) {
            res.append(actor).append("\n");
        }
        return res.toString();
    }

    public void setGenre(Genre genre1) { genre = genre1;}

    @Override
    public String toString() {
        return getTitle() + " (" + getGenre() + ")\n" + getActors();
    }
}
