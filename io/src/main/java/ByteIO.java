import java.io.FileInputStream;

/**
 * Created by glazkina on 19.10.2016.
 *
 * @author: Natalia Glazkina
 */
public class ByteIO {

    public static void main(String[] args) {

        String[] keyWords = new String[] {"byte", "short", "int", "long", "float", "double", "char", "boolean",
                "do", "while", "for", "break", "continue","else", "switch", "case", "default","break",
                "private", "public", "protected", "final", "static", "abstract", "synchronized","volatile","strictfp",
                "false","true","null","return","void","package","import","try","catch","finally","throw",
                "throws","new","extends","implements","class","instanceof","this","super"
        };

        try(FileInputStream file = new FileInputStream("io\\src\\main\\resources\\Res.java")) {
            StringBuilder stringBuffer = new StringBuilder();
            int next;
            char c;
            while ((next = file.read()) != -1) {
                c = (char) next;
                stringBuffer.append(c);
            }
            for (String key: keyWords) {
                next = 0;
                int total = 0;
                while ((next = stringBuffer.indexOf(key, next)) >= 0) {
                    total++;
                    next++;
                }
                if (total > 0) {
                    System.out.println(key + " " + total);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
