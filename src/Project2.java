//To run this code you need to have my Chart, Mathematics, and Physics libraries installed.


public class Project2 {

    static Item baseball = new Item(0.145, 4.3e-3, 0.35);
    static Matrix noWind = LinearAlgebra.zeroMatrix(2, 1);
    static double trueRange = 50 * 50 / 9.80665;
    static double trueTime = 2 * 50 * Math.sin(Math.PI / 4) / 9.80665;


    private static double ball (double height, double speed, double angle, double timeStep, int type, boolean air, Matrix wind, boolean printComp, boolean printStats) {
        Matrix airRes = Simulation.projectileMotion(baseball, height, speed, angle, timeStep,type, air, wind, true);
        return Simulation.flightStats(airRes, printComp, printStats);
    }

    private static void ballWithPlot (double height, double speed, double angle, double timeStep, int type, Matrix wind, boolean constantDrag, boolean printStats) {
        Matrix theory = Simulation.projectileMotion(baseball, height, speed, angle, timeStep, type,false, noWind, true);
        Matrix airRes = Simulation.projectileMotion(baseball, height, speed, angle, timeStep,type, true, wind, constantDrag);
        Simulation.flightStats(airRes, false, printStats);
        Simulation.displayMotion(theory, airRes);
    }

    public static void main(String[] args) {
        //2.3
        System.out.println("Problem 2.3\n");
        double h;
        for (int i = 1; i <= 10; i++) {
            h = i * 0.1;
            System.out.println("Step Size = " + h);
            ball(0, 50, 45, h, 1,false, noWind, true, false);
            System.out.println();
        }

        //2.4
        System.out.println("Problem 2.4\n");
        double approx;
        System.out.println("Euler's Method with h = 0.075:");
        approx = ball(0, 50, 45, 0.075, 1, false, noWind, false, true);
        System.out.println("Relative Error: " + String.format("%.3f", (100 *Error.relative(trueRange, approx))));
        System.out.println("\nEuler-Cromer Method with h = 0.07:");
        approx = ball(0, 50, 45, 0.07, 2, false, noWind, false, true);
        System.out.println("Relative Error: " + String.format("%.3f", (100 *Error.relative(trueRange, approx))));
        System.out.println("\nMidpoint Method with h = 1.476:");
        approx = ball(0, 50, 45, 1.476, 3, false, noWind, false, true);
        System.out.println("Relative Error: " + String.format("%.3f", (100 *Error.relative(trueRange, approx))));

        System.out.println("\nProblem 2.5\n");
        Simulation.plotRangeVSAngle(baseball, 1, 50, 0.1, 3, true, noWind, true, 20, 70);

        //2.9
        System.out.println("\nProblem 2.9\n");
        System.out.println("See Graph");
        Simulation.plotRangeVSWind(baseball, 1, 49.17, 35, 0.1, 3, true, -40, 40);
        Simulation.plotRangeVSWind(baseball, 1, 49.17, 35, 0.1, 3, true, -150, 150);

        //2.10
        System.out.println("\nProblem 2.10\n");
        System.out.print("With a changing coefficient of drag, this is the ");
        Simulation.plotRangeVSAngle(baseball, 1, 50, 0.1, 3, true, noWind, false, 30, 60);
        Simulation.plotTwoRangeVSAngle(baseball, 1, 50, 0.1, 3, true, noWind, 30, 60);
    }

}
