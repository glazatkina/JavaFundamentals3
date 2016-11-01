package files;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("WeakerAccess")
public class NotWriteToFileException extends Exception {
    private String errorPath;

    public NotWriteToFileException(String errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public String toString() {
        return "NotWriteToFileException: file access \"" + errorPath + "\" to write denied!";
    }
}
