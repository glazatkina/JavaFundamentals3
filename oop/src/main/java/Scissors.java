/**
 * Created by Natalia Glazkina on 10.09.2016.
 */
public class Scissors extends Supplies {
    private int price;
    private boolean isLeftHanded;

    public Scissors(int price, boolean isLeftHanded) {
        this.price = price;
        this.isLeftHanded = isLeftHanded;
    }

    @Override
    public String getInformation() {
        return "Scissors:\n" + "Left handed: " + isLeftHanded + "\tPrice: " + Integer.toString(price);
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
}
