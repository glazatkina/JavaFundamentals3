import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by glazkina on 18.10.2016.
 *
 * @author: Natalia Glazkina
 */
public class RegularExpressions {
    public static void main(String[] args) {

        //reading file with it's charset and append it to stringBuilder
        try (FileInputStream file = new FileInputStream("strings\\src\\main\\resources\\index.html");
             InputStreamReader inputStreamReader = new InputStreamReader(file, "windows-1251");
             BufferedReader in = new BufferedReader(inputStreamReader)) {
            String s;
            StringBuilder stringBuilder = new StringBuilder();
            while ((s = in.readLine()) != null) stringBuilder.append(s).append("\n");

            //creating regex for pics, it finds strings "picNN.jpg", NN - number of pic
            Pattern pattern = Pattern.compile("pic(\\d*)\\.jpg");
            Matcher matcher = pattern.matcher(stringBuilder);
            boolean isFollowing = true;
            int prevNum = 0;
            System.out.println("Images from HTML:");
            while (matcher.find()) {
                System.out.println(matcher.group());
                if (Integer.parseInt(matcher.group(1)) == prevNum + 1) {
                    prevNum++;
                } else {
                    isFollowing = false;
                }
            }
            System.out.println("_____________________");
            if (isFollowing) {
                System.out.println("All images in order");
            } else {
                System.out.println("Images not in order");
            }

            pattern = Pattern.compile("([А-Я][А-Яа-я,:\\- ()–0-9]*(рисун[а-я]{2,3}|\\(рис\\.[^)]*\\)|\\(Рис\\.[^)]*\\))[^.<]*[.?!] ?)", Pattern.UNICODE_CASE);
            matcher.reset();
            matcher.usePattern(pattern);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
