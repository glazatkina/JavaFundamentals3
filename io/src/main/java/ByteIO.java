import java.io.FileInputStream;
import java.io.FileOutputStream;

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

        try(FileInputStream file = new FileInputStream("io\\src\\main\\resources\\Res.java");
            FileOutputStream fileOutputStream = new FileOutputStream("io\\src\\main\\resources\\output")) {
            StringBuilder stringInputBuilder = new StringBuilder();
            int next;
            char c;
            while ((next = file.read()) != -1) {
                c = (char) next;
                stringInputBuilder.append(c);
            }

            StringBuilder stringOutputBuilder = new StringBuilder();
            for (String key: keyWords) {
                next = 0;
                int total = 0;
                while ((next = stringInputBuilder.indexOf(key, next)) >= 0) {
                    total++;
                    next++;
                }
                if (total > 0) {
                    stringOutputBuilder.append(key).append(" ").append(total).append("\n");
                }
            }

            for (int i = 0; i < stringOutputBuilder.length(); ++i) {
                fileOutputStream.write((byte)stringOutputBuilder.charAt(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
