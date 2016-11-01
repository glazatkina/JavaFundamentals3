package files;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("WeakerAccess")
public class NotFileException extends Exception {
    private String errorPath;

    public NotFileException(String errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public String toString() {
        return "NotFileException: path \"" + errorPath + "\" incorrect!";
    }
}
