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
        Matrix xLin2 = LinearAlgebra.linSpace(0, 20, 1);
        Function<Double, Double> fnc = (t) -> Math.exp(-t / 4.0) * Math.sin(t);
//        PyChart.plot(xAxis1, fnc, "f(x)", "x", "y", "f(x) = exp(-x/4)*sin(x)");

        //Chart b
        Function<Double, Double> fnc2 = (t) -> Math.exp(-t / 4.0);

        Function<Double, Double>[] fncs = new Function[]{fnc, fnc2};
        Matrix[] xs = {xLin1, xLin2};
        String[] symbols = {"-", "+"};
        String[] fncNames = {"f(x)", "exp(-x/4)"};
//        PyChart.plot(xs, fncs, symbols, fncNames, "x", "y", "f(x) = exp(-x/4)*sin(x)");

        //Chart c
        Matrix xLin3 = LinearAlgebra.linSpace(0, 22, 0.1);
        Matrix[] xLin3Ar = {xLin3};
        Function<Double, Double> fnc3 = (t) -> Math.exp(-t) * Math.sin(t) * Math.sin(t);
        Function<Double, Double>[] fnc3Ar = new Function[]{fnc3};
//        PyChart.plotSemilogy(xLin3Ar, fnc3Ar, new String[]{"."}, new String[]{"f(x)"}, "x", "T(x)", "f(x) = exp(-x)*sin(x)^2");



        //Chart d
        Matrix thetaLin = LinearAlgebra.linSpace(0, 2 * Math.PI, 0.01);
        Function<Double, Double> polarFnc = (t) -> Math.sin(6 * t + Math.PI / 3);
//        PyChart.plot(thetaLin, polarFnc, "sin(x)", "x", "y", "Title");
        PyChart.plotPolar(thetaLin, polarFnc, "title");

        //1.9
        System.out.println("\n1.9\n");
        System.out.println("Hello World");

        //1.10
        System.out.println("\n1.10\n");
        //1.11
        System.out.println("\n1.11\n");
        System.out.println("(a) Largest Floating Point Number (long Type in Java): 9,223,372,036,854,775,807");
        System.out.println("(b) Largest Integer I: 2147483647");
        System.out.println("(c) Smallest Positive Floating Point Number: 2^-63");
        System.out.println("(d) Smallest Positive Floating Point Number x: ToDo");
        System.out.println("(e) Max 2d Array Size N: ToDo");
        System.out.println("(f) Max 1d Array Size: ToDo");
        System.out.println("(g) Max Array Dimension: ToDo");


        //1.15
        System.out.println("\n1.15\n");
        Matrix x = LinearAlgebra.linSpace(0, 1.0, 0.5);
        Matrix y = new Matrix(1.0, 0.9385, 0.7652);
        xLin1 = LinearAlgebra.linSpace(0.0, 1.0, 0.01);
        Function<Double, Double> interp = Interpolation.polynomial(x, y);
        Matrix interpVals = LinearAlgebra.applyFunction(xLin1, interp);
//        PyChart.scatterWFnc(x, y, xAxis, interpVals, "x", "y", "Bessel Function");


    }

}
