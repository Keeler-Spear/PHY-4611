public class Project3 {

    final static double arcLen = 90; //h * numStep must equal this
    final static double minH = 0.0001;
    final static double maxH = 10;
    final static double TOL = 0.05;

    private static double find1PELoss(double r0, double v0, int method) {
        double h = minH;
        Matrix[] orbit;
        Matrix totE;

        while (h <= maxH) {
            orbit = Orbit.calculate(r0, v0, (int) (arcLen / h), h, method, false, false);
            totE = LinearAlgebra.addMatrices(orbit[3], orbit[4], 1);
            double error = Error.relative(totE.getValue(1,1), totE.getValue(totE.getRows(),1));

            if (100 * error <= (1 + TOL) && 100 * error >= (1 - TOL)) {
                return h;
            }
            if (100 * error > (1 + 2 * TOL)) {
                System.out.println("Failed to find an h");
                return 999;
            }

            h += minH;
        }

        System.out.println("Failed to find an h");
        return 9999;
    }

    public static void main(String[] args) {

        //3.6
        System.out.println("\nProblem 3.6\n");
        double hcAU = 35; //Haley's comet initial position
        double hcv0 = 0.19; //Haley's comet initial velocity

        Matrix hs;
        Matrix vs;
        Matrix interp;
        double idealStepSize;
        Matrix[] hc;
        hs = new Matrix (6, 1);
        vs = new Matrix (6, 1);
        for (int i = 1; i <= 6; i++) {
            hs.setValue(i, 1, find1PELoss(hcAU, 0.5 + 0.1 * (i - 1), 2));
            vs.setValue(i, 1, 0.5 + 0.1 * (i - 1));
        }
        interp = Interpolation.polynomial(vs, hs, new Matrix(new double[]{0.19}));
        idealStepSize = find1PELoss(hcAU, 0.19, 2);

        System.out.println("Recommended Step Size for tracking Haley's Comet based on Interpolation: " + interp.getValue(1, 1));
        System.out.println("Recommended Step Size for tracking Haley's Comet: " + idealStepSize);
        Orbit.plotStepVsV0(hs, vs);
//
//        //Plotting HC with the ideal step size
        hc = Orbit.calculate(hcAU, hcv0, (int) (arcLen / idealStepSize), idealStepSize, 2, false, false);
        Orbit.plotTrajectory(hc[0], hc[1]);

        //3.11
        System.out.println("\nProblem 3.11\n");
        //My computer cannot handle running the following code within a reasonable time frame.
//        hs = new Matrix (6, 1);
//        vs = new Matrix (6, 1);
//        for (int i = 1; i <= 6; i++) {
//            hs.setValue(i, 1, find1PELoss(hcAU, 0.5 + 0.1 * (i - 1), 3));
//            vs.setValue(i, 1, 0.5 + 0.1 * (i - 1));
//        }
//        interp = Interpolation.polynomial(vs, hs, new Matrix(new double[]{0.19}));
        idealStepSize = find1PELoss(hcAU, 0.19, 3);

//        System.out.println("Recommended Step Size for tracking Haley's Comet based on Interpolation: " + interp.getValue(1, 1));
        System.out.println("Recommended Step Size for tracking Haley's Comet: " + idealStepSize);
//        Orbit.plotStepVsV0(hs, vs);

        //Plotting HC with the ideal step size
        hc = Orbit.calculate(hcAU, hcv0, (int) (arcLen / idealStepSize), idealStepSize, 2, false, false);
        Orbit.plotTrajectory(hc[0], hc[1]);

        //alpha = -0.5 is used here.
        System.out.println("\nProblem 3.14\n");
        //3.14
        System.out.println("Orbit of Procession for Haley's Comet when alpha = -0.5: " + Orbit.calculateOrbitOfProcession(hcAU, hcv0));
        hc = Orbit.calculate(hcAU, hcv0, 10000, 0.1, 4, true, false);
        Orbit.plotTrajectory(hc[0], hc[1]);

        //3.15
        System.out.println("\nProblem 3.15\n");
        hc = Orbit.calculate(hcAU, hcv0, 10000, 0.1, 4, false, true);
        Orbit.plotTrajectory(hc[0], hc[1]);
        Orbit.plotEnergy(hc[2], hc[3], hc[4]);




    }

}
