import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by glazkina on 28.11.2016.
 *
 * @author: Natalia Glazkina
 */
public class UniversalPropertiesMap {
    public static void main(String[] args) {
        Map<String, String> properties = readPropertyFile("C:\\Users\\glazkina\\IdeaProjects\\JavaFundamentals3\\strings\\src\\main\\resources\\LocalizationResources_en.properties");
        System.out.println(properties);
    }

    @SuppressWarnings("WeakerAccess")
    static Map<String, String> readPropertyFile(String fileName) {
        Map<String,String> result = new HashMap<>();
        try (FileInputStream is = new FileInputStream(fileName)) {
            ResourceBundle rc = new PropertyResourceBundle(is);
            for (String key: rc.keySet()) {
                result.put(key, rc.getString(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
