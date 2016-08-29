/**
 * Created by Natalya on 30.08.2016.
 *
 * Variables:
 * n - number of pairs
 * a[0 .. 2*n - 1] - integer variables in array
 *
 *          example:
 *
 *          input:
 *          5 1 2 3 4 5 6 7 8 9 10
 *
 *          output:
 *          11
 */
public class OneDimensionArray {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] a = new int[2*n];

        for (int i = 0; i < 2*n; ++i) {
            a[i] = Integer.parseInt(args[i + 1]);
        }
        int max = a[0] + a[2*n - 1];
        for (int i = 0; i < n; ++i) {
            int b = a[i] + a[2*n - (i + 1)];
            if (b > max)
                max = b;
        }

        System.out.print(max);
    }
}
