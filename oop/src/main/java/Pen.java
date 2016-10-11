/**
 * Created by Natalia Glazkina on 06.09.2016.
 */
@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate"})
public class Pen extends Supplies{
    private String ink;
    private int price;
    private String name;

    public Pen(String nInk, int nPrice, String name) {
        ink = nInk;
        price = nPrice;
        this.name = name;
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

        return price == pen.price && isEquals(name, pen.name) && isEquals(ink, pen.ink);

    }

    @Override
    public int hashCode() {
        return 13 * price + ((ink == null) ? 0 : ink.hashCode()) + name.hashCode();
    }

    @Override
    public String toString() { return "Pen: " + name +"\n" + "Color: " + ink + "\tPrice: " + Integer.toString(price);    }

    @Override
    public String getInformation() {
        return toString();
    }

    @Override
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    private static boolean isEquals(String str1, String str2) {
        if (str1 == null)
            return str2 == null;
        return str2 != null && str1.equals(str2);
    }
}
