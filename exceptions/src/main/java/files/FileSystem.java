package files;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by glazkina on 21.10.2016.
 *
 * @author: Natalia Glazkina
 */
public class FileSystem {
    public static void main(String[] args) {
        OKTests();
        ErrorTests();
    }

    private static void OKTests() {
        //OK
        try {
            printFiles("exceptions\\src\\main\\java\\files\\");
        } catch (NotDirectoryException e) {
            e.printStackTrace();
        }

        //OK
        try {
            printFiles(".");
        } catch (NotDirectoryException e) {
            e.printStackTrace();
        }

        //OK
        try {
            readFile("exceptions\\src\\main\\resources\\readTestFile");
        } catch (NotFileException | FileNotReadableException e) {
            e.printStackTrace();
        }

        //OK
        createTextFile("exceptions\\src\\main\\resources\\createFile");
        //OK
        try {
            write("exceptions\\src\\main\\resources\\createFile", "It's my new message!");
        } catch (NotFileException | NotWriteToFileException e) {
            e.printStackTrace();
        }

        //OK
        try {
            deleteTextFile("exceptions\\src\\main\\resources\\createFile");
        } catch (NotFileException | FileNotDeletedException e) {
            e.printStackTrace();
        }
    }

    private static void ErrorTests() {
        //ERROR
        try {
            printFiles("exceptions\\src\\main\\java\\files\\file");
        } catch (NotDirectoryException e) {
            e.printStackTrace();
        }

        //ERROR
        try {
            deleteTextFile("exceptions\\src\\main\\resources\\createFile");
        } catch (NotFileException | FileNotDeletedException e) {
            e.printStackTrace();
        }

        //ERROR
        try {
            readFile("exceptions\\src\\main\\resources\\createFile");
        } catch (NotFileException | FileNotReadableException e) {
            e.printStackTrace();
        }

        //ERROR
        try {
            write("exceptions\\src\\main\\resources\\creaeFile", "It's my new message!");
        } catch (NotFileException | NotWriteToFileException e) {
            e.printStackTrace();
        }


    }

    private static void printFiles(String dirPath) throws NotDirectoryException {
        File file = new File(dirPath);
        if (file.isDirectory()) {
            System.out.println("List of files and subdirectories:\n" + file.getAbsolutePath());
            //noinspection ConstantConditions
            for (String subFile: file.list()) {
                System.out.println("|----> " + subFile);
            }
            System.out.println("");
        } else throw new NotDirectoryException(dirPath);
    }

    private static void readFile(String filePath) throws NotFileException, FileNotReadableException {
        File file = new File(filePath);
        if (file.isFile()) {
            if (file.canRead()) {
                System.out.println("File " + file.getName() + ":");
                try (FileInputStream fileInputStream = new FileInputStream(file)){
                        byte n;
                        while ((n = (byte) fileInputStream.read()) != -1)
                            System.out.print((char) n);
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else throw new FileNotReadableException(filePath);
        } else throw new NotFileException(filePath);
    }

    private static void createTextFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new FileAlreadyExistsException(filePath);
                }
            } catch (IOException e) {
                System.out.println(e.toString() + " File path:" + filePath);
            }
        }
    }

    private static void deleteTextFile(String filePath) throws NotFileException, FileNotDeletedException {
        File file = new File (filePath);
        if (file.isFile()) {
            if (!file.delete()) {
                throw new FileNotDeletedException(filePath);
            }
        } else throw new NotFileException(filePath);
    }

    private static void write(String filePath, String message) throws NotFileException, NotWriteToFileException {
        File file = new File(filePath);
        if (file.isFile()) {
            if (file.canWrite()) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
                    for (int i = 0; i < message.length(); ++i) {
                        fileOutputStream.write((byte)message.charAt(i));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else throw new NotWriteToFileException(filePath);
        } else throw new NotFileException(filePath);
    }
}
