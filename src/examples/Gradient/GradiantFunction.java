package examples.Gradient;

import java.util.ArrayList;
import java.util.List;

public class GradiantFunction {

        ArrayList<Integer> x = new ArrayList<Integer>(List.of( 23, 26, 30, 34, 43, 48, 52, 57, 58));
        ArrayList<Integer> y = new ArrayList<Integer>(List.of(651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518));
        double beta0 = 0;
        double beta1 = 0;
        double Result = 0;//Resultado de la regresion lineal
        double xValue  = 80;//El valor a evaluar en la regresion lineal
        double n = Double.valueOf(x.size());

        public void LinearRegression() { //Predict
            Result = beta0 + (beta1* xValue);
        }

        public void GradiantFunction() {
            beta0 = 0.0;
            beta1 = 0.0;
            double alpha = 0.0005;
            while (calculateValues() > 0.0001){
                //derivadas    //Inicia RecalculateBetas
                double tempB0 = 0.0;
                double tempB1 = 0.0;
                for(int i =0; i < n; i++) {
                    tempB0 +=  (y.get(i) - (beta0 + beta1 * x.get(i)));
                    tempB1 += (x.get(i) * (y.get(i) - (beta0 + beta1 * x.get(i))));
                }

                tempB0 *= (-2/n);
                tempB1 *= (-2/n);

                beta0 -= (alpha * tempB0);
                beta1 -= (alpha * tempB1);
            } //Termina RecalculateBetas
        }
        
         //se calculan los datos ya existentes
        public double calculateValues() { //CalculateError
            double temp= 0.0;
            for(int i = 0; i < n; i++){
                temp += (y.get(i) - (beta0 + (beta1*x.get(i))));
            }
            return (temp*temp) * (1.0/n);
        }


        public double getResult() {
            return Result;
        }

        public double getxValue() {
            return xValue;
        }

        public double getBeta0() {
            return beta0;
        }

        public double getBeta1() {
            return beta1;
        }

    }
