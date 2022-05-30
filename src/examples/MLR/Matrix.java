package examples.MLR;

public class Matrix{

    public double[][] multiply(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
  
        if (a[0].length == b.length) {// se comprueba si las matrices se pueden multiplicar
          for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
              for (int k = 0; k < a[0].length; k++) {
                c[i][j] += a[i][k] * b[k][j];// aquí se multiplica la matriz
              }
            }
          }
        }
        return c;
      }
  
      public double[][] matrizTranspuesta(double[][] matriz) {
        double[][] transpuesta = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
          for (int j = 0; j < matriz[i].length; j++) {
            transpuesta[j][i] = matriz[i][j];
          }
        }
        return transpuesta;
      }
  
      public double [][] inverse(double [][] matriz){
        double matrizInversa[][] = new double [matriz.length][matriz[0].length];
        double pivote, aux;

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matrizInversa[i][j] = 0;
                if(i == j){
                    matrizInversa[i][j] = 1;
                }
            }
        }

        for(int i=0; i<matriz.length; i++){
            pivote = matriz[i][i];

            for(int k=0; k<matriz.length; k++){
                matriz[i][k] = matriz[i][k]/pivote;
                matrizInversa[i][k] = matrizInversa[i][k]/pivote;
            }

            for(int j=0; j<matriz.length; j++){
                if(i != j){
                    aux = matriz[j][i];

                    for(int k=0; k<matriz.length; k++){
                        matriz[j][k] = matriz[j][k] - aux * matriz[i][k];
                        matrizInversa[j][k] = matrizInversa[j][k] - aux * matrizInversa[i][k];
                    }
                }
            }
        }

        return matrizInversa;
    }

  
      public void multiplicarMatriz(double n, double[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
          for (int j = 0; j < matriz.length; j++)
            matriz[i][j] *= n;
      }
      
    
}