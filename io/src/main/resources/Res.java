@SuppressWarnings("ALL")
public class Res {
    private static int testNumber;
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("Type your number: ");
        testNumber = Integer.parseInt(System.in.toString());
        System.out.println("Your number is " + testNumber);
    }
}