package localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by glazkina on 14.10.2016.
 *  @author: Natalia Glazkina
 */
public class LocalizatorTest {

    public static void main(String[] args) {

        System.out.println("Type 1 if you want English localization\nВведите 2, если Ваш язык русский:\n");
        Scanner scanner = new Scanner(System.in);
        Locale locale;
        if (scanner.hasNextInt()) {
            switch (scanner.nextInt()) {
                case 1:
                    locale = new Locale("en");
                    break;
                case 2:
                    locale = new Locale("ru");
                    break;
                default:
                    System.out.println("Sorry, your input incorrect, you will use English locale");
                    locale = new Locale("en");
            }
        } else {
            System.out.println("Sorry, your input incorrect, you will use English locale");
            locale = new Locale("en");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("LocalizationResources", locale);

        System.out.println(resourceBundle.getString("test_info"));
        for (int i = 1; i < 5; ++i) {
            System.out.println("\t"+ i + ". " + resourceBundle.getString("question_" + i));
        }
        System.out.println(resourceBundle.getString("next"));

        while (scanner.hasNext() && scanner.next().equals(resourceBundle.getString("yes"))) {
            System.out.println(resourceBundle.getString("get_ans"));
            if (scanner.hasNextInt()) {
                int ans = scanner.nextInt();
                if (ans > 0 && ans < 5) {
                    System.out.println(resourceBundle.getString("ans_" + ans));
                } else break;
            } else break;
            System.out.println(resourceBundle.getString("next"));
        }
        System.out.println(resourceBundle.getString("bye"));
    }
}
