package examples.KNN;

import java.util.*;

public class KnnFormula {
    int pos = 0;
    int[] summators = { 0, 0, 0 };

    double calculateDistance(double a, double b, double x, double y) {
        double distance = Math.sqrt((Math.pow((x - a), 2) + Math.pow((y - b), 2)));
        return distance;
    }

    public void Master() {
        dataSet dataSet = new dataSet();
        double[][] arrayX = dataSet.getX();
        double[][] arrayY = dataSet.getY();
        String[][] arrayZ = dataSet.getZ();

        double distances[] = new double[arrayX.length];
        String categories[] = new String[distances.length];

        for (int i = 0; i < arrayX.length; i++) {
            distances[i] = calculateDistance(arrayX[i][0], arrayY[i][0], 5.3, 3.7);
            categories[i] = arrayZ[i][0];
        }

        for (int x = 0; x < distances.length; x++) {
            for (int y = 0; y < distances.length - 1; y++) {
                double elementoActual = distances[y],
                        elementoSiguiente = distances[y + 1];

                String elementoActualS = categories[y],
                        elementoSiguienteS = categories[y + 1];

                if (elementoActual > elementoSiguiente) {
                    // Intercambiar
                    distances[y] = elementoSiguiente;
                    distances[y + 1] = elementoActual;
                    categories[y] = elementoSiguienteS;
                    categories[y + 1] = elementoActualS;
                }
            }
        }

        int K = 1;
        String resultado = nearestNeighbor(categories, K);

        while (resultado == "equal") {
            K++;
            resultado = nearestNeighbor(categories, K);
        }

        System.out.println("\nEl resultado es: " + resultado);
    }

    public String nearestNeighbor(String[] categories, int K) {
        int k = K;
        String higher;
        for (int i = 0; i < k; i++) {
            switch (categories[i]) {
                case "Setosa":
                    summators[0]++;
                    break;

                case "Virginica":
                    summators[1]++;
                    break;

                case "Verscicolor":
                    summators[2]++;
                    break;
            }
        }
        if (summators[0] == summators[1] | summators[0] == summators[2] | summators[1] == summators[2]) {

            summators[0] = 0;
            summators[1] = 0;
            summators[2] = 0;
            return "equal";
        }
        for (int x = 1; x < summators.length; x++) {
            if (summators[x] > summators[0]) {
                summators[0] = summators[x];
                pos = x;
            }
        }
        switch (pos) {
            case 0:
                higher = "Setosa";
                break;
            case 1:
                higher = "Virginica";
                break;
            case 2:
                higher = "Verscicolor";
                break;
            default:
                higher = "error";
        }
        return higher;
    }
}