/**
 * Created by Natalia Glazkina on 06.09.2016.
 */
public class Pen {
    private String name;
    private int price;

    public Pen(String nName, int nPrice) {
        name = nName;
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
        if (null == name) {
            return (null == pen.name);
        } else {
             return name.equals(pen.name);
        }
    }

    @Override
    public int hashCode() {
        return (int) (13 * price + ((name == null) ? 0 : name.hashCode()));
    }

    @Override
    public String toString() {
        return "This is Pen \"" + name + "\". It's price is " + Integer.toString(price);
    }
}
