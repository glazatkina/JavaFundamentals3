package files;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("WeakerAccess")
public class NotDirectoryException extends Exception{
    private String errorPath;

    public NotDirectoryException(String errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public String toString() {
        return "NotDirectoryException: incorrect path to directory: \"" + errorPath + "\"!";
    }
}
