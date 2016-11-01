package files;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("WeakerAccess")
public class FileNotDeletedException extends Exception {
    private String errorPath;

    public FileNotDeletedException(String errorPath) {
        this.errorPath = errorPath;
    }

    @Override
    public String toString() {
        return "FileNotDeletedException: file or directory \"" + errorPath + "\" wasn't been deleted!";
    }
}
