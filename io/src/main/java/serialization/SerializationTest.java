package serialization;

import java.io.*;

/**
 * Created by glazkina on 20.10.2016.
 *
 * @author: Natalia Glazkina
 */
public class SerializationTest {
    public static void main(String[] args) {
        String fileName = "io\\src\\main\\resources\\Movies";

        //this part for initialisation new list of movies
        write(init(), fileName);

        //this part for changing movie and rewrite new info
//        Movie[] catalog = read(fileName, 3);
//        for (Movie mov: catalog) {
//            System.out.println(mov);
//        }
//        catalog[0].setGenre(Movie.Genre.COMEDY);
//        write(catalog, fileName);
    }


    /**
     * Created small list from famous actors amd movies and add it to array
     *
     * @return initialised Movie's array
     */
    private static Movie[] init() {
        Actor john = new Actor(Actor.Gender.MALE, "John", "Travolta");
        Actor uma = new Actor(Actor.Gender.FEMALE, "Uma", "Thurman");
        Actor luci = new Actor(Actor.Gender.FEMALE, "Lucy", "Liu");
        Actor bruce = new Actor(Actor.Gender.MALE, "Bruce", "Willis");
        Actor morgan = new Actor(Actor.Gender.MALE, "Morgan", "Freeman");

        Movie pulpFict = new Movie(new Actor[] {john, uma, bruce}, "Pulp Fiction", Movie.Genre.THRILLER);
        Movie killBill  = new Movie(new Actor[] {uma, luci}, "Kill Bill", Movie.Genre.THRILLER);
        Movie luckyNumber = new Movie(new Actor[] {bruce, morgan, luci}, "Lucky Number Slevin", Movie.Genre.THRILLER);

        return new Movie[] {pulpFict, killBill, luckyNumber};
    }

    /**
     * Make objects from array serialised in file.
     *
     * @param movies
     *          array of Movie's objects
     * @param fileName
     *          name of file to serialization
     */
    private static void write(Movie[] movies, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream os = new ObjectOutputStream(fileOutputStream)) {
            for (Movie movie: movies) {
                os.writeObject(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read objects from file.
     *
     * @param fileName
     *          name of file where saved serialised files
     * @param count
     *          maximal amount of movies; if in file will be smaller movie's amount, last objects in array will be null
     * @return
     *          array of deserialised Movie's objects
     */
    @SuppressWarnings("unused")
    private static Movie[] read(String fileName, int count) {
        Movie[] ans = new Movie[count];
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
            //use try-catch construction, not available() method,
            // because it's show haw many bytes it can read right now WITHOUT BLOCKING (in my case it always was 0)

            //noinspection EmptyCatchBlock
            try {
                for (int i = 0; i < count; i++) {
                    Movie movie = (Movie) ois.readObject();
                    ans[i] = movie;
                }
            } catch (EOFException e) { }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ans;
    }

}
