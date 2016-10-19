import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by glazkina on 19.10.2016.
 *
 * @author: Natalia Glazkina
 */
public class SymbolIO {
    public static void main(String[] args) {
        String[] keyWords = new String[] {"byte", "short", "int", "long", "float", "double", "char", "boolean",
                "do", "while", "for", "break", "continue","else", "switch", "case", "default","break",
                "private", "public", "protected", "final", "static", "abstract", "synchronized","volatile","strictfp",
                "false","true","null","return","void","package","import","try","catch","finally","throw",
                "throws","new","extends","implements","class","instanceof","this","super"
        };

        try(FileReader fileReader = new FileReader("io\\src\\main\\resources\\Res.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("io\\src\\main\\resources\\output")) {

            StringBuilder readBuilder = new StringBuilder();
            String next;
            while ((next = bufferedReader.readLine()) != null) {
                readBuilder.append(next).append("\n");
            }

            StringBuilder writeBuilder = new StringBuilder();
            for (String key: keyWords) {
                int i = 0;
                int total = 0;
                while ((i = readBuilder.indexOf(key, i)) >= 0) {
                    i++;
                    total++;
                }
                if (total > 0) {
                    writeBuilder.append(key).append(" ").append(total).append("\n");
                }
            }

            fileWriter.write(writeBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
