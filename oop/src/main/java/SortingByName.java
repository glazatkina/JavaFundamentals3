import java.util.Comparator;

/**
 * Created by glazkina on 26.09.2016.
 */
@SuppressWarnings({"WeakerAccess", "DefaultFileTemplate"})
public class SortingByName implements Comparator<Supplies> {
    @Override
    public int compare(Supplies o1, Supplies o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
