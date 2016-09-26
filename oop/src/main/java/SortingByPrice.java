import java.util.Comparator;

/**
 * Created by glazkina on 26.09.2016.
 */
public class SortingByPrice implements Comparator<Supplies> {
    @Override
    public int compare(Supplies o1, Supplies o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
