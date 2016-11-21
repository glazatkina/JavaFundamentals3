package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by glazkina on 01.11.2016.
 *
 * @author: Natalia Glazkina
 */
public class AnyPropertyReader {
    public static void main(String[] args) {

        //try to read wrong key
        try {
            ResourceBundle rc = ResourceBundle.getBundle("test");
            System.out.println(rc.getString("WrongKey"));
        } catch (MissingResourceException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //try to read wrong property file
        try {
            System.out.println(readProperty("C:\\Users\\glazkina\\IdeaProjects\\JavaFundamentals3\\strings\\src\\main\\resources\\LocalizationResources_en.properties", "bye"));
            System.out.println(readProperty("C:\\Users\\glazkina\\IdeaProjects\\JavaFundamentals3\\strings\\src\\main\\resources\\LocalizationResources_fr.properties", "bye"));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        //try to read wrong key
        try {
            System.out.println(readProperty("C:\\Users\\glazkina\\IdeaProjects\\JavaFundamentals3\\strings\\src\\main\\resources\\LocalizationResources_en.properties", "byeee"));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static  String readProperty(String propertyPath, String key) throws MissingResourceException {
        try (FileInputStream is = new FileInputStream(propertyPath)) {
            ResourceBundle rc = new PropertyResourceBundle(is);
            return rc.getString(key);
        } catch (MissingResourceException e) {
            throw new MissingResourceException("Wrong key: " + key, "AnyPropertyReader", key);
        } catch (IOException e) {
            throw new MissingResourceException("No such property file: " + propertyPath, "AnyPropertyReader", "NO KEY");
        }
    }
}
