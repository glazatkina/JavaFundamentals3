import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Natalia Glazkina on 19.09.2016.
 */
public class EmployeeKitTest {
    private EmployeeKit testKit;

    @Test
    public void calculatingCost() throws Exception {
        testKit = new EmployeeKit(1);
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10);
        officeSupplies[1] = new Pen("red", 15);
        officeSupplies[2] = new Paper(200, 500);
        officeSupplies[3] = new Scissors(70, true);
        for (Supplies item: officeSupplies) {
            testKit.addItem(item);
        }

        assertThat(testKit.getPrice(), is(295));
    }

    @Test
    public void kitToString() throws Exception {
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10);
        officeSupplies[1] = new Pen("red", 15);
        officeSupplies[2] = new Paper(200, 500);
        officeSupplies[3] = new Scissors(70, true);
        testKit = new EmployeeKit(0,officeSupplies);
        System.out.println(testKit.toString());
    }
}
