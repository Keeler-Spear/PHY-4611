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
            orbit = Orbit.calculate(r0, v0, (int) (arcLen / h), h, method);
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
//        double au = 35;
//        Matrix hs = new Matrix (6, 1);
//        Matrix vs = new Matrix (6, 1);
//        for (int i = 1; i <= 6; i++) {
//            hs.setValue(i, 1, find1PELoss(au, 0.5 + 0.1 * (i - 1), 2));
//            vs.setValue(i, 1, 0.5 + 0.1 * (i - 1));
//        }
//        System.out.println(LinearAlgebra.transpose(hs));
//        System.out.println(LinearAlgebra.transpose(vs));
//        Orbit.plotStepVsV0(hs, vs);p

        Matrix[] orbit = Orbit.calculate(1, Math.PI, 200, 0.005, 3);
        Orbit.plotTrajectory(orbit[0], orbit[1]);

    }

}
