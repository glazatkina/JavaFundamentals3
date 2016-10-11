/**
 * Created by Natalia Glazkina on 10.09.2016.
 */
@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate"})
public class Scissors extends Supplies {
    private int price;
    private boolean isLeftHanded;
    private String name;

    public Scissors(int price, boolean isLeftHanded, String name) {
        this.price = price;
        this.isLeftHanded = isLeftHanded;
        this.name = name;
    }

    @Override
    public String getInformation() {
        return "Scissors: " + name + "\n" + "Left handed: " + isLeftHanded + "\tPrice: " + Integer.toString(price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLeftHanded() {
        return isLeftHanded;
    }

    public String getName() {
        return name;
    }
}
