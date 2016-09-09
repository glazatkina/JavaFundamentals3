import org.junit.Test;

/**
 * Created by Natalia Glazkina on 10.09.2016.
 */
public class InheritanceTest {
    private Supplies[] officeSupplies;

    @Test
    public void creatingNewEmployeeKit() throws Exception {
        officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10);
        officeSupplies[1] = new Pen("red", 15);
        officeSupplies[2] = new Paper(200, 500);
        officeSupplies[3] = new Scissors(70, true);

        for (Supplies item: officeSupplies) {
            System.out.println(item.getInformation());
        }
    }
}
