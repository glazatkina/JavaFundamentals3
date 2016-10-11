import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by glazkina on 26.09.2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class ComparingTest {
    private Comparator<Supplies> comp;

    @Test
    public void comparingByName() throws Exception {
        comp = new SortingByName();

        sorting(comp, "SORTING BY NAME");
    }

    @Test
    public void comparingByPrice() throws Exception {
        comp = new SortingByPrice();

        sorting(comp, "SORTING BY PRICE");
    }

    @Test
    public void comparingByPriceThenByName() throws Exception {
        comp = new SortingByPrice().thenComparing(new SortingByName());
        sorting(comp, "SORTING BY PRICE, THEN BY NAME");
    }

    private void sorting(Comparator<Supplies> comp, String sortingName) {
        System.out.println(sortingName);
        System.out.println("______________________");

        Supplies[] officeSupplies = new Supplies[6];
        officeSupplies[0] = new Pen("black", 10, "Parker");
        officeSupplies[2] = new Pen("red", 1, "BIC");

        officeSupplies[1] = new Pen("blue", 1, "Parker");
        officeSupplies[3] = new Pen("blue", 15, "BIC");

        officeSupplies[4] = new Paper(200, 500, "Svetocopy");
        officeSupplies[5] = new Scissors(70, true, "Centrum");

        System.out.println("BEFORE SORTING:");
        for (Supplies sup : officeSupplies) {
            System.out.println(sup.getInformation());
        }
        System.out.println("\n##################\n");
        System.out.println("AFTER SORTING:");
        Arrays.sort(officeSupplies, comp);
        for (Supplies sup : officeSupplies) {
            System.out.println(sup.getInformation());
        }
    }
}
