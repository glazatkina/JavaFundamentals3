/**
 * Created by Natalia Glazkina on 10.09.2016.
 */
public class Paper extends Supplies {
    private int price;
    private int count;

    public Paper(int price, int count) {
        this.price = price;
        this.count = count;
    }

    @Override
    public String getInformation() {
        return "Paper:\n" + "Count sheets: " + count + "\tPrice: " + Integer.toString(price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
