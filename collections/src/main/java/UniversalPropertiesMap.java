import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by glazkina on 28.11.2016.
 *
 * @author: Natalia Glazkina
 */
public class UniversalPropertiesMap {
    public static void main(String[] args) {
        Map<String, String> properties = readPropertyFile("");
    }

    static Map<String, String> readPropertyFile(String fileName) {
        try (FileInputStream is = new FileInputStream(fileName)) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
