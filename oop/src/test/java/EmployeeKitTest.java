import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Natalia Glazkina on 19.09.2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class EmployeeKitTest {
    private EmployeeKit testKit;

    @Test
    public void calculatingCost() throws Exception {
        testKit = new EmployeeKit(1);
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10, "Parker");
        officeSupplies[1] = new Pen("red", 15, "BIC");
        officeSupplies[2] = new Paper(200, 500, "Svetocopy");
        officeSupplies[3] = new Scissors(70, true, "Centrum");

        for (Supplies item: officeSupplies) {
            testKit.addItem(item);
        }

        assertThat(testKit.getPrice(), is(295));
    }

    @Test
    public void kitToString() throws Exception {
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10, "Parker");
        officeSupplies[1] = new Pen("red", 15, "BIC");
        officeSupplies[2] = new Paper(200, 500, "Svetocopy");
        officeSupplies[3] = new Scissors(70, true, "Centrum");
        testKit = new EmployeeKit(4, officeSupplies);

        System.out.println(testKit.toString());
    }

    @Test
    public void deleteItemFromKit() throws Exception {
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10, "Parker");
        officeSupplies[1] = new Pen("red", 15, "BIC");
        officeSupplies[2] = new Paper(200, 500, "Svetocopy");
        officeSupplies[3] = new Scissors(70, true, "Centrum");
        testKit = new EmployeeKit(4, officeSupplies);

        //try to delete one item twice
        assertThat(testKit.deleteItem(officeSupplies[0]), is(true));
        assertThat(testKit.deleteItem(officeSupplies[0]), is(false));
        //method equals() was overrided: new object will be equal to old, because all fields equals
        assertThat(testKit.deleteItem(new Pen("red", 15, "BIC")), is(true));
        //method equals() was not overrided: new object not equal, but all fields equals
        assertThat(testKit.deleteItem(new Paper(200, 500, "Svetocopy")), is(false));
    }
}
