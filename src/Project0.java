import java.util.function.Function;

public class Project0 {
    public static void main(String[] args) {

        //1.1
        System.out.println("1.1\n");
        Matrix A = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println("Matrix A");
        System.out.println(A);
        System.out.println("A * A");
        System.out.println(LinearAlgebra.multiplyMatrices(A, A));
        System.out.println("A .* A");
        System.out.println(LinearAlgebra.multiplyValues(A, A));
        System.out.println("A^2");
        System.out.println(LinearAlgebra.matrixPow(A, 2));
        System.out.println("A / A");
        System.out.println(LinearAlgebra.divideMatrices(A, A));
        System.out.println("A ./ A");
        System.out.println(LinearAlgebra.divideValues(A, A));

        //1.3
        System.out.println("\n1.3\n");
        System.out.println("See Graphs");
        //Chart a
        Matrix xLin1 = LinearAlgebra.linSpace(0, 20, 0.1);
        Matrix xLin2 = LinearAlgebra.linSpace(0, 20, 0.5);
        Function<Double, Double> fnc = (t) -> Math.exp(-t / 4.0) * Math.sin(t);
        PyChart.plot(xLin1, fnc, "f(x)", "x", "f(x)", "f(x) = exp(-x/4)*sin(x)");

        //Chart b
        Function<Double, Double> fnc2 = (t) -> Math.exp(-t / 4.0);

        Function<Double, Double>[] fncs = new Function[]{fnc, fnc2};
        Matrix[] xs = {xLin1, xLin2};
        String[] symbols = {"-", "."};
        String[] fncNames = {"f(x)", "exp(-x/4)"};
        PyChart.plot(xs, fncs, symbols, fncNames, "x", "f(x)", "f(x) = exp(-x/4)*sin(x)");

        //Chart c
        Matrix xLin3 = LinearAlgebra.linSpace(0, 22, 0.1);
        Matrix[] xLin3Ar = {xLin3};
        Function<Double, Double> fnc3 = (t) -> Math.exp(-t) * Math.sin(t) * Math.sin(t);
        Function<Double, Double>[] fnc3Ar = new Function[]{fnc3};
        PyChart.plotSemilogy(xLin3Ar, fnc3Ar, new String[]{"."}, new String[]{"f(x)"}, "x", "T(x)", "f(x) = exp(-x)*sin(x)^2");

        //Chart d
        Matrix thetaLin = LinearAlgebra.linSpace(0, 2 * Math.PI, 0.01);
        Function<Double, Double> polarFnc = (t) -> Math.sin(6 * t);
        PyChart.plotPolar(thetaLin, polarFnc, "title");

        //1.9
        System.out.println("\n1.9\n");
        System.out.println("Hello World");

        //1.10
        System.out.println("\n1.10\n");
        System.out.println("(a) Largest Floating Point Number: " + Double.MAX_VALUE);
        System.out.println("(b) Largest Integer I: " + (Integer.MAX_VALUE - 1));
        System.out.println("(c) Smallest Positive Floating Point Number: " + Double.MIN_VALUE);
        System.out.println("(d) Smallest Positive Floating Point Number x: ~1e-15");
        System.out.println("(e) Max 2d Array Size N: ~2e4");
        System.out.println("(f) Max 1d Array Size: ~2e8");
        System.out.println("(g) Max Array Dimension: 12");

        //1.11
        System.out.println("\n1.11\n");
        double val;
        double stop;
        int k = 0;
        double start = System.nanoTime();
        for (k = 0; k < 999999999; k++) {
            val = 2.0 * 2.0;
        }
        stop = System.nanoTime();
        double mulFactor = 2600;
        double time = mulFactor * (stop - start) / (10e9);
        System.out.println("Multiplications in " + time + " second(s): " + (long) k * mulFactor);

        //1.15
        System.out.println("\n1.15\n");
        Matrix x = LinearAlgebra.linSpace(0, 1.0, 0.5);
        Matrix y = new Matrix(1.0, 0.9385, 0.7652);
        Function<Double, Double> interp = Interpolation.polynomial(x, y);

        //I couldn't find a table of values online so this function is the partial sum of the 0th order bessel function.
        Function<Double, Double> bessel = (t) -> {
            double result = 1.0;
            double t2 = t * t / 4.0;
            double factorial = 1.0;

            for (int m = 1; m < 1000; m++) {
                factorial *= m;
                result += Math.pow(-1, m) * Math.pow(t2, m) / (factorial * factorial);
            }
            return result;
        };

        double currPoint;
        double[] evalPoints = {0.3, 0.9, 1.1, 1.5, 2.0};
        for (int n = 0; n < evalPoints.length; n++) {
            currPoint = evalPoints[n];
            System.out.println("J(" + currPoint + ") = " + bessel.apply(currPoint) + " | I(" + currPoint + ") = " + interp.apply(currPoint) + " | Error = " + Error.relative(bessel.apply(currPoint), interp.apply(currPoint)));
        }







    }

}
