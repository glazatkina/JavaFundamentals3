/**
 * Created by Natalya on 29.08.2016.
 *
 * Variables:
 * n - how many elements in array (integer), next n double variables - a[i] - elements of array
 *
 *          examples:
 *          input: 5 1.7 0.11111111 15 16 17 output: 1.7 0.11111111
 *          input: 3 0.25 0.1 17 output: 0.25
 *
 */
public class Cycle {
    public static void main(String[] args) {
        //count of array elements
        int n = Integer.parseInt(args[0]);


        for (int i = 0; i < n; ++i) {
            double a = Double.parseDouble(args[i + 1]);
            double b = 1 / ((i + 1 + 1.0)*(i + 1 + 1.0));

            System.out.print(String.valueOf(a) + " ");
            if (Math.abs(a - b) < 1e-5) {
                break;
            }
        }
    }
}
