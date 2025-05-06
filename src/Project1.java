import java.util.function.Function;

public class Project1 {

    final static int SEED_X = 0;
    final static int SEED_Y = 1;
    //Used in all the methods

    public static void main(String[] args) {

        //1.b
        System.out.println("\n1.b\n");
        Function<Double, Double> semiCircle = t -> Math.sqrt(1 - t * t);
        int n;
        double[] areas = new double[1000];
        double[] ns = new double[1000];

        for (int i = 1; i <= areas.length; i++) {
            n = i * 50;
            ns[i - 1] = n;
            areas[i - 1] = 2.0 * Calculus.mcIntegrate(semiCircle, -1, 1, 0, 1, n);
        }
        PyChart.plot(new Matrix(ns), new Matrix(areas), "Approximation", "n", "Approximation", "Approximation of Pi via MCI");
        n = 500000;
        System.out.println("n = " + n + ": " + 2.0 * Calculus.mcIntegrate(semiCircle, -1, 1, 0, 1, n));
        n = 50000000;
        System.out.println("n = " + n + ": " + 2.0 * Calculus.mcIntegrate(semiCircle, -1, 1, 0, 1, n));
        //1.c
        System.out.println("\n1.c\n");

        areas = new double[1000];
        ns = new double[1000];
        for (int i = 1; i <= areas.length; i++) {
            n = i * 50;
            ns[i - 1] = n;
            areas[i - 1] = 2.0 * Calculus.mcIntegrateMT(semiCircle, -1, 1, 0, 1, n);
        }
        PyChart.plot(new Matrix(ns), new Matrix(areas), "Approximation", "n", "Approximation", "Approximation of Pi via MCI");
        n = 80000;
        System.out.println("n = " + n + ": " + 2.0 * Calculus.mcIntegrateMT(semiCircle, -1, 1, 0, 1, n));
        n = 500000;
        System.out.println("n = " + n + ": " + 2.0 * Calculus.mcIntegrateMT(semiCircle, -1, 1, 0, 1, n));

//        //2.a
        System.out.println("\n2.a\n");
        double mass;
        double exact = 500 * Math.PI / (3 * Math.sqrt(6));
        NFunction<Double> ellipsoid = t -> 2 * t[0] * t[0] + 3 * t[1] * t[1] + t[2] * t[2] - 25;

        System.out.println("Exact: " + exact);
        mass = Calculus.mcIntegrateGeometry(ellipsoid, new double[]{-3.536, -2.887, -5.0}, new double[]{3.536, 2.887, 5.0}, 50000);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);

        //2.b
        System.out.println("\n2.b\n");
        exact = 82.8489;
        mass = Calculus.mcIntegrateGeometry(ellipsoid, new double[]{-1.0, -2.887, -2.0}, new double[]{3.536, 2.887, 2.0}, 50000);
        System.out.println("Exact: " + exact);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);

        //2.c
        System.out.println("\n2.c\n");
        exact = 187.343;
        NFunction<Double> massFnc = t -> t[0] * t[0];
        System.out.println("Exact: " + exact);
        mass = Calculus.mcIntegrateMass(ellipsoid, massFnc, new double[]{-1.0, -2.887, -2.0}, new double[]{3.536, 2.887, 2.0}, 50000);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);



    }

}
