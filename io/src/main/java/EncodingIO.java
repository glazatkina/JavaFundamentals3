import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by glazkina on 19.10.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class EncodingIO {
    public static void main(String[] args) {
        try (FileInputStream fileReader = new FileInputStream("io\\src\\main\\resources\\testUTF8.txt");
             FileOutputStream fileWriter = new FileOutputStream("io\\src\\main\\resources\\testUTF16.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(fileReader, Charset.forName("UTF8"));
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileWriter, Charset.forName("UTF16"))
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            int next;
            inputStreamReader.read();
            while ((next = inputStreamReader.read()) >= 0) {
                stringBuilder.append((char)next);
            }
            outputStreamWriter.write(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
