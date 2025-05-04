import java.util.function.Function;

public class Project1 {

    public static void main(String[] args) {

        //1.b
        System.out.println("\n1.b\n");
        Function<Double, Double> semiCircle = t -> Math.sqrt(1 - t * t);
        NFunction<Double> circle = t -> Math.sqrt(1 - t[0] * t[0]);

//        double area = 2.0 * Calculus.mcIntegrate(semiCircle, -1, 1, 0, 1, 5000000);
//        System.out.println("MC 1d Approx: " + area);
        //1.c
        System.out.println("\n1.c\n");

        //2.a
        System.out.println("\n2.a\n");
        double exact = 500 * Math.PI / (3 * Math.sqrt(6));
        System.out.println("Exact: " + exact);
        NFunction<Double> ellipsoid = t -> 2 * t[0] * t[0] + 3 * t[1] * t[1] + t[2] * t[2] - 25;
        double mass = Calculus.mcIntegrateGeometry(ellipsoid, new double[]{-3.536, -2.887, -5.0}, new double[]{3.536, 2.887, 5.0}, 50000);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);

        //2.b
        System.out.println("\n2.b\n");
        exact = 500 * Math.PI / (3 * Math.sqrt(6));
        mass = Calculus.mcIntegrateGeometry(ellipsoid, new double[]{-1.0, -2.887, -2.0}, new double[]{3.536, 2.887, 2.0}, 50000);
        System.out.println("Exact: " + exact);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);

        //2.c
        System.out.println("\n2.c\n");
        exact = 1250 * Math.PI / (3 * Math.sqrt(6));
        NFunction<Double> massFnc = t -> t[0] * t[0];
        System.out.println("Exact: " + exact);
        mass = Calculus.mcIntegrateMass(ellipsoid, massFnc, new double[]{-1.0, -2.887, -2.0}, new double[]{3.536, 2.887, 2.0}, 50000);
        System.out.println("MC Approx: " + mass);
        System.out.println("Relative Error: " + Error.relative(exact, mass) * 100);



    }

}
