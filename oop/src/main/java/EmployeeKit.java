import java.util.ArrayList;

/**
 * Created by Natalia Glazkina on 19.09.2016.
 */
public class EmployeeKit {
    private ArrayList<Supplies> kit;
    private int number;

    public EmployeeKit(int num, Supplies ... sup) {
        number = num;
        kit = new ArrayList<>();
        for (Supplies item : sup) {
            kit.add(item);
        }
    }

    public int getPrice() {
        int price = 0;
        for (Supplies item : kit) {
            price += item.getPrice();
        }
        return price;
    }

    public String toString() {
        String ans = "Employee Kit #" + number + "\n##########################\n";
        for (Supplies item: kit) {
            ans += item.getInformation();
            ans += "\n__________________________\n";
        }
        ans += "TOTAL PRICE: " + this.getPrice();
        return ans;
    }

    public void addItem(Supplies item) {
        kit.add(item);
    }

    public boolean deleteItem(Supplies item) {
        return kit.remove(item);
    }
}
