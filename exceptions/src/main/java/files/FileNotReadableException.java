package files;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("WeakerAccess")
public class FileNotReadableException extends Exception {
    private String errorPath;

    public FileNotReadableException(String errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public String toString() {
        return "FileNotReadableException: file \"" + errorPath + "\" wasn't read!";
    }
}
