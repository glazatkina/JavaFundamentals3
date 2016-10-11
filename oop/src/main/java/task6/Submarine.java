package task6;

/**
 * Created by glazkina on 11.10.2016.
 */
@SuppressWarnings({"DefaultFileTemplate", "unused", "WeakerAccess"})
@SubmarineAnnotation(color="grey")
public class Submarine {
    private String name;

    public Submarine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private class SubmarineEngine {
        SubmarineEngine() {
            System.out.println("Submarine " + name + ": Engine start");
        }
    }

    SubmarineEngine submarineEngine() {
        return new SubmarineEngine();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Submarine submarine = new Submarine("LODKA");
        SubmarineEngine submarineEngine = submarine.submarineEngine();

        Class cl = Class.forName("task6.Submarine");
        System.out.println("Color of submarine: " + cl.getAnnotation(SubmarineAnnotation.class));
    }
}
