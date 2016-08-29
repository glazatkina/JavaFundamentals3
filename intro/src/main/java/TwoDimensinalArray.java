/**
 * Created by Natalya on 30.08.2016.
 *
 *          example:
 *
 *          input:
 *          1 0 0 0 1 0 1 0 1 0 0 0 1 0 0 0 1 0 1 0 1 0 0 0 1
 *
 *          output:
 *          1 0 0 0 1
 *          0 1 0 1 0
 *          0 0 1 0 0
 *          0 1 0 1 0
 *          1 0 0 0 1
 */
public class TwoDimensinalArray {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 1;
        int i = 1;
        int [][] arr;

        if (args.length > 1) {
            n = Integer.parseInt(args[i]);
            while (n != 1) {
                count++;
                i++;
                n = Integer.parseInt(args[i]);
            }
            count++;

            arr = new int[count][count];

            for (int k = 0; k < count; ++k) {
                arr[0][k] = 0;
            }

            arr[0][0] = 1;
            arr[0][count - 1] = 1;
            int j = 0;
            i++;
            for (; i < count*count; ++i) {
                if (i % count == 0) {
                    j++;
                }
                arr[j][i % count] = Integer.parseInt(args[i]);
            }
        } else {
            System.out.print(n);
            return;
        }

        for (i = 0; i < count; ++i) {
            for (int j = 0; j < count; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
