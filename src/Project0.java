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

        //1.2
        System.out.println("\n1.2\n");
        Matrix x = LinearAlgebra.linSpace(1, 10, 1);
        Matrix y = LinearAlgebra.valuesPow(x, 2);

//        PyChart.plotFunction(x, y, "fnc", "x", "y",  "title");

        //1.3
        System.out.println("\n1.3\n");
        System.out.println("See Graphs");
        //Chart I
        Matrix xAxis = LinearAlgebra.linSpace(0, 20, 0.1);
        Function<Double, Double> fnc = (t) -> Math.exp(-t / 4.0) * Math.sin(t);
//        PyChart.plotFunction(xAxis, fnc, "f(x)", "x", "y", "f(x) = exp(-x/4)*sin(x)");
//
//        //Chart II
//        Function<Double, Double> fnc2 = (t) -> Math.exp(-t / 4.0);
//
//        PyChart.plotTwoFunctions(xAxis, fnc, "f(x)", fnc2, "exp(-x/4)", "x", "y", "f(x) = exp(-x/4)*sin(x)");


        //1.9
        System.out.println("\n1.9\n");
        System.out.println("Hello World");

        //1.10
        System.out.println("\n1.10\n");

        //1.11
        System.out.println("\n1.11\n");

        //1.15
        System.out.println("\n1.15\n");
        x = LinearAlgebra.linSpace(0, 1.0, 0.5);
        y = new Matrix(1.0, 0.9385, 0.7652);
        xAxis = LinearAlgebra.linSpace(0.0, 1.0, 0.01);
        Function<Double, Double> interp = Interpolation.polynomial(x, y);
        Matrix interpVals = LinearAlgebra.applyFunction(xAxis, interp);
        PyChart.scatterWFnc(x, y, xAxis, interpVals, "x", "y", "Bessel Function");


    }

}
