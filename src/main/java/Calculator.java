import java.util.Arrays;

public class Calculator {
    private final static double eps = 0.00001;

    public double[] solve(double a, double b, double c) {
        if (Double.isInfinite(a) || Double.isInfinite(b) || Double.isInfinite(c)) {
            return new double[]{};
        }
        if (Math.abs(a) < eps) {
            throw new RuntimeException("No decision");
        }
        double d = Math.pow(b, 2) - 4 * a * c;
        if (Double.isInfinite(d)) {
            return new double[]{};
        }
        if (d < 0) {
            return new double[]{};
        }
        if (d == 0) {
            return new double[]{-b / (2 * a)};
        }

        double[] rez = new double[2];

        rez[0] = (-b + Math.sqrt(d)) / (2 * a);
        rez[1] = (-b - Math.sqrt(d)) / (2 * a);
        Arrays.sort(rez);

        return rez;
    }

}
