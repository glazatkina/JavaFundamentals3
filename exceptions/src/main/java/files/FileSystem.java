package files;

import java.io.*;

/**
 * Created by glazkina on 21.10.2016.
 *
 * @author: Natalia Glazkina
 */
@SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
public class FileSystem {
    public static void main(String[] args) {
        printFiles("exceptions\\src\\main\\java\\files\\");
        printFiles(".");
        readFile("exceptions\\src\\main\\resources\\readTestFile");
        createTextFile("exceptions\\src\\main\\resources\\createFile");
        write("exceptions\\src\\main\\resources\\createFile", "It's my new message!");
        deleteTextFile("exceptions\\src\\main\\resources\\createFile");
    }

    private static void printFiles(String dirPath) {
        File file = new File(dirPath);
        if (file.isDirectory()) {
            System.out.println("List of files and subdirectories:\n" + file.getAbsolutePath());
            for (String subFile: file.list()) {
                System.out.println("|----> " + subFile);
            }
            System.out.println("");
        }
    }

    private static void readFile(String filePath) {
        File file = new File(filePath);
        if (file.isFile()) {
            if (file.canRead()) {
                System.out.println("File " + file.getName() + ":");
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                        byte n;
                        while ((n = (byte)fileInputStream.read()) != -1)
                            System.out.print((char)n);
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void createTextFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void deleteTextFile(String filePath) {
        File file = new File (filePath);
        if (file.isFile()) {
            file.delete();
        }
    }

    private static void write(String filePath, String message) {
        File file = new File(filePath);
        if (file.isFile()) {
            if (file.canWrite()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    for (int i = 0; i < message.length(); ++i) {
                        fileOutputStream.write((byte)message.charAt(i));
                    }
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
