package task6;

/**
 * Created by glazkina on 11.10.2016.
 */
@SuppressWarnings({"DefaultFileTemplate", "unused", "WeakerAccess"})
public class Submarine {
    private class SubmarineEngine {
        SubmarineEngine() {
            System.out.println("Engine start");
        }
    }

    SubmarineEngine submarineEngine() {
        return new SubmarineEngine();
    }

    public static void main(String[] args) {
        Submarine submarine = new Submarine();
        SubmarineEngine submarineEngine = submarine.submarineEngine();
    }
}
