import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Natalia Glazkina on 10.09.2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class InheritanceTest {

    @Test
    public void creatingNewEmployeeKit() throws Exception {
        Supplies[] officeSupplies = new Supplies[4];
        officeSupplies[0] = new Pen("black", 10, "Parker");
        officeSupplies[1] = new Pen("red", 15, "BIC");
        officeSupplies[2] = new Paper(200, 500, "Svetocopy");
        officeSupplies[3] = new Scissors(70, true, "Centrum");

        for (Supplies item: officeSupplies) {
            System.out.println(item.getInformation());
        }
    }

    @Test
    public void testingPaperClass() throws Exception {
        Paper papers = new Paper(250, 500, "Xerox");
        assertThat(papers.getPrice(), is(250));
        assertThat(papers.getName(), is("Xerox"));
        assertThat(papers.getCount(), is(500));

        //let's print 200 pages of book
        papers.setCount(300);
        //price doubled
        papers.setPrice(500);
        assertThat(papers.getPrice(), is(500));
        assertThat(papers.getCount(), is(300));
    }

    @Test
    public void testingScissorClass() throws Exception {
        Scissors sc = new Scissors(150, true, "Erich Crause");

        assertThat(sc.getPrice(), is(150));
        assertThat(sc.getName(), is("Erich Crause"));
        assertThat(sc.isLeftHanded(), is(true));

        //Bill Gates touched this scissors
        sc.setPrice(50000);
        assertThat(sc.getPrice(), is(50000));
    }
}
