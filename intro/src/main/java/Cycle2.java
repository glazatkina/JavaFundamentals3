/**
 * Created by Natalya on 30.08.2016.
 *
 * Variables:
 * from - min value in interval
 * to - max value in interval
 * step - increment step
 *
 *          example:
 *
 *          input:
 *          2 3 0.5
 *
 *          output:
 *          x	y
 *          2.0	-1.8421787176504223
 *          2.5	-6.380515006246586
 */
public class Cycle2 {
    public static void main(String[] args) {
        double from = Double.parseDouble(args[0]);
        double to = Double.parseDouble(args[1]);
        double step = Double.parseDouble(args[2]);

        System.out.println("x\ty");

        while (from < to) {
            System.out.print(from + "\t");
            System.out.println(foo(from));

            from += step;
        }
    }

    static double foo(double x) {
        return Math.tan(x * 2.0) - 3.0;
    }
}
