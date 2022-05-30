package examples.MLR;

import examples.MLR.Matrix;

public class MLRFormula extends Matrix {
    double beta0;
    double beta1;
    double beta2;

    public MLRFormula() {
        beta0 = 0;
        beta1 = 0;
        beta2 = 0;
    }

    public void calculateBetas(double[][] x, double[][] y) {
        double[][] betas = multiply(inverse(multiply(matrizTranspuesta(x), x)), multiply(matrizTranspuesta(x), y));
        beta0 = betas[0][0];
        beta1 = betas[1][0];
       // beta2 = betas[2][0];
    }

    public void display() {
        System.out.println(beta0 + " + " + beta1 + " * X1 + " + beta2 + " * X2");
    }

    public void predict(double X1, double X2) {
        double respuesta = 0;
        respuesta = beta0 + beta1 * X1 + beta2 * X2;
        System.out.println(respuesta);
    }

    public void predict(double X1) {
        double respuesta = 0;
        respuesta = beta0 + beta1 * X1;
        System.out.println(respuesta);
    }

}