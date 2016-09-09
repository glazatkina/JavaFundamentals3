/**
 * Created by Natalia Glazkina on 06.09.2016.
 */
public class Pen extends Supplies{
    private String ink;
    private int price;

    public Pen(String nInk, int nPrice) {
        ink = nInk;
        price = nPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pen pen = (Pen) obj;

        if (price != pen.price) {
            return false;
        }
        if (null == ink) {
            return (null == pen.ink);
        } else {
             return ink.equals(pen.ink);
        }
    }

    @Override
    public int hashCode() {
        return 13 * price + ((ink == null) ? 0 : ink.hashCode());
    }

    @Override
    public String toString() { return "Pen:\n" + "Color: " + ink + "\tPrice: " + Integer.toString(price);    }

    @Override
    public String getInformation() {
        return toString();
    }
}
